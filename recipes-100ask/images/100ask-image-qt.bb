SUMMARY = "myir example of image based on QT framework."
LICENSE = "Proprietary"

include recipes-100ask/images/100ask-image.inc

inherit core-image distro_features_check

# let's make sure we have a good image..
#CONFLICT_DISTRO_FEATURES = "x11 wayland"

IMAGE_LINGUAS = "en-us"

IMAGE_FEATURES += " \
    splash              \
    package-management  \
    ssh-server-dropbear \
    hwcodecs            \
    tools-profile       \
    eclipse-debug       \
    "

# Define ROOTFS_MAXSIZE to 3GB
IMAGE_ROOTFS_MAXSIZE = "3145728"

IMAGE_INSTALL_append = " \
			ffmpeg \
			myd-ya157c \
			qt-demo \
			"

# Set ST_EXAMPLE_IMAGE property to '1' to allow specific use in image creation process
ST_EXAMPLE_IMAGE = "1"


#
# INSTALL addons
#
CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-framework-core-base    \
    packagegroup-framework-tools-base   \
    \
    packagegroup-framework-core         \
    packagegroup-framework-tools       \
    \
    packagegroup-framework-core-extra   \
    \
    packagegroup-framework-sample-qt    \
    packagegroup-framework-sample-qt-extra   \
    "
