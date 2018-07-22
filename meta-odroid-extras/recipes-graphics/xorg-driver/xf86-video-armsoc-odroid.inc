SRC_URI += "file://10-armsoc.conf"

CONFFILES_${PN} = "${sysconfdir}/X11/xorg.conf.d/10-armsoc.conf"

do_install_append () {
        if test -s ${WORKDIR}/10-armsoc.conf; then
                install -d ${D}/${sysconfdir}/X11/xorg.conf.d
                install -m 0644 ${WORKDIR}/10-armsoc.conf ${D}/${sysconfdir}/X11/xorg.conf.d
        fi
}

FILES_{PN} += "${sysconfdir}/X11/xorg.conf.d"
