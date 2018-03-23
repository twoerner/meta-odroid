require kernel-module-mali-utgard.inc

LIC_FILES_CHKSUM = "file://driver/src/devicedrv/mali/readme.txt;md5=92d15b487d204ace57072c48697b4a89"

BRANCH="DX910-SW-99002-r6p1-01rel0_meson_gx"
SRC_URI = "git://github.com/superna9999/meson_gx_mali_450.git;branch=${BRANCH}"

SRCREV = "08ef6f66bbb0be07c731bc339974840b22589a08"

S = "${WORKDIR}/git"


MALI_KCONFIG = "MALI_PLATFORM_FILES=platform/meson/meson.c \
		CONFIG_MALI_DMA_BUF_MAP_ON_ATTACH=y \
		CONFIG_MALI_QUIET=y \
"

MALI_FLAGS = "-DMALI_FAKE_PLATFORM_DEVICE=1 \
	      -DCONFIG_MALI_DMA_BUF_MAP_ON_ATTACH \
	      -DCONFIG_MALI_QUIET \
"
COMPATIBLE_MACHINE = "odroid-c2"
