#
# NFS_LOCATION: 
#   local: NFS mount on this machine
#   remote: NFS exported from a remote system not mounted on this system
#
# NFS_EXPORT_DIR - location where to copy things to
# NFS_SERVERIP - your remote NFS server host
# NFS_SERVERIP_USER - User account on remote NFS server
# NFS_SERVERIP_PSWDFILE - Password used for NFS_SERVERIP_USER on NFS_SERVERIP
# NFS_MACHINE_NAME - main filename used as the common mounted dir from machine
#
# NFS_DEST_DIR -  Name of where new builds are copied too.
#
# SSHPASS - where to find the sshpass binary, defaults to the systme one
#
#
USING_NFS = "${@bb.utils.contains_any('IMAGE_FSTYPES', 'nfs ', '1', '', d)}"

# local, remote, native
#
NFS_LOCATION ?= "local"  

NFS_EXPORT_DIR ?= "${TOPDIR}/nfs/"
NFS_SERVERIP ?= ""
NFS_SERVERIP_USER ?= ""
NFS_SERVERIP_PSWDFILE ?= "${NFS_EXPORT_DIR}.nfs"
NFS_MACHINE_NAME ?= "${MACHINE}"
NFS_DEST_DIR ?= "${IMAGE_NAME}"
SSHPASS ?= "/usr/bin/sshpass"

generate_exportfs_file () {
    # Auto generate sample exportfs
    mkdir -p  ${TOPDIR}/nfs
    echo "${NFS_EXPORT_DIR} *(rw,no_root_squash,insecure,no_all_squash,no_subtree_check)" > ${TOPDIR}/nfs/example.exportfs
}

generate_local_nfs () {

    if [ ! -d "${NFS_EXPORT_DIR}" ]; then
        bberror "NFS export dir does not exists"
    else
        rsync -rltDPv --chown=${USER}:${GROUPS} ${IMAGE_ROOTFS}/* ${NFS_EXPORT_DIR}${NFS_DEST_DIR}

        rm -f ${NFS_EXPORT_DIR}${}
        ln -s ${NFS_EXPORT_DIR}${NFS_DEST_DIR} ${NFS_EXPORT_DIR}${NFS_MACHINE_NAME}
    fi
}

generate_remote_nfs () {

    ${SSHPASS} -f${NFS_SERVERIP_PSWDFILE} ssh -o StrictHostKeyChecking=no ${NFS_SERVERIP_USER}@${NFS_SERVERIP} "mkdir ${NFS_EXPORT_DIR}${NFS_DEST_DIR}"

    ${SSHPASS} -f${NFS_SERVERIP_PSWDFILE} rsync -rltDPv --rsh="ssh -o StrictHostKeyChecking=no"  ${IMAGE_ROOTFS}/* ${NFS_SERVERIP_USER}@${NFS_SERVERIP}:${NFS_EXPORT_DIR}${NFS_DEST_DIR}

    ${SSHPASS} -f ${NFS_SERVERIP_PSWDFILE} ssh -o StrictHostKeyChecking=no ${NFS_SERVERIP_USER}@${NFS_SERVERIP} "rm -f ${NFS_EXPORT_DIR}${NFS_MACHINE_NAME}"

    ${SSHPASS} -f ${NFS_SERVERIP_PSWDFILE} ssh -o StrictHostKeyChecking=no ${NFS_SERVERIP_USER}@${NFS_SERVERIP} "ln -s ${NFS_EXPORT_DIR}${NFS_DEST_DIR} ${NFS_EXPORT_DIR}${NFS_MACHINE_NAME}"

}

generate_native_nfs () {
        bberror "Native NFS supported, try local."
}

NFS_EXPORT_CMD_LOCAL ?= "generate_local_nfs"
NFS_EXPORT_CMD_REMOTE ?= "generate_remote_nfs"
NFS_EXPORT_CMD_NATIVE ?= "generate_native_nfs"
NFS_CFGFILE ?= "generate_exportfs_file"

IMAGE_CMD_nfs () {

    if [ "${NFS_LOCATION}" = "local" ]; then
	${NFS_EXPORT_CMD_LOCAL}
    elif [ "${NFS_LOCATION}" = "remote" ]; then
        # remote means the nfs server is on a different system than this and the rootfs
        # has to be copied over to it    
	${NFS_EXPORT_CMD_REMOTE}
    elif [ "${NFS_LOCATION}" = "native" ]; then
        # native is using the user mode nfsd found in the sdk
	${NFS_EXPORT_CMD_NATIVE}
    else
        bberror "Invalide NFS type selected: local, remote or native."
    fi
    ${NFS_CFGFILE}
}

do_image_nfs[depends] += "rsync-native:do_populate_sysroot"
do_image_nfs[depends] += "sshpass-native:do_populate_sysroot"
do_image_nfs[depends] += "acl-native:do_populate_sysroot"

# This variable is available to request which values are suitable for IMAGE_FSTYPES
IMAGE_TYPES += " nfs"
