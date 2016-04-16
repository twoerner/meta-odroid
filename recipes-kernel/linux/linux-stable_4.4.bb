inherit kernel
require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

KBRANCH ?= "linux-4.4.y"
SRCREV ?= "b40108b826ed9e1c558f73b9dbabb8d80ded268b"

KBRANCH_odroid-xu3 ?= "linux-4.4.y"
SRCREV_machine_odroid-xu3 ?= "b40108b826ed9e1c558f73b9dbabb8d80ded268b"

KERNEL_DEVICETREE_odroid-xu3 = "exynos5422-odroidxu3.dtb"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;bareclone=1;branch=${KBRANCH}"

SRC_URI += "file://defconfig"

LINUX_VERSION = "4.4.7"
PV = "${LINUX_VERSION}+git${SRCPV}"

KCONF_BSP_AUDIT_LEVEL = "0"

COMPATIBLE_MACHINE_odroid-xu3  = "odroid-xu3"
