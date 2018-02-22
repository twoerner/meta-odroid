require recipes-bsp/u-boot/u-boot.inc
DESCRIPTION = "Odroid C2 boot loader supported by the hardkernel product"
SECTION = "bootloaders"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PROVIDES += "virtual/bootloader u-boot"

LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

USE_BOOTSCR = "0"

# from where to fetch the u-boot
UBOOT_REPO_URI ??= "git://github.com/hardkernel/u-boot.git"
BRANCH = "odroidc2-v2015.01"
SRC_URI = "${UBOOT_REPO_URI};branch=${BRANCH} \
           file://odroid-c2-hardkernel/boot.ini \
           https://releases.linaro.org/components/toolchain/binaries/4.9-2017.01/aarch64-elf/gcc-linaro-4.9.4-2017.01-x86_64_aarch64-elf.tar.xz;name=aarch64toolchain;md5=0 \
           https://releases.linaro.org/components/toolchain/binaries/4.9-2017.01/arm-eabi/gcc-linaro-4.9.4-2017.01-x86_64_arm-eabi.tar.xz;name=armtoolchain;md5=0"
SRC_URI[aarch64toolchain.md5sum] = "8fd2fff7145b93cfe8dd203e35d513db"
SRC_URI[aarch64toolchain.sha256sum] = "00c79aaf7ff9b1c22f7b0443a730056b3936561a4206af187ef61a4e3cab1716"
SRC_URI[armtoolchain.md5sum] = "4ae181da604d5b1b6a41c660669ad7fe"
SRC_URI[armtoolchain.sha256sum] = "5fa170a74db172dca098c70ae58f4c08d2fca0232ce135530b2ef4996326b4bd"
# TAG s905_6.0.1_v3.7
SRCREV = "95264d19d04930f67f10f162df70de447659329d"

PR = "${PV}+git${SRCPV}"

UBOOT_SUFFIX ?= "bin"

PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git"

inherit uboot-boot-scr

DEPENDS += "bc-native atf-native"

EXTRA_OEMAKE_odroid-c2 = 'V=1 CROSS_COMPILE=${TOOLCHAIN_PREFIX} HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}"'

TOOLCHAIN_PREFIX_odroid-c2 = "aarch64-elf-"

do_configure_append() {
	cp ${WORKDIR}/odroid-c2-hardkernel/boot.ini ${B}/
}

do_compile_prepend() {
	export PATH=${WORKDIR}/gcc-linaro-4.9.4-2017.01-x86_64_aarch64-elf/bin:${WORKDIR}/gcc-linaro-4.9.4-2017.01-x86_64_arm-eabi/bin:${PATH}
}

do_compile_append_odroid-c2 () {
	cp ${S}/sd_fuse/u-boot.bin ${B}/${UBOOT_BINARY}
}

COMPATIBLE_MACHINE = "(odroid-c2)"
UBOOT_MACHINE_odroid-c2 = "odroidc2_config"
