#!/usr/bin/env bash

mysqlconnection="mysql -u kislay -p EcjajRobCik5 -S /var/lib/mysql/mysql.sock -h localhost"
olddb=lifeassistscraping
newdb=lifeassistscraping_jenkins

${mysqlconnection} -e "CREATE DATABASE $newdb"
params=$(${mysqlconnection} -N -e "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE table_schema='$olddb'")

for name in ${params}; do
      ${mysqlconnection} -e "RENAME TABLE $olddb.$name to $newdb.$name";
done;

${mysqlconnection} -e "DROP DATABASE $olddb"
