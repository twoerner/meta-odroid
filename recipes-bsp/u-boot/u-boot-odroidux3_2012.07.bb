require u-boot-hardkernel.inc

DESCRIPTION = "u-boot bootloader for Odroid UX3 devices supported by the hardkernel product"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PROVIDES += "u-boot"

SRCREV = "3acd50c296398bbba16dc6dd964d3ee36a4c85f5"
BRANCH = "odroidxu3-v2012.07"

UBOOT_MACHINE_odroid-ux3 = "odroid_config"
RDEPENDS_${PN} = "secure-odroid-ux3"
