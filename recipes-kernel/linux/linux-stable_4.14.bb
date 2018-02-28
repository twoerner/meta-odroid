FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.14.23"
KBRANCH ?= "linux-4.14.y"
SRCREV ?= "267ef1d332845c1d361ff3fd1d346613a12db773"

require linux-stable.inc

SRC_URI += "file://meson64.scc \
            file://touchscreen.cfg \
"
