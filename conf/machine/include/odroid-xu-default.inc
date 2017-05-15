# Odroid XU default BSP

include conf/machine/include/samsung-exynos.inc
include conf/machine/include/odroid-default-settings.inc

DEFAULTTUNE = "cortexa15hf-neon"
include conf/machine/include/tune-cortexa15.inc

EXTRA_IMAGEDEPENDS += "u-boot secure-odroid-xu3 u-boot-config"

SERIAL_CONSOLE = "115200 ttySAC2"

#specify u-boot parameters
PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot"
PREFERRED_PROVIDER_u-boot ?= "u-boot"
PREFERRED_VERSION_u-boot ?= "2017.05%"

UBOOT_FDT_LOADADDR ?= "0x40800000"
UBOOT_LOADADDR ?= "0x40007FC0"
UBOOT_CONSOLE ?= "console=ttySAC2,115200"
UBOOT_KENREL_NAME ?= "zimage"

IMAGE_CLASSES += "image_types_odroid"
