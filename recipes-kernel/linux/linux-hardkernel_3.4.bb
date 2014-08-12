inherit kernel
require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "odroid-xu"
COMPATIBLE_MACHINE_odroid-xu = "odroid-xu"

LINUX_VERSION = "3.4"
LINUX_VERSION_EXTENSION = "-custom"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}"

# from where to fetch the kernel
KERNEL_REPO_OWNER ??= "hardkernel"
KERNEL_REPO_URI ??= "git://github.com/${KERNEL_REPO_OWNER}/linux.git"
KBRANCH = "odroidxu-3.4.y"

SRCREV = "${AUTOREV}"

PR = "r2"
PV = "${LINUX_VERSION}"

SRC_URI = " \
  ${KERNEL_REPO_URI};nocheckout=1;branch=${KBRANCH} \
  file://defconfig \
  file://make_sd.sh \
"

do_deploy_append() {
    install -d ${DEPLOYDIR}		   
    cd ${S}/tools/hardkernel/u-boot-pre-built		
    cp -v *bl1* ${DEPLOYDIR}
    cp -v *bl2* ${DEPLOYDIR}
    cp -v u-boot.bin ${DEPLOYDIR}
    cp -v *tzsw* ${DEPLOYDIR}
    cp -v sd_fusing.sh ${DEPLOYDIR}  
    cp -v ${WORKDIR}/make_sd.sh ${DEPLOYDIR}
}
