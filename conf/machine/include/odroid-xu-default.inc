# Odroid XU default BSP

include conf/machine/include/samsung-exynos.inc
include conf/machine/include/odroid-default-settings.inc

DEFAULTTUNE = "cortexa15hf-neon"
include conf/machine/include/tune-cortexa15.inc

UBOOT_FDT_LOADADDR = "0x40800000"
UBOOT_LOADADDR = "0x40007FC0"
UBOOT_LOADADDRESS = "0x40007FC0"
UBOOT_CONSOLE = "console=ttySAC2,115200"
UBOOT_KERNEL_NAME = "zImage"

WKS_FILE ?= "odroid_xu-u-boot.wks"

#IMAGE_BOOT_FILES = "zImage ${UBOOT_SCRIPT} ${KERNEL_DEVICETREE}"
EXTRA_IMAGEDEPENDS += "secure-odroid"
MACHINE_FEATURES_append = " alsa screen"
