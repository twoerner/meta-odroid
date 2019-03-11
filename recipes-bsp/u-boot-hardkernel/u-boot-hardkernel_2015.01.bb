require u-boot-hardkernel.inc
LICENSE="GPLv2"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"

UBOOT_BRANCH ?= "odroidn2-v2015.01"

SRCREV = "db083ade21dd9c3f68a231e12305ca567dc4cfdf"

SRC_URI = "git://github.com/hardkernel/u-boot.git;branch=${UBOOT_BRANCH} \
           file://0001-compiler-.h-sync-include-linux-compiler-.h-with-Linu.patch "

do_compile_append () {
    # Move result to usual location
    mv ${B}/sd_fuse/${UBOOT_BINARY} ${B}
}

BL1_SUFFIX ?= "bin.hardkernel"
BL1_IMAGE ?= "bl1-${MACHINE}-${PV}-${PR}.${BL1_SUFFIX}"
BL1_BINARY ?= "bl1.${BL1_SUFFIX}"
BL1_SYMLINK ?= "bl1-${MACHINE}.${BL1_SUFFIX}"

do_deploy_append () {
    install ${S}/sd_fuse/${BL1_BINARY} ${DEPLOYDIR}/${BL1_IMAGE}

    cd ${DEPLOYDIR}
    rm -f ${BL1_BINARY} ${BL1_SYMLINK}
    ln -sf ${BL1_IMAGE} ${BL1_SYMLINK}
    ln -sf ${BL1_IMAGE} ${BL1_BINARY}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES =+ "u-boot"

COMPATIBLE_MACHINE = "odroid-n2"
