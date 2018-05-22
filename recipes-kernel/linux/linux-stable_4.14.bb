FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.14.42"
KBRANCH ?= "linux-4.14.y"
SRCREV ?= "d88700f79448fc8f03617d4f1929c39676f8d1e4"

require linux-stable.inc

SRC_URI += "file://meson64.scc \
            file://touchscreen.cfg \
"
