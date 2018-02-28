FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.15.7"
KBRANCH ?= "linux-4.15.y"
SRCREV ?= "cb4a115a42867def71fdcbf0d7b714f268ff37fd"

require linux-stable.inc
