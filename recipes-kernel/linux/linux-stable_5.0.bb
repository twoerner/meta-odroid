FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.0.10"
SRCREV ?= "d3da1f09fff27b3ae5908119dab312b9baec09e0"
SRCREV_meta ?= "ffd8cf5baf8e741b8987b72c942ce3b9cc7c7f30"

require linux-stable.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
