#!/bin/sh -e


echo "start myir HMI 2.0..."
insmod  /usr/bin/bcmdhd.ko  > /dev/null 2>&1
amixer cset numid=3 60000 60000 > /dev/null 2>&1
export QT_QPA_EGLFS_ALWAYS_SET_MODE="1"
export QT_QPA_EGLFS_KMS_ATOMIC='1'
export QT_QPA_GENERIC_PLUGINS=evdevtouch:/dev/input/event1
export QT_QPA_EGLFS_KMS_CONFIG='/usr/share/qt5/cursor.json'
psplash-drm-quit


export QT_QPA_PLATFORM='eglfs'
/home/mxapp2 -platform eglfs &

exit 0

