DESCRIPTION = "Create u-boot boot config file"
SECTION = "bootloaders"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

inherit uboot-boot-scr

USE_BOOTSRC = "0"

S = "${WORKDIR}"

do_patch[noexec] = "1"
do_configure[noexec] = "1"


PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(odroid-c2|odroid-xu3|odroid-xu4|odroid-xu3-lite)"
