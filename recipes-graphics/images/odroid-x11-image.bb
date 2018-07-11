SUMMARY = "Basic Odroid X11 graphics image"

IMAGE_FEATURES += "splash debug-tweaks ssh-server-openssh tools-debug x11"

LICENSE = "MIT"

inherit core-image distro_features_check extrausers

# let's make sure we have a good image..
REQUIRED_DISTRO_FEATURES = "x11"

MALI ?= ""

CORE_IMAGE_BASE_INSTALL += " \
    ${XSERVER} \
    ${MALI} \
    xserver-common \
    xorg-minimal-fonts \
    xserver-xorg-utils \
    kernel-modules \
    openbox \
    mesa-gl \
"

CORE_IMAGE_BASE_INSTALL += " \
    x11perf \
    xvideo-tests \
    mesa-demos \
"
