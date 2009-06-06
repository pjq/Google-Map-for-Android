#########################################################################
# Author: pengjianqing@sina.com
# Created Time: Sat 06 Jun 2009 11:31:57 PM CST
# File Name: SignAndroid.sh:sa.sh
# Description:Used to auto sign the apk file,then reinstall it.
#########################################################################
#!/bin/bash
echo "========================================"
KEYSTORE=`ls -l|grep keystore|cut -d " " -f8`
echo "KEYSTORE=${KEYSTORE}"
PRENAME=`echo ${KEYSTORE}|cut -d "." -f1`
echo "PRENAME=${PRENAME}"
PACKAGE=`grep package AndroidManifest.xml|cut -d "\"" -f2`
echo "PACKAGE=${PACKAGE}"
APKFILE=`ls bin/ -l|grep apk|cut -d " " -f8`
echo "APKFILE=${APKFILE}"
echo "========================================"

echo "****************************************"
echo "Sign the apk:"
echo "jarsigner -verbose -keystore ${KEYSTORE} bin/${APKFILE} ${PRENAME}"
jarsigner -verbose -keystore ${KEYSTORE} bin/${APKFILE}  ${PRENAME}
echo "****************************************"

echo "Uninstall the apk:"
echo "adb uninstall ${PACKAGE} " 
adb uninstall ${PACKAGE}
echo "****************************************"

echo "Install apk:"
echo "adb install bin/${APKFILE}"
adb install bin/${APKFILE}
echo "****************************************"
echo "Finished!!"
echo "****************************************"
