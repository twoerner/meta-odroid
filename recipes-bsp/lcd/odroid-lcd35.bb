# Copyright (C) 2018 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Enable Odroid LCD 3.5 inch panel"
HOMEPAGE = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
DEPENDS = ""

SRC_URI = "file://odroid-lcd35.service \
           file://odroid-lcd35.sysvinit \
           file://lcd-blacklist.conf \
          "

inherit systemd update-rc.d

# Enable 3.5' TFT Screen
KERNEL_MODULE_AUTOLOAD_append_odroid-c2 = " aml_i2c pwm-meson pwm-ctrl fbtft_device flexfb sx865x "
module_conf_fbtft_device = "options fbtft_device name=flexpfb rotate=270"
module_conf_flexfb = "options flexfb chip=ili9488"
KERNEL_MODULE_PROBECONF += "fbtft_device flexfb"

do_install_append () {
   install -D -m 0644 ${WORKDIR}/lcd-blacklist.conf ${D}${sysconfdir}/modprobe.d/lcd-blacklist.conf
   if [ "${@bb.utils.contains("DISTRO_FEATURES", "systemd", "yes", "no", d)}" = "yes" ]; then
       install -D -m 0644 ${WORKDIR}/odroid-lcd35.service ${D}${systemd_unitdir}/system/odroid-lcd35.service
   else
       install -D -m 0755 ${WORKDIR}/odroid-lcd35.sysvinit ${D}${sysconfdir}/init.d/odroid-lcd35
   fi
}

INITSCRIPT_NAME = "odroid-lcd35"
INITSCRIPT_PARAMS = "defaults"

SYSTEMD_SERVICE_${PN} = "odroid-lcd35.service"

FILES_${PN} += "${sysconfdir}/modprobe.d"
