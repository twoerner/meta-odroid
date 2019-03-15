FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.0.1"
KBRANCH ?= "linux-5.0.y"
MBRANCH ?= "yocto-5.0"
SRCREV ?= "283506fcd65de1bc10fcc6e2ca633a7b63171ffa"

require linux-stable.inc

SRCREV_meta ?= "8ae7073a934d80c4f4b808bc01884777454aae8f"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

