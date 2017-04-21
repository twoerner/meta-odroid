DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

DEPENDS = "lzop-native"

inherit kernel siteinfo
require recipes-kernel/linux/linux-yocto.inc

SRC_URI += "file://defconfig"

PV = "${LINUX_VERSION}+git${SRCPV}"

KCONF_BSP_AUDIT_LEVEL = "0"

COMPATIBLE_MACHINE_odroid-xu3  = "odroid-xu3"
COMPATIBLE_MACHINE_odroid-xu4  = "odroid-xu4"
COMPATIBLE_MACHINE_odroid-xu3-lite  = "odroid-xu3-lite"
