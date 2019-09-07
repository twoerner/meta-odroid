FILESEXTRAPATHS_prepend := "${THISDIR}/linux-yocto-dev:"

KMACHINE_odroid-c2 ?= "odroid-c2"
KMACHINE_odroid-n2 ?= "odroid-n2"
KMACHINE_odroid-xu3 ?= "odroid-xu3"
KMACHINE_odroid-xu3-lite ?= "odroid-xu3-lite"
KMACHINE_odroid-xu4 ?= "odroid-xu4"

SRC_URI_append = " file://odroid-kmeta;type=kmeta;name=odroid-kmeta;destsuffix=odroid-kmeta"

COMPATIBLE_MACHINE_odroid-c2 = "odroid-c2"
COMPATIBLE_MACHINE_odroid-n2 = "odroid-n2"
COMPATIBLE_MACHINE_odroid-xu3 = "odroid-xu3"
COMPATIBLE_MACHINE_odroid-xu3-lite = "odroid-xu3-lite"
COMPATIBLE_MACHINE_odroid-xu4 = "odroid-xu4"
