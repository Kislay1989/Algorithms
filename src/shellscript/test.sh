#!/usr/bin/env bash
PASSWORD=XXXXXX
HOST=XXXXXX
USER=XXXXXX
DATABASE=lifeassist
DB_FILE=lifeassist_dump.sql
EXCLUDED_TABLES=(
table1
table2
table3
table4
tableN
)

IGNORED_TABLES_STRING=''
for TABLE in "${EXCLUDED_TABLES[@]}"
do :
   IGNORED_TABLES_STRING+=" --ignore-table=${DATABASE}.${TABLE}"
done

echo "Dump structure"
mysqldump --host=${HOST} --user=${USER} --password=${PASSWORD} --single-transaction --no-data ${DATABASE} > ${DB_FILE}

echo "Dump content"
mysqldump --host=${HOST} --user=${USER} --password=${PASSWORD} ${DATABASE} --no-create-info ${IGNORED_TABLES_STRING} >> ${DB_FILE}
