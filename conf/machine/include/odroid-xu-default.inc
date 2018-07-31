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
UBOOT_XTRA_CMDLINE = "usbhid.quirks=0x0eef:0x0005:0x0004"

WKS_FILE ?= "odroid_xu-u-boot.wks"

EXTRA_IMAGEDEPENDS += "secure-odroid"
MACHINE_FEATURES_append = " alsa screen"

PREFERRED_PROVIDER_virtual/egl = "mali-t62x"
PREFERRED_PROVIDER_virtual/libgbm = "mali-t62x"
PREFERRED_PROVIDER_virtual/libgles1 = "mali-t62x"
PREFERRED_PROVIDER_virtual/libgles2 = "mali-t62x"
PREFERRED_PROVIDER_virtual/libopencl = "mali-t62x"
PREFERRED_PROVIDER_virtual/libgl = "mesa"
PREFERRED_PROVIDER_virtual/mesa = "mesa"

MALI = "\
    kernel-module-mali-t62x \
    mali-t62x\
"

XSERVER ?= " \
    xserver-xorg \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'xserver-xorg-extension-glx', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'mali', 'xf86-driver-armsoc', '', d)} \
    xf86-video-fbdev \
    xf86-video-modesetting \
    xf86-input-evdev \
    xf86-input-mouse \
    xf86-input-keyboard \
    xserver-xorg-module-libint10 \
"
