FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

LINUX_VERSION ?= "4.16-rc5"
KBRANCH ?= "master"
SRCREV ?= "0c8efd610b58cb23cefdfa12015799079aef94ae"

require linux-mainline.inc

SRC_URI_append_odroid-xu3 = " file://${O_KERNEL_CONFIG}/fb.cfg"
SRC_URI_append_odroid-xu3-lite = " file://${O_KERNEL_CONFIG}/fb.cfg"
SRC_URI_append_odroid-xu4 = " file://${O_KERNEL_CONFIG}/fb.cfg"
