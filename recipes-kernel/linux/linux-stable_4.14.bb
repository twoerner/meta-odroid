FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.14.44"
KBRANCH ?= "linux-4.14.y"
SRCREV ?= "102b97d6241d938ac153193504a5936fc0be27ed"

require linux-stable.inc

SRC_URI += "file://meson64.scc \
            file://touchscreen.cfg \
"
