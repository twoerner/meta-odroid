FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.14.27"
KBRANCH ?= "linux-4.14.y"
SRCREV ?= "9b1fb9cc922dbf27959287ad75009bb388d115fe"

require linux-stable.inc

SRC_URI += "file://meson64.scc \
            file://touchscreen.cfg \
"
