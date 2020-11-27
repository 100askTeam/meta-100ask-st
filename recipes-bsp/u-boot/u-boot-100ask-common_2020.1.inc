# Adaptation from u-boot-common_${PV}.inc

HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

DEPENDS += "dtc-native bc-native"
DEPENDS += "flex-native bison-native"

COMPATIBLE_MACHINE = "(stm32mpcommon)"

SRC_URI += " \
        git://e.coding.net/weidongshan/stm32mp15xc-uboot/stm32mp15xc-uboot.git;protocol=https;branch=stm32mp-ya15xc"
#SRCREV= "972d2b7a47cb6bc2eb2d4d4221530fc6735dc4a5"
SRCREV= "c15faa146135638f7f7b7a092474e046a0b0351e"

U_BOOT_VERSION = "2020.1"
PV = "${U_BOOT_VERSION}"

S = "${WORKDIR}/git"

# ---------------------------------
# Configure devupstream class usage
# ---------------------------------
BBCLASSEXTEND = "devupstream:target"

SRC_URI_class-devupstream = "git://e.coding.net/weidongshan/stm32mp15xc-uboot/stm32mp15xc-uboot.git;protocol=https;branch=stm32mp-ya15xc"
SRCREV= "c15faa146135638f7f7b7a092474e046a0b0351e"


SRCREV_FORMAT_class-devupstream = "uboot"
PV_class-devupstream = "${U_BOOT_VERSION}+github+${SRCPV}"

# ---------------------------------
# Configure default preference to manage dynamic selection between tarball and github
# ---------------------------------
STM32MP_SOURCE_SELECTION ?= "github"

DEFAULT_PREFERENCE = "${@bb.utils.contains('STM32MP_SOURCE_SELECTION', 'github', '-1', '1', d)}"
