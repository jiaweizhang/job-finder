#!/bin/bash
# run 'chmod 755 setup' prior to being able to run script
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ `lsb_release -cs`-pgdg main" >> /etc/apt/sources.list.d/pgdg.list'
wget -q https://www.postgresql.org/media/keys/ACCC4CF8.asc -O - | sudo apt-key add -
sudo apt-get update
sudo apt-get install postgresql postgresql-contrib

#install java
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer
sudo apt-get install oracle-java8-set-default

#install gradle
sudo add-apt-repository ppa:cwchien/gradle
sudo apt-get update
sudo apt-get install gradle

#install frontend stuff
#sudo apt-get install nodejs
#sudo apt-get install npm
#sudo ln -s /usr/bin/nodejs /usr/bin/node
#sudo npm install --global babel-cli
#sudo npm install babel-preset-react

