FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.1.16"
SRCREV ?= "8584aaf1c3262ca17d1e4a614ede9179ef462bb0"
SRCREV_meta ?= "878986f80f6d9bf4d3a7991dfd0366f249dac762"

MBRANCH = "stable-${KBASE_VERSION}"
KMETA_SRC_URI = " git://github.com/akuster/yocto-kernel-cache.git;type=kmeta;name=meta;branch=${MBRANCH};destsuffix=${KMETA}"

require linux-stable.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
