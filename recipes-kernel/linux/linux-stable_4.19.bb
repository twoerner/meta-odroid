FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.19.8"
KBRANCH ?= "linux-4.19.y"
SRCREV ?= "178574b66509c9ff7df4ad26c84a8884567e93b4"

require linux-stable.inc

SRCREV_meta ?= "085d8f700a427a0c07e01339915ac04f501ecd29"

SRC_URI_append = " git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.19;destsuffix=${KMETA}"
SRC_URI_append = " file://odroid-kmeta;type=kmeta;name=odroid-kmeta;destsuffix=odroid-kmeta"

SRC_URI_append = " file://odroid/odroid.scc"
SRC_URI_append = " file://meson/meson64.scc"
SRC_URI_append = " file://ilp32/arm64_ilp32.scc"

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
