FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.16.1"
KBRANCH ?= "linux-4.16.y"
SRCREV ?= "11454943b264b548e714d8edf932ebf306e5f808"

require linux-stable.inc

SRC_URI_append = " file://odroid.scc"
SRC_URI_append_odroid-xu3 = " file://${O_KERNEL_CONFIG}/fb.cfg"
SRC_URI_append_odroid-xu3-lite = " file://${O_KERNEL_CONFIG}/fb.cfg"
SRC_URI_append_odroid-xu4 = " file://${O_KERNEL_CONFIG}/fb.cfg"
