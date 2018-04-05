FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.16.0"
KBRANCH ?= "linux-4.16.y"
SRCREV ?= "0adb32858b0bddf4ada5f364a84ed60b196dbcda"

require linux-stable.inc

SRC_URI_append = " file://odroid.scc"
SRC_URI_append_odroid-xu3 = " file://${O_KERNEL_CONFIG}/fb.cfg"
SRC_URI_append_odroid-xu3-lite = " file://${O_KERNEL_CONFIG}/fb.cfg"
SRC_URI_append_odroid-xu4 = " file://${O_KERNEL_CONFIG}/fb.cfg"
