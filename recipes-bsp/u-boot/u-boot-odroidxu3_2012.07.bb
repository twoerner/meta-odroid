require u-boot-hardkernel.inc

DESCRIPTION = "u-boot bootloader for Odroid XU3 devices supported by the hardkernel product"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PROVIDES += "u-boot"

SRCREV = "fe2f831fd44a4071f58a42f260164544697aa666"
BRANCH = "odroidxu3-v2012.07"

UBOOT_MACHINE_odroid-xu3 = "odroid_config"
RDEPENDS_${PN} = "secure-odroid-xu3"
