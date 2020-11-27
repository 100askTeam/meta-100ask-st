SUMMARY = "Linux STM32MP Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

include linux-100ask.inc

LINUX_VERSION = "5.4"
LINUX_SUBVERSION = "31"

S = "${WORKDIR}/git"
#S = "${WORKDIR}/linux-${LINUX_VERSION}.${LINUX_SUBVERSION}"

# ---------------------------------
# Configure devupstream class usage
# ---------------------------------
BBCLASSEXTEND = "devupstream:target"


SRC_URI += " \
        git://e.coding.net/weidongshan/stm32mp15xc-kernel/stm32mp15xc-kernel.git;protocol=https;branch=master"

# ---------------------------------
# Add bluetooth
# ---------------------------------
SRCREV = "88e22aae19231ac4e3603578756c9d97ae134ef5"

#SRCREV_FORMAT = "linux"

PV = "${LINUX_VERSION}+${LINUX_SUBVERSION}+${SRCPV}"



# ---------------------------------
# Configure default preference to manage dynamic selection between tarball and github
# ---------------------------------
STM32MP_SOURCE_SELECTION ?= "tarball"

#DEFAULT_PREFERENCE = "${@bb.utils.contains('STM32MP_SOURCE_SELECTION', 'github', '-1', '1', d)}"

# ---------------------------------
# Configure archiver use
# ---------------------------------
#include ${@oe.utils.ifelse(d.getVar('ST_ARCHIVER_ENABLE') == '1', 'linux-100ask-archiver.inc','')}

# -------------------------------------------------------------
# Defconfig
#

KERNEL_DEFCONFIG        = "100ask_stm32mp157_defconfig"
KERNEL_CONFIG_FRAGMENTS = "${@bb.utils.contains('KERNEL_DEFCONFIG', 'myc-ya157c_defconfig', '${S}/arch/arm/configs/fragment-01-multiv7_cleanup.config', '', d)}"
KERNEL_CONFIG_FRAGMENTS += "${@bb.utils.contains('KERNEL_DEFCONFIG', 'myc-ya157c_defconfig', '${S}/arch/arm/configs/fragment-02-multiv7_addons.config', '', d)}"
#KERNEL_CONFIG_FRAGMENTS += "${@bb.utils.contains('KERNEL_DEFCONFIG', 'myc-ya157c_defconfig', '${WORKDIR}/fragment.config', '', d)}"


# -------------------------------------------------------------
# Kernel Args
#
KERNEL_EXTRA_ARGS += "LOADADDR=${ST_KERNEL_LOADADDR}"
