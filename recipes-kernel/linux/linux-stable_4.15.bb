FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.15.10"
KBRANCH ?= "linux-4.15.y"
SRCREV ?= "df57458873da1a2a52e31c96cff43942c3557037"

require linux-stable.inc
