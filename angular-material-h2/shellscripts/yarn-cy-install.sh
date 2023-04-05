#!/bin/sh

# Define your function here
Hello () {

   echo "basePath: ../angular-springboot-postgres-multi-module-project/angular-material-h2"
   echo "     >>>> yarn install"
   cd ../angular-springboot-postgres-multi-module-project/angular-material-h2
   yarn install
   return  0
}

# Invoke your function
Hello Charles Duong

# Capture value returnd by last command
ret=$?

echo "Return value is $ret"
