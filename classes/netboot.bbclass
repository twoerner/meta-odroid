#
#
#
#
# You can try it out like this:
# - build a core-image-sato image
# - then bitbake core-image-sato -c netboot. That will run the uploading steps.
#
# Uploading NETBOOT aritfacts can be run automatically each time an image is built if you set
# NETBOOT_AUTO = "1"
#
# NETBOOT_LOCATION:
#   local: NETBOOT mount on this machine
#   remote: NETBOOT exported from a remote system not mounted on this system
#
# NETBOOT_EXPORT_DIR - location where to copy things to
# NETBOOT_SERVERIP - your remote NETBOOT server host
# NETBOOT_SERVERIP_USER - User account on remote NETBOOT server
# NETBOOT_SERVERIP_PSWDFILE - Password used for NETBOOT_SERVERIP_USER on NETBOOT_SERVERIP
# NETBOOT_MACHINE_NAME - main filename used as the common mounted dir from machine
#
# NETBOOT_DEST_DIR -  Name of where new builds are copied too.
#
# SSHPASS - where to find the sshpass binary, defaults to the systme one

NETBOOT_AUTO ??= "0"

NETBOOT ?= ""
NETBOOT_DIR ?= "${TOPDIR}/tftpboot/"

EXAMPLE_NETBOOT_DIR ?= "${TOPDIR}/tftpboot/"

# local, remote
#
NETBOOT_LOCATION ?= "local"  
NETBOOT_SERVERIP ?= ""  
NETBOOT_RUSER ?= ""  
NETBOOT_PSWDFILE ?= "${EXAMPLE_NETBOOT_DIR}.netboot"
NETBOOT_DEST ?= "${IMAGE_NAME}"
NEYBOOT_MACHINE_NAME ?= "${MACHINE}"
SSHPASS ?= "/usr/bin/sshpass"

do_netboot[depends] += "virtual/kernel:do_deploy virtual/bootloader:do_deploy"

generate_local_tftpd () {
    if [ ! -d ${NETBOOT_DIR} ]; then
        bwarn "tftpboot dir does not exist"
    else
        mkdir -p ${NETBOOT_DIR}${NETBOOT_DEST}
        cp ${IMAGE_ROOTFS}/boot/*  ${NETBOOT_DIR}${NETBOOT_DEST}/. 

        rm -f ${NETBOOT_DIR}${NEYBOOT_MACHINE_NAME}
        ln -s ${NETBOOT_DIR}${NETBOOT_DEST} ${NETBOOT_DIR}${NEYBOOT_MACHINE_NAME}
    fi
}

generate_remote_tftpd () {
    # add pswd file check
    # add sshpass check
    
    bbnote "Remote tftpd."

    ${SSHPASS} -f ${NETBOOT_PSWDFILE} ssh ${NETBOOT_RUSER}@${NETBOOT_SERVERIP} "mkdir -p ${NETBOOT_DIR}${NETBOOT_DEST}"

    ${SSHPASS} -f ${NETBOOT_PSWDFILE} scp -r ${IMAGE_ROOTFS}/boot/*  ${NETBOOT_RUSER}@${NETBOOT_SERVERIP}:${NETBOOT_DIR}${NETBOOT_DEST}/.

    ${SSHPASS} -f ${NETBOOT_PSWDFILE} ssh ${NETBOOT_RUSER}@${NETBOOT_SERVERIP} "rm -f ${NETBOOT_DIR}${NEYBOOT_MACHINE_NAME}"
    ${SSHPASS} -f ${NETBOOT_PSWDFILE} ssh ${NETBOOT_RUSER}@${NETBOOT_SERVERIP} "ln -s ${NETBOOT_DIR}${NETBOOT_DEST} ${NETBOOT_DIR}${NEYBOOT_MACHINE_NAME}"
}

# create an tftpd entry

generate_tftp () {
    mkdir -p ${EXAMPLE_NETBOOT_DIR}
    cat > ${EXAMPLE_NETBOOT_DIR}example.tftp <<EOF 
#
# Auto Generated
#
service tftp
{
protocol        = udp
port            = 69
socket_type     = dgram
wait            = yes
user            = nobody
disable         = no

server          = /usr/sbin/in.tftpd
server_args     = /tftpboot
EOF
echo "}" >> ${EXAMPLE_NETBOOT_DIR}example.tftp

}


TFTPD_CMD_LOCAL ?= "generate_local_tftpd"
TFTPD_CMD_REMOTE ?= "generate_remote_tftpd"
TFTP_CFGFILE ?= "generate_tftp"

create_tftpd() {

    if [ "${NETBOOT_LOCATION}" = "local" ]; then
	${TFTPD_CMD_LOCAL}
    elif [ "${NETBOOT_LOCATION}" = "remote" ]; then
        # remote means the nfs server is on a different system than this and the rootfs
        # has to be copied over to it    
	${TFTPD_CMD_REMOTE}
    else
        bberror "Invalide netboot type selected: local or remote."
    fi
    ${TFTP_CFGFILE}
}

python do_netboot() {
    boot_method = d.getVar('NETBOOT')
    if boot_method == "tftp":
        bb.build.exec_func('create_tftpd', d) 
    else:
        bb.warn("Invalid NETBOOT parameter")
}

python () {
    if oe.types.boolean(d.getVar("NETBOOT_AUTO") or "False"):
        bb.build.addtask("netboot", "do_build", "do_image_complete", d)
}
