# Copyright (C) 2018, STMicroelectronics - All Rights Reserved

SUMMARY = "Bluetooth firmware for BCM4343"
HOMEPAGE = "https://e.coding.net/lichang70/linux-fw-myir"
LICENSE = "Firmware-cypress-bcm4343"
LIC_FILES_CHKSUM = "file://LICENCE.cypress;md5=bec5b7d5e6664aaf184eee55755d42ac"

NO_GENERIC_LICENSE[Firmware-cypress-bcm4343] = "LICENCE.cypress"

inherit allarch

SRC_URI = "git://e.coding.net/lichang70/linux-fw-myir.git;protocol=https"
SRCREV = "af80435008560c0c85baa73dcd80fa688bd2941a"


S = "${WORKDIR}/git"

PACKAGES =+ "${PN}-cypress-license"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/brcm/
    install -d ${D}${nonarch_base_libdir}/firmware/rtlwifi/

    install -m 644 ${S}/BCM4343B0.hcd ${D}${nonarch_base_libdir}/firmware/brcm/BCM.hcd
    install -m 644 ${S}/LICENCE.cypress ${D}${nonarch_base_libdir}/firmware/LICENCE.cypress_bcm4343
#Used for wifi (sdio wifi and usb wifi)
   install -m 0644 ${S}/fw_bcm43436b0.bin ${D}${nonarch_base_libdir}/firmware/
   install -m 0644 ${S}/nvram_ap6236.txt  ${D}${nonarch_base_libdir}/firmware/
   install -m 0644 ${S}/rtl8192cufw_TMSC.bin ${D}${nonarch_base_libdir}/firmware/rtlwifi/
   install -m 0644 ${S}/rtl8192cufw.bin ${D}${nonarch_base_libdir}/firmware/rtlwifi/
   install -m 0644 ${S}/bcmdhd ${D}${nonarch_base_libdir}/firmware/brcm/
}


LICENSE_${PN} = "Firmware-cypress-bcm4343"
LICENSE_${PN}-cypress-license = "Firmware-cypress-bcm4343"

FILES_${PN}-cypress-license = "${nonarch_base_libdir}/firmware/LICENCE.cypress_bcm4343"
FILES_${PN} = "${nonarch_base_libdir}/firmware/"

RDEPENDS_${PN} += "${PN}-cypress-license"

RRECOMMENDS_${PN}_append_stm32mpcommon += "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'bluetooth-suspend', '', d)}"

# Firmware files are generally not ran on the CPU, so they can be
# allarch despite being architecture specific
INSANE_SKIP = "arch"
