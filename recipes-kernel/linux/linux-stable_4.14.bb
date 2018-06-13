FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.14.49"
KBRANCH ?= "linux-4.14.y"
SRCREV ?= "70d7bbd9b504c1dde0dc44a469a513695d9cbdd6"

require linux-stable.inc

SRC_URI += "file://meson64.scc \
            file://touchscreen.cfg \
"
