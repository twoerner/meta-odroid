# Amlogic Meson Soc family

SOC_FAMILY = "amlogic:meson"
require conf/machine/include/soc-family.inc

SERIAL_CONSOLE ?= "115200 ttyAML0"
UBOOT_CONSOLE ?= "console=ttyAML0,115200"
