FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.14.18"
KBRANCH ?= "linux-4.14.y"
SRCREV ?= "81d0cc85caabe062991ea45ddada814835d47fb0"

require linux-stable.inc
