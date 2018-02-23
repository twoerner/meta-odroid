FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.14.20"
KBRANCH ?= "linux-4.14.y"
SRCREV ?= "7e83b2ff485cacbf73d27f821e07a8c78ad8cc68"

require linux-stable.inc

SRC_URI += "file://meson64.scc \
            file://touchscreen.cfg \
"
