FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.16.10"
KBRANCH ?= "linux-4.16.y"
SRCREV ?= "b3fdf8284efbc5020dfbd0a28150637189076115"

require linux-stable.inc

DEPENDS += "openssl-native util-linux-native"

SRC_URI_append = " file://odroid.scc"

do_configure_prepend() {
    cp ${WORKDIR}/${O_KERNEL_CONFIG}/defconfig ${B}/.config
}
