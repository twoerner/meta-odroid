DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

DEPENDS = "lzop-native"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=${KBRANCH}"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc


PV = "${LINUX_VERSION}+git${SRCPV}"

KCONF_BSP_AUDIT_LEVEL = "0"
DEPENDS += "openssl-native util-linux-native"

SRC_URI_append = " git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${MBRANCH};destsuffix=${KMETA}"
SRC_URI_append = " file://odroid-kmeta;type=kmeta;name=odroid-kmeta;destsuffix=odroid-kmeta"

SRC_URI_append = " file://odroid/odroid.scc"

KMETA = "kernel-meta"
KMACHINE_odroid-hc1 = "odroid-hc1"
KMACHINE_odroid-xu3 = "odroid-xu3"
KMACHINE_odroid-xu3-lite = "odroid-xu3-lite"
KMACHINE_odroid-xu4 = "odroid-xu4"
KMACHINE_odroid-c2 = "odroid-c2"
KMACHINE_odroid-c1 = "odroid-c1"

COMPATIBLE_MACHINE = "(odroid-c1|odroid-c2|odroid-xu3|odroid-xu4|odroid-xu3-lite|odroid-hc1|odroid-h2)"
