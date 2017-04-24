DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

DEPENDS = "lzop-native"

inherit kernel siteinfo
require recipes-kernel/linux/linux-yocto.inc

SRC_URI += "file://${O_KERNEL_CONFIG}/defconfig"

PV = "${LINUX_VERSION}+git${SRCPV}"

KCONF_BSP_AUDIT_LEVEL = "0"
