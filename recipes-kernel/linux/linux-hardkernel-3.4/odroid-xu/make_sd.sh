#!/bin/sh
DEVICE=/dev/mmcblk0
echo "Using ${DEVICE} as device. Enter sudo password if this is correct."
sudo umount ${DEVICE}p1
sudo umount ${DEVICE}p2 
sudo parted ${DEVICE} --script -- mklabel msdos
sudo parted ${DEVICE} --script -- mkpart primary fat32 4096s 266239s
sudo parted ${DEVICE} --script -- mkpart primary ext4 266240s 100%
sudo mkfs.vfat -n BOOT ${DEVICE}p1
sudo mkfs.ext4 -L rootfs ${DEVICE}p2
