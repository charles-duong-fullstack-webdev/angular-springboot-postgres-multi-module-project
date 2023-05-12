#!/bin/sh

# Define your function here
Hello () {
   echo "basePath: ../angular-springboot-postgres-multi-module-project/angular-h2-fitness-app"
   echo "     >>>> ng serve"
   cd ../angular-springboot-postgres-multi-module-project/angular-h2-fitness-app
   ng serve
   return  0
}

# Invoke your function
Hello Charles Duong

# Capture value returnd by last command
ret=$?

echo "Return value is $ret"
