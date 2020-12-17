DESCRIPTION = "udev rules for ST SOCs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=b97a012949927931feb7793eee5ed924"

SRC_URI = " file://10-bcmdhd.rules"

S = "${WORKDIR}"

do_install () {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/10-bcmdhd.rules ${D}${sysconfdir}/udev/rules.d/
}
