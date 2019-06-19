#/bin/sh

# This bash script works around our circleCI config file. We're not using it as our CI doesn't function anymore.
# Simply run bash deploy.sh to consolidate your changes in production.

echo "Cloning severino..."
sleep 1
git clone git@github.com:sizebay/Severino.git utils

echo "Running pseudo-circleCI task"
mvn -s utils/sizebay-circleci/circle.maven-settings.xml -Dconfig.skip.tests=true clean deploy

