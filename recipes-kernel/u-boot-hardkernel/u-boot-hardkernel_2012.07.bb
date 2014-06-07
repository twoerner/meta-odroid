DESCRIPTION = "U-Boot-Hardkernel - git repo"

HOMEPAGE = "http://hardkernel.com"
SECTION = "bootloaders"
PROVIDES = "virtual/bootloader"
LICENSE = "GPLv2"

#PV = "2012.07"

LIC_FILES_CHKSUM = "file://sd_fusing.sh;md5=9343188afe21ccc8e061d6f0fe9a8fd9;endline=10"

# from where to fetch the u-boot
UBOOT_REPO_URI ??= "git://github.com/hardkernel/u-boot.git"
UBOOT_BRANCH ?= "odroid-v2012.07"

SRC_URI = " \
  ${UBOOT_REPO_URI};branch=${UBOOT_BRANCH};protocol=git  \
"

#S = "${WORKDIR}/git/"

SRCREV = "${AUTOREV}"

#KV = "3.4.91"
#PV = "${SRCPV}"
#LOCALVERSION ?= ""

#S = "${WORKDIR}/boot"

