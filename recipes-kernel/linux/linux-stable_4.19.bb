FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.19.37"
SRCREV ?= "19bb613acb9ad8e57593cad5118acaee117cc303"
SRCREV_meta ?= "b173a1b0a218f2bebc28251ef08ee592652b6bc0"

require linux-stable.inc

SRC_URI_append = " file://meson/meson64.scc"
SRC_URI_append = " ${@bb.utils.contains("MACHINE_FEATURES", "ilp32", "file://ilp32/arm64_ilp32.scc", "",d)}"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

