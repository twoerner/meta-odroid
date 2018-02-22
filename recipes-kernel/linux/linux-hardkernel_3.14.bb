FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "3.14.79"
KBRANCH ?= "odroidc2-3.14.y"
SRCREV ?= "30e08c75085210d7245735ab3cf585b92f86397c"
KBUILD_DEFCONFIG_odroid-c2 = "odroidc2_defconfig"

require linux-stable.inc
SRC_URI_odroid-c2 = "\
    git://github.com/hardkernel/linux;branch=${KBRANCH} \
"

