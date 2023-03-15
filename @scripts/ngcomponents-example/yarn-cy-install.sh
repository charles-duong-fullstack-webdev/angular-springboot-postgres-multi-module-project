#!/bin/sh

# Define your function here
Hello () {

   echo "basePath: ~/my_git_checkout/github/angular-springboot-postgres-multi-module-project/angular-app-ngcomponents-example"
   echo "     >>>> yarn install" 
   cd ~/my_git_checkout/github/angular-springboot-postgres-multi-module-project/angular-app-ngcomponents-example
   yarn install
   return  0
}

# Invoke your function
Hello Charles Duong

# Capture value returnd by last command
ret=$?

echo "Return value is $ret"
