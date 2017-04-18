inherit kernel
require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

KBRANCH ?= "odroidc2-3.14.y"
SRCREV ?= "8211a219ee5316a5a45cd99b83acd98ebe32606d"

KBRANCH_odroid-c2 ?= "odroidc2-3.14.y"
SRCREV_machine_odroid-c2 ?= "8211a219ee5316a5a45cd99b83acd98ebe32606d"



#KERNEL_DEVICETREE_odroid-c2 = "meson64_odroidc2.dtb"

SRC_URI = "git://github.com/hardkernel/linux.git;branch=${KBRANCH}"

SRC_URI += " \
	file://add_uboot.patch \
	file://0001-compiler-gcc-integrate-the-various-compiler-gcc-345-.patch \
	file://defconfig"

PV = "3.14.65+git${SRCPV}"

KCONF_BSP_AUDIT_LEVEL = "0"

do_compile_append() {
	oe_runmake dtbs 
}

inherit deploy

do_deploy_append() {
	install -d ${DEPLOYDIR}
	install ${B}/arch/arm64/boot/dts/meson64_odroidc2.dtb ${DEPLOYDIR}/.
}

COMPATIBLE_MACHINE = "(odroid-c2)"
