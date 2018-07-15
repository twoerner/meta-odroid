SUMMARY = "Basic Odroid X11 graphics image"

IMAGE_FEATURES += "splash debug-tweaks ssh-server-openssh tools-debug x11"

LICENSE = "MIT"

inherit core-image distro_features_check extrausers

# let's make sure we have a good image..
REQUIRED_DISTRO_FEATURES = "x11"

MALI ?= ""

XSERVER_OPENGL ?= " \
    xf86-video-modesetting \
    xserver-xorg-extension-glx \
"
VULKAN = "\
    vulkan \
    vulkan-demos \
"

XSERVER = " \
    xserver-xorg \
    xserver-xorg-module-libint10 \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '${XSERVER_OPENGL}', 'xf86-video-fbdev', d)} \
    xf86-video-armsoc \
    xf86-input-evdev \
    xf86-input-mouse \
    xf86-input-keyboard \
"

CORE_IMAGE_BASE_INSTALL += " \
    ${XSERVER} \
    ${MALI} \
    xserver-common \
    xorg-minimal-fonts \
    xserver-xorg-utils \
    kernel-modules \
    openbox \
    mesa \
"

CORE_IMAGE_BASE_INSTALL += " \
    x11perf \
    xvideo-tests \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'mesa-demos', '', d)} \
"

COMPATIBLE_MACHINE = "(odroid-xu3|odroid-xu4|odroid-xu3-lite|odroid-c2)"
