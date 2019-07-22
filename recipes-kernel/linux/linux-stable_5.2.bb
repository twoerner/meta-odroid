FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.2.2"
SRCREV ?= "e9b75c60f91a359cb0e1b2d0a9ed1c81485215e2"
SRCREV_meta ?= "c62799e312fcbe2a2f2237e4e98f195ff984c35b"

MBRANCH = "stable-${KBASE_VERSION}"
KMETA_SRC_URI = " git://github.com/akuster/yocto-kernel-cache.git;type=kmeta;name=meta;branch=${MBRANCH};destsuffix=${KMETA}"

require linux-stable.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
