#!/bin/sh

file1="/lib/systemd/system/measy_iot_start.service"

if [ ! -f "$file1" ];then
    echo "myir"
else
    #if [ ! -f "/etc/systemd/system/multi-user.target.wants/measy_iot_start.service" ];then
        systemctl start connmand.service
        systemctl start measy_iot_start.service
fi

# enable 4G power
echo  139 > /sys/class/gpio/export
echo out > /sys/class/gpio/gpio139/direction
echo 1 > /sys/class/gpio/gpio139/value

# enable usb hub
echo  82 > /sys/class/gpio/export
echo out > /sys/class/gpio/gpio82/direction
echo 1 > /sys/class/gpio/gpio82/value


if [ ! -d "/vendor/lib" ];then
    mount /dev/mmcblk2p2 /boot
    mount -t ext4 /dev/mmcblk2p3 /vendor
    mount -t ext4 /dev/mmcblk2p5 /usr/local
	
fi

if [ -d "/usr/local/demo/demo_launcher.py" ];then
         systemctl start weston &
fi


