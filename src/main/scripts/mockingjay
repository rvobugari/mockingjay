#!/bin/bash
# mockingjay (Stubbing for service for RESTAPIs)
# chkconfig: 345 90 10
# description: mockingjay (Stubbing for service for RESTAPIs) Daemon
# processname: mockingjay

DAEMON_PATH="/opt/mockJay/mockingjay/"
NAME=mockingjay
DESC="mockingjay: mockJay
SCRIPTNAME="/etc/init.d/$NAME"
PID_FILE="/var/run/$NAME.pid"
LOG_FILE="/var/log/mockJay/$NAME/$NAME.log"
SHUTDOWN_GRACE_TIME_SECS=30

# Checks if given process marked in the pid file is running.
# Returns 1 if running, else 0.
function isRunning {
    
    # Does pid file exist? 
    if [ -f ${PID_FILE} ]; then
        local pid=`cat ${PID_FILE}`

        # is the pid in pid file not running?
        if [ -z "`ps ax -o pid | grep ${pid}`" ]; then
        	# if process dead, delete the pid file 
            rm -f ${PID_FILE}
            #return false
            return 0
        else
        	# return true
            return 1
        fi
    fi

    return 0
}

function start {
	
	# Disable CTRL+C
	trap "" INT

    isRunning
    local status=$?
    if [ "$status" == "0" ]
    then
	    echo "Starting $NAME ..."

	    # issue the java command
	    java -jar ${DAEMON_PATH}/lib/mockingjay.jar server ${DAEMON_PATH}/conf/mockingjay.yaml 1>>${LOG_FILE} 2>&1 &
	    # capture the java process pid
	    pid=$!
	    echo ${pid}>${PID_FILE}
	    echo "$NAME started. Please refer to log file for details."
	else
		echo "$NAME already runnig with pid `cat ${PID_FILE}`"
	fi
}

function stop {
	# Disable CTRL+C
	trap "" INT

    isRunning
    local status=$?

    if [ "$status" == "1" ]
    then
    	local pid=`cat ${PID_FILE}`

        echo -n "Stopping $NAME with pid=$pid ..."
        # kill the process. 
        # Do not perform kill -9 initially as we want the microservice 
        # to respect the shutdownGracePeriod.
        kill ${pid}

        # Wait for 30 seconds to process to terminate gracefully. 
        # It it does not, force kill the process.
        time_elapsed=0
        sleep_time_sec=2
	    while [ ! -z `ps ax -o pid | grep ${pid}` ]
	    do
	        sleep ${sleep_time_sec}
	        time_elapsed=$((time_elapsed+sleep_time_sec))
	        if [ "$time_elapsed" -gt "$SHUTDOWN_GRACE_TIME_SECS" ]
	        	then
	        	kill -9 ${pid}
	        fi

	        echo -n "."
	    done
	    echo -e "\n$NAME stopped."
    else 
        echo "$NAME is not running."
    fi
}

function restart {
    stop
    start
}

function status {
    isRunning
    local status=$?
    if [ "$status" == "0" ]
    then
        echo "$NAME is not running."
    else
        echo "$NAME runnig with pid `cat $PID_FILE`"
    fi
}


case "$1" in
    start)
        start
    ;;
    status)
        status
    ;;
    stop)
        stop
    ;;

    restart)
        restart
    ;;

    *)
        echo "Usage: $0 {status|start|stop|restart}"
        exit 1
esac
