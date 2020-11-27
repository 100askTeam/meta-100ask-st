# Copyright (C) 2019, MYIR - All Rights Reserved

inherit systemd

DESCRIPTION = "myd-ya157c"
LICENSE = "MIT"
PV = "1"
PR = "r0"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


SRC_URI = " \ 
	file://emmc_mount.sh \
	file://myd-ya157c.service \ 
        "
S_G = "${WORKDIR}"


do_install () {
      install -d ${D}/lib/systemd/system/
      install -d ${D}/usr/bin/
      install -m 0644 ${S_G}/myd-ya157c.service ${D}/lib/systemd/system/
      install -m 0777 ${S_G}/*.sh ${D}/usr/bin/
      
}

FILES_${PN} = "/lib/systemd/system/ \
		/usr/bin/ \
             "

#For dev packages only
INSANE_SKIP_${PN}-dev = "ldflags"
INSANE_SKIP_${PN} = "${ERROR_QA} ${WARN_QA}"
SYSTEMD_SERVICE_${PN} = "myd-ya157c.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"
