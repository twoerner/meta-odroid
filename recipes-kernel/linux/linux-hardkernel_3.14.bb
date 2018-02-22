FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "3.14.79"
KBRANCH ?= "odroidc2-3.14.y"
SRCREV ?= "30e08c75085210d7245735ab3cf585b92f86397c"
KBUILD_DEFCONFIG_odroid-c2 = "odroidc2_defconfig"

require linux-stable.inc
SRC_URI_odroid-c2 = "\
    git://github.com/hardkernel/linux;branch=${KBRANCH} \
"
# Enable 3.5' TFT Screen
KERNEL_MODULE_AUTOLOAD_append_odroid-c2 = " aml_i2c pwm-meson pwm-ctrl fbtft_device flexfb sx865x "
module_conf_fbtft_device = "options fbtft_device name=flexpfb rotate=270"
module_conf_flexfb = "options flexfb chip=ili9488"
KERNEL_MODULE_PROBECONF += "fbtft_device flexfb"
