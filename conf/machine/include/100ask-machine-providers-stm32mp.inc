# =========================================================================
# Kernel
# =========================================================================
PREFERRED_PROVIDER_virtual/kernel = "linux-100ask"

# =========================================================================
# u-boot
# =========================================================================
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-100ask"
PREFERRED_PROVIDER_u-boot = "u-boot-100ask"

# =========================================================================
# trusted-firmware-a
# =========================================================================
PREFERRED_PROVIDER_virtual/trusted-firmware-a = "tf-a-100ask"
PREFERRED_PROVIDER_virtual/trusted-firmware-a-serialboot = "tf-a-100ask-serialboot"
# Define default TF-A config
TF_A_CONFIG_append_pn-tf-a-100ask-serialboot = " serialboot "
TF_A_CONFIG_append_pn-tf-a-100ask = " ${@bb.utils.contains('BOOTSCHEME_LABELS', 'trusted', 'trusted', '', d)} "
TF_A_CONFIG_append_pn-tf-a-100ask = " ${@bb.utils.contains('BOOTSCHEME_LABELS', 'optee', 'optee', '', d)} "

# =========================================================================
# optee-os
# =========================================================================
#PREFERRED_PROVIDER_virtual/optee-os = "optee-os-stm32mp"

