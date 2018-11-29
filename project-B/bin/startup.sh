# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

#!/usr/bin/env sh

PRG="$0"
PRGDIR=`dirname "$PRG"`
[ -z "$PROJECT_B_HOME" ] && PROJECT_B_HOME=`cd "$PRGDIR/.." >/dev/null; pwd`

PROJECT_B_LOG_DIR="${PROJECT_B_HOME}/logs"
JAVA_OPTS=" -Xms128M -Xmx128M"

if [ ! -d "${PROJECT_B_HOME}/logs" ]; then
    mkdir -p "${PROJECT_B_LOG_DIR}"
fi

_RUNJAVA=${JAVA_HOME}/bin/java
[ -z "$JAVA_HOME" ] && _RUNJAVA=java

CLASSPATH="$OPROJECT_B_HOME/config:$CLASSPATH"
for i in "$PROJECT_B_HOME"/libs/*.jar
do
    CLASSPATH="$i:$CLASSPATH"
done

PROJECT_OPTIONS=" -DprojectB.logDir=${PROJECT_B_LOG_DIR}"

eval exec "\"$_RUNJAVA\" ${JAVA_OPTS} ${PROJECT_OPTIONS} -classpath $CLASSPATH org.skywalking.apm.cnutcon.liveshow.projectb.ProjectB_StartMain \
        2>${PROJECT_B_LOG_DIR}/server.log 1> /dev/null &"

if [ $? -eq 0 ]; then
    sleep 1
	echo "SkyWalking Demo Project B started successfully!"
else
	echo "SkyWalking Demo Project B started failure!"
	exit 1
fi