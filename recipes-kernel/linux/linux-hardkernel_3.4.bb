inherit kernel
require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "odroid-xu"
COMPATIBLE_MACHINE_odroid-xu = "odroid-xu"

LINUX_VERSION = "3.4"
LINUX_VERSION_EXTENSION = "-custom"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}"

# from where to fetch the kernel
KERNEL_REPO_OWNER ??= "hardkernel"
KERNEL_REPO_URI ??= "git://github.com/${KERNEL_REPO_OWNER}/linux.git"
KBRANCH = "odroidxu-3.4.y"

SRCREV = "${AUTOREV}"

PR = "r1"
PV = "${LINUX_VERSION}"

SRC_URI = " \
  ${KERNEL_REPO_URI};nocheckout=1;branch=${KBRANCH} \
  file://defconfig \
  file://fix-broken-creation-of-arch-release-symlink.patch \
"
