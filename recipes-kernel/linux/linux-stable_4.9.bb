FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.9.23"

SRCREV ?= "c3582cc56eac9213b32cc2a2886b11e2e5027598"
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;bareclone=1;branch=linux-4.9.y"

require linux-stable.inc
