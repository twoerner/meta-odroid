FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.15.3"
KBRANCH ?= "linux-4.15.y"
SRCREV ?= "e6e2d12fa46bd5869576c4801ff4d80a4981107d"

require linux-stable.inc
