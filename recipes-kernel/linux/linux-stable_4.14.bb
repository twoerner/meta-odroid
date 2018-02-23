FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.14.21"
KBRANCH ?= "linux-4.14.y"
SRCREV ?= "58056a531e440061142a4481358ebb365193df5e"

require linux-stable.inc

SRC_URI += "file://meson64.scc \
            file://touchscreen.cfg \
"
