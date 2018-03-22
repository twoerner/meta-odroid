# Copyright (C) 2018 Trevor Woerner <twoerner@gmail.com>
# Released under MIT license

require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.org graphics driver for ARM graphics - Meson"
HOMEPAGE = "https://github.com/superna9999/xf86-video-armsoc"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=10ce5de3b111315ea652a5f74ec0c602"

SECTION = "X.org"

PR = "r0"

S = "${WORKDIR}/git"
SRCREV = "6b5bc2784b00fb4751f66c97761e377b0fc73799"
SRC_URI = " \
    git://github.com/jakogut/xf86-video-armsoc.git;protocol=https;branch=master \
    file://20-armsoc.conf \
    "

do_install_append() {
    install -d ${D}/etc/X11/xorg.conf.d
    install -m 644 ${WORKDIR}/20-armsoc.conf ${D}/etc/X11/xorg.conf.d
}
