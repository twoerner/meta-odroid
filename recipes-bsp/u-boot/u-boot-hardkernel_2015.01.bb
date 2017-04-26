DESCRIPTION = "Odroid C2 boot loader supported by the hardkernel product"
SECTION = "bootloaders"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-2015-01:"

PROVIDES = "u-boot"

SRC_URI = " \
	file://boot.ini \
	file://u-boot.bin \
	file://bl1.bin.hardkernel \
	"

inherit deploy

S = "${WORKDIR}"

do_patch[noexec] = "1"
do_configure[noexec] = "1"

do_compile () {
	sed -i 's/UBOOT_LOADADDR/${UBOOT_LOADADDR}/'  ${S}/boot.ini
	sed -i 's/UBOOT_DTB_LOADADDR/${UBOOT_DTB_LOADADDR}/'  ${S}/boot.ini
	sed -i 's/UBOOT_BOOT_CMD/${UBOOT_BOOT_CMD}/'  ${S}/boot.ini
	sed -i 's/UBOOT_CONSOLE/${UBOOT_CONSOLE}/'  ${S}/boot.ini
	sed -i 's/KERNEL_DEVICETREE_FN/${KERNEL_DEVICETREE_FN}/'  ${S}/boot.ini
}


do_deploy () {
    install -d ${DEPLOYDIR}
    install -m 755  ${S}/boot.ini ${DEPLOYDIR}
    install -m 755  ${S}/bl1.bin.hardkernel ${DEPLOYDIR}
    install -m 755  ${S}/u-boot.bin ${DEPLOYDIR}
}

addtask deploy before do_build after do_compile

COMPATIBLE_MACHINE = "(odroid-c2)"
UBOOT_MACHINE_odroid-c2 = "odroidc2_config"
