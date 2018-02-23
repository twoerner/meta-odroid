FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.15.5"
KBRANCH ?= "linux-4.15.y"
SRCREV ?= "a6c3a2a210729c9c2a07fdfc366c353b5e3dd305"

require linux-stable.inc
