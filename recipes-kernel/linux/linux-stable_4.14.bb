FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.14.24"
KBRANCH ?= "linux-4.14.y"
SRCREV ?= "6e4548ea58e6a5ed2dd3a417d991742e2dec0246"

require linux-stable.inc

SRC_URI += "file://meson64.scc \
            file://touchscreen.cfg \
"
