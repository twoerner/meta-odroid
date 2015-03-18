require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "U-Boot-Hardkernel - git repo"
HOMEPAGE = "http://hardkernel.com"
SECTION = "bootloaders"
PROVIDES = "virtual/bootloader"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://../git/COPYING;md5=1707d6db1d42237583f50183a5651ecb"

# from where to fetch the u-boot
UBOOT_REPO_URI ??= "git://github.com/hardkernel/u-boot.git"
UBOOT_BRANCH ?= "odroid-v2012.07"

SRC_URI = " \
  ${UBOOT_REPO_URI};branch=${UBOOT_BRANCH} \
  file://sd_fusing.sh \
  file://bl1.hardkernel.bin.signed \
  file://bl2.hardkernel.bin.signed \
  file://tzsw.hardkernel.bin.signed \
  file://boot.ini \
"

S = "${WORKDIR}/git"
SRCREV = "${AUTOREV}"

UBOOT_SUFFIX = "bin"

do_deploy_append () {
    install -d ${DEPLOYDIR}
    cp -v ${WORKDIR}/*bl1* ${DEPLOYDIR}
    cp -v ${WORKDIR}/boot.ini ${DEPLOYDIR}
    cp -v ${WORKDIR}/*bl2* ${DEPLOYDIR}
    cp -v ${WORKDIR}/*tzsw* ${DEPLOYDIR}
    cp -v ${WORKDIR}/sd_fusing.sh ${DEPLOYDIR}
}

COMPATIBLE_MACHINE = "(odroid-xu)"

PACKAGE_ARCH = "${MACHINE_ARCH}"
