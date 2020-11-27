FILESEXTRAPATHS_prepend_stm32mpcommon := "${THISDIR}/tf-a-100ask:"

SECTION = "bootloaders"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://license.rst;md5=1dd070c98a281d18d9eefd938729b031"
#LIC_FILES_CHKSUM = "file://license.rst;md5=189505435dbcdcc8caa63c46fe93fa89"

SRC_URI += "git://e.coding.net/weidongshan/stm32mp15xc-tf-a/stm32mp15xc-tf-a.git;protocol=https;branch=stm32mp-ya15xc"
SRCREV= "42559a0bdd7627a4d547a28ae7c78b2d4918142e"
#SRCREV= "6e2a17b732a78c22374e21afdb513f8de9e17f0c"

TF_VERSION = "2.2"
PV = "${TF_VERSION}.r1"

S = "${WORKDIR}/git"
#S = "${WORKDIR}/arm-trusted-firmware"

# ---------------------------------
# Configure devupstream class usage
# ---------------------------------
BBCLASSEXTEND = "devupstream:target"

SRC_URI_class-devupstream ="git://e.coding.net/weidongshan/stm32mp15xc-tf-a/stm32mp15xc-tf-a.git;protocol=https;branch=stm32mp-ya15xc"
SRCREV_class-devupstream ="42559a0bdd7627a4d547a28ae7c78b2d4918142e"
#SRCREV_class-devupstream ="6e2a17b732a78c22374e21afdb513f8de9e17f0c"



SRCREV_FORMAT_class-devupstream = "tfa"
PV_class-devupstream = "${TF_VERSION}+github+${SRCPV}"

# ---------------------------------
# Configure default preference to manage dynamic selection between tarball and github
# ---------------------------------
STM32MP_SOURCE_SELECTION ?= "tarball"

DEFAULT_PREFERENCE = "${@bb.utils.contains('STM32MP_SOURCE_SELECTION', 'github', '-1', '1', d)}"
