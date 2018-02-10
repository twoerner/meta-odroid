FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.15.2"
KBRANCH ?= "linux-4.15.y"
SRCREV ?= "db22ec452bb4ab9f3ecff00fe935da17d048f14d"

require linux-stable.inc
