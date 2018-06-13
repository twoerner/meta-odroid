FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.17.1"
KBRANCH ?= "linux-4.17.y"
SRCREV ?= "d0c077266ecbe4ebbaac24c0fe5bd81c5304c5a2"

require linux-stable.inc

SRC_URI_append = " file://odroid.scc"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

DEPENDS += "openssl-native util-linux-native"

do_configure_prepend() {
    cp ${WORKDIR}/${O_KERNEL_CONFIG}/defconfig ${B}/.config
}
