FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.0.9"
SRCREV ?= "e4abcebedac3415cf347e95749209a4a7b6f3074"
SRCREV_meta ?= "ffd8cf5baf8e741b8987b72c942ce3b9cc7c7f30"

require linux-stable.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
