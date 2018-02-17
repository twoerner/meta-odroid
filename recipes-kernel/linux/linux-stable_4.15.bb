FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.15.4"
KBRANCH ?= "linux-4.15.y"
SRCREV ?= "bb61956d9d9fec64e6619470faafe10dadc43ecb"

require linux-stable.inc
