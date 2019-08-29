FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.2.10"
SRCREV ?= "f7d5b3dc4792a5fe0a4d6b8106a8f3eb20c3c24c"
SRCREV_meta ?= "b53e99257175fd6f41f31e5ebec46c1bd11076b8"

require linux-stable.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
