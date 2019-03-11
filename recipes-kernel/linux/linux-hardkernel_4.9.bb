FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.9.162"
KBRANCH ?= "odroidn2-4.9.y"
SRCREV ?= "a79c7062da82673df58713a58aeb56c988912572"

require linux-hardkernel.inc

O_KERNEL_CONFIG_odroid-n2-hardkernel  = "odroid-n2-hardkernel"

SRC_URI += "file://${O_KERNEL_CONFIG}/defconfig"

COMPATIBLE_MACHINE = "(odroid-n2-hardkernel)"

