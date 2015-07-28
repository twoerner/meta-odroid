require u-boot-hardkernel.inc

DESCRIPTION = "u-boot bootloader for Odroid UX3 devices supported by the hardkernel product"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PROVIDES += "u-boot"

SRCREV = "d80b05d5624ecba99c15ee2a7b3f59ebf6f8f1e8"
BRANCH = "odroidxu3-v2012.07"

UBOOT_MACHINE_odroid-ux3 = "odroid_config"

RDEPENDS_${PN} = "secure-odroid-ux3"
