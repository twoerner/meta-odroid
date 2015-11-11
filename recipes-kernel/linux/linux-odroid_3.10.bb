inherit kernel
require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.10:"

KBRANCH_odroid-xu3 ?= "odroidxu3-3.10.y"

SRCREV_odroid-xu3 ?= "30cd82480f257905c418b32735425585b15cebdd"

SRC_URI = "git://github.com/hardkernel/linux.git;branch=${KBRANCH}"

SRC_URI += "file://defconfig"

LINUX_VERSION_odroid-xu3 ?= "3.10.81"
LINUX_VERSION_EXTENSION_odroid-xu3 ?= "odroid-xu3"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "odroid-xu3"
