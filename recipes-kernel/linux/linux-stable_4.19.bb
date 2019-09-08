FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.19.71"
SRCREV ?= "e7d2672c66e4d3675570369bf20856296da312c4"
SRCREV_meta ?= "e73568c48e08a0cefa34a689e2f06f60abd17aec"

require linux-stable.inc

SRC_URI_append = " file://meson/meson64.scc"
SRC_URI_append = " ${@bb.utils.contains("MACHINE_FEATURES", "ilp32", "file://ilp32/arm64_ilp32.scc", "",d)}"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

