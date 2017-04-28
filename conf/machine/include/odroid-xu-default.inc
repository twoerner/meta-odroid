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
PREFERRED_VERSION_u-boot ?= "2017.01%"

UBOOT_FDTADDR = "40800000"
UBOOT_INITADDR = "42000000"

IMAGE_CLASSES += "image_types_odroid"
