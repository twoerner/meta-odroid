inherit kernel
require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-odroid-dev:"

KBRANCH ?= "master"
SRCREV ?= "e49251988b10e8787baa5f3d8ffd154e003f0963"

KBRANCH_odroid-xu3 ?= "master"
SRCREV_machine_odroid-xu3 ?= "e49251988b10e8787baa5f3d8ffd154e003f0963"
KERNEL_DEVICETREE_odroid-xu3 = "exynos5422-odroidxu3.dtb"


SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;bareclone=1;branch=${KBRANCH}"


SRC_URI += "file://${MACHINE}_defconfig"

SRC_URI += "file://odroid.scc \
        file://odroid.cfg \
        file://odroid-user-config.cfg \
        file://odroid-user-patches.scc \
"

LINUX_VERSION = "4.2.0"
PV = "${LINUX_VERSION}+git${SRCPV}"

do_configure_prepend () {
    cp ${WORKDIR}/${MACHINE}_defconfig ${B}/.config
}

COMPATIBLE_MACHINE = "odroid-xu3"
