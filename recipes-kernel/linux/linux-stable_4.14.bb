FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.14.19"
KBRANCH ?= "linux-4.14.y"
SRCREV ?= "1722fe3727845178e5d7fe3fdf35b8a5de230fdf"

require linux-stable.inc
