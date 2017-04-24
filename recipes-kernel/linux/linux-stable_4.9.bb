FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.9.24"

SRCREV ?= "2f5e58ec793f56f9ac1c6736b4638a4b81d6f099"
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.9.y"

require linux-stable.inc
