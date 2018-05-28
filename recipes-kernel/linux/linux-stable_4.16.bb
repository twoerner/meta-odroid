FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.16.12"
KBRANCH ?= "linux-4.16.y"
SRCREV ?= "e2a75b6d2e9de22858bb2bfa14fea56a2c6e4761"

require linux-stable.inc

DEPENDS += "openssl-native util-linux-native"

SRC_URI_append = " file://odroid.scc"

do_configure_prepend() {
    cp ${WORKDIR}/${O_KERNEL_CONFIG}/defconfig ${B}/.config
}
