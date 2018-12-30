#
# Power control routines
#

PWR_CNTL_TYPE ?= ""
PWR_CNTL_USER ?= ""
PWR_CNTL_PASSWD ?= ""
PWR_CNTL_CMD ?= ""
PWR_CNTL_ARGS ?= ""
PWR_CNTL_SERVER_IP ?= ""
PWR_CNTL_NODE ?= ""
PWR_OFF ?= ""
PWR_ON ?= ""
PWR_CMD ?= "${PWR_CNTL_CMD} ${PWR_CNTL_ARGS}"

# IPower 9285
PWR_CNTL_USER_ipower ?= "admin"
PWR_CNTL_PASSWD_ipower ?= "12345678"
PWR_CNTL_CMD_ipower ?= "wget -O/dev/null -q --http-user=${PWR_CNTL_USER_ipower} --http-password=${PWR_CNTL_PASSWD_ipower} "
PWR_CNTL_SERVER_IP_ipower ?= ""
PWR_CNTL_ARGS_ipower ?= "http://${PWR_CNTL_SERVER_IP_ipower}/set.cmd?cmd=setpower"
PWR_OFF_ipower ?= "0"
PWR_ON_ipower ?= "1"

PWR_OFF_CMD_ipower ?= "${PWR_CNTL_CMD_ipower} ${PWR_CNTL_ARGS_ipower}+${PWR_CNTL_NODE}=${PWR_OFF_ipower}"
PWR_ON_CMD_ipower ?= "${PWR_CNTL_CMD_ipower} ${PWR_CNTL_ARGS_ipower}+${PWR_CNTL_NODE}=${PWR_ON_ipower}"

addtask poweroff
do_poweroff[nostamp] = "1"

power_off (){
     ${PWR_OFF_CMD}
}

python do_poweroff () {
    bb.note("poweroff")
    pwr_type = d.getVar("PWR_CNTL_TYPE")
    pwr_off_cmd = d.getVar('PWR_OFF_CMD_%s' % pwr_type)
    d.setVar('PWR_OFF_CMD', pwr_off_cmd)
    bb.build.exec_func('power_off', d)
}


addtask poweron
do_poweron[nostamp] = "1"

power_on (){
     ${PWR_ON_CMD}
}

python do_poweron () {
    bb.note("poweron")
    pwr_type = d.getVar("PWR_CNTL_TYPE")
    pwr_on_cmd = d.getVar('PWR_ON_CMD_%s' % pwr_type)
    d.setVar('PWR_ON_CMD', pwr_on_cmd)
    bb.build.exec_func('power_on', d)
}


addtask powercycle
do_powercycle[nostamp] = "1"

python do_powercycle () {
    import time
    bb.build.exec_func('do_poweroff', d)
    time.sleep(2)
    bb.build.exec_func('do_poweron', d)
}
