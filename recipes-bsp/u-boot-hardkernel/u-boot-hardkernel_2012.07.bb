require u-boot.inc

DESCRIPTION = "U-Boot-Hardkernel - git repo"
HOMEPAGE = "http://hardkernel.com"
SECTION = "bootloaders"
PROVIDES = "virtual/bootloader"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://../git/COPYING;md5=1707d6db1d42237583f50183a5651ecb"

# from where to fetch the u-boot
UBOOT_REPO_URI ??= "git://github.com/hardkernel/u-boot.git"
UBOOT_BRANCH ?= "odroid-v2012.07"

#PV = "2012.07"

SRC_URI = " \
  ${UBOOT_REPO_URI};branch=${UBOOT_BRANCH} \
  file://install-on-sdcard.sh \
"

S = "${WORKDIR}/git"
SRCREV = "${AUTOREV}"


#do_deploy () {
#    install -d ${DEPLOYDIR}
#    cp -v *bl1* ${DEPLOYDIR}/BL1.bin
#    cp -v *bl2* ${DEPLOYDIR}/BL2.bin
#    cp -v u-boot.bin ${DEPLOYDIR}/u-boot.bin
#    cp -v *tzsw*.bin ${DEPLOYDIR}/TZSW.bin
#    cp -v ${WORKDIR}/install-on-sdcard.sh ${DEPLOYDIR}
#}

#addtask deploy
