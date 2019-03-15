FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.0.2"
KBRANCH ?= "linux-5.0.y"
MBRANCH ?= "yocto-5.0"
SRCREV ?= "9e6fdea016e45c5feab60589241e0d3607d39945"

require linux-stable.inc

SRCREV_meta ?= "8ae7073a934d80c4f4b808bc01884777454aae8f"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

