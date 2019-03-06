FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.0.0."
KBRANCH ?= "linux-5.0.y"
SRCREV ?= "1c163f4c7b3f621efff9b28a47abb36f7378d783"

require linux-stable.inc

SRCREV_meta ?= "8ae7073a934d80c4f4b808bc01884777454aae8f"

SRC_URI_append = " git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.0;destsuffix=${KMETA}"
SRC_URI_append = " file://odroid-kmeta;type=kmeta;name=odroid-kmeta;destsuffix=odroid-kmeta"

SRC_URI_append = " file://odroid/odroid.scc"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

DEPENDS += "openssl-native util-linux-native"

KMETA = "kernel-meta"
KMACHINE_odroid-hc1 = "odroid-hc1"
KMACHINE_odroid-xu3 = "odroid-xu3"
KMACHINE_odroid-xu3-lite = "odroid-xu3-lite"
KMACHINE_odroid-xu4 = "odroid-xu4"
KMACHINE_odroid-c2 = "odroid-c2"
KMACHINE_odroid-c1 = "odroid-c1"

#KERNEL_FEATURES_append = " ${@bb.utils.contains("DISTRO_FEATURES", "x11", " features/graphics/fb.scc", "" ,d)}"
