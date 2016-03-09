require u-boot-hardkernel.inc

LIC_FILES_CHKSUM = "file://README;md5=813b058284702a930d44d94cca59ee96"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-2015-01:"

BRANCH ?= "odroidc2-v2015.01"
SRCREV = "beda6948c78a85c9705a877f9d012fec10032ef2"

SRC_URI += "file://0001-Add-linux-compiler-gcc5.h-to-fix-builds-with-gcc5.patch"

S = "${WORKDIR}/git"

PARALLEL_MAKE = ""

do_compile_append () {
	cp ${S}/build/u-boot.bin ${S}/.	
}

do_deploy_append () {
    install -d ${DEPLOYDIR}
    cp -v ${S}/sd_fuse/bl1.bin.hardkernel ${DEPLOYDIR}
}

COMPATIBLE_MACHINE = "(odroid-c2)"
UBOOT_MACHINE_odroid-c2 = "odroidc2_config"
