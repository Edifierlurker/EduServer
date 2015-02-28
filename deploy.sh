#!/bin/sh
echo "init work:unzip ,build_number"
cd /home/setup/caps/version/Mobile
unzip *.zip
unzip *.war
build_number=`ls -l|grep .zip|awk -F "-" '{print $NF}'|awk -F "." '{print $1}'`
rm *.zip
rm *.war
pwd
echo "init work is over: build number is "
echo $build_number

echo "put version on git start"
cp -R /home/setup/caps/version/Mobile/* /home/setup/caps/repository/Mobile
cd /home/setup/caps/repository/Mobile
git add .
git commit -m "the change add"
git tag $build_number
echo "put version on git end"

cd /home/setup/caps
cap deploy

#delete all file
cd /home/setup/caps/version/Mobile
rm -rf *
echo "we finish !!!"
echo "**********"
