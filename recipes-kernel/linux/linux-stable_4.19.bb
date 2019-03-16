FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.19.29"
SRCREV ?= "ce194fa2b267e2018f42442347d90df01c4071d6"

require linux-stable.inc

SRCREV_meta ?= "83d017da0cc6c84b0167eafcf2811d0717c35b86"

SRC_URI_append = " file://meson/meson64.scc"
SRC_URI_append = " ${@bb.utils.contains("MACHINE_FEATURES", "ilp32", "file://ilp32/arm64_ilp32.scc", "",d)}"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

