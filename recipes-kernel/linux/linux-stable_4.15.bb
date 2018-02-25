FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.15.6"
KBRANCH ?= "linux-4.15.y"
SRCREV ?= "1a7aef62b47b00630e62a268d647f54ec93fb38c"

require linux-stable.inc
