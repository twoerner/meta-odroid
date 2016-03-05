inherit kernel
require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

KBRANCH ?= "linux-4.4.y"
SRCREV ?= "0d1912303e54ed1b2a371be0bba51c384dd57326"

KBRANCH_odroid-xu3 ?= "linux-4.4.y"
SRCREV_machine_odroid-xu3 ?= "0d1912303e54ed1b2a371be0bba51c384dd57326"

KERNEL_DEVICETREE_odroid-xu3 = "exynos5422-odroidxu3.dtb"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;bareclone=1;branch=${KBRANCH}"

SRC_URI += "file://defconfig"

LINUX_VERSION = "4.4.6"
PV = "${LINUX_VERSION}+git${SRCPV}"

KCONF_BSP_AUDIT_LEVEL = "0"

COMPATIBLE_MACHINE_odroid-xu3  = "odroid-xu3"
