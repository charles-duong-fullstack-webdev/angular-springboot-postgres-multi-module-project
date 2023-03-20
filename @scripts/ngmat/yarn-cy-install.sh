#!/bin/sh

# Define your function here
Hello () {

   echo "basePath: ../angular-springboot-postgres-multi-module-project/angular-material-base"
   echo "     >>>> yarn install"
   cd ../angular-springboot-postgres-multi-module-project/angular-material-base
   yarn install
   return  0
}

# Invoke your function
Hello Charles Duong

# Capture value returnd by last command
ret=$?

echo "Return value is $ret"
