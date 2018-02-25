FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.14.22"
KBRANCH ?= "linux-4.14.y"
SRCREV ?= "55b195735142c1a8ffccb21a4af0b1bd8bd4d1eb"

require linux-stable.inc

SRC_URI += "file://meson64.scc \
            file://touchscreen.cfg \
"
