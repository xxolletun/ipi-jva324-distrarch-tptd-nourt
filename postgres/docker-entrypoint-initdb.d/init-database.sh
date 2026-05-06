#!/bin/bash
set -e

echo "** Creating DB user";

PGPASSWORD="$POSTGRES_PASSWORD" psql -v ON_ERROR_STOP=1 <<-EOSQL
	-- using psql env vars instead of CLI params because these end up empty
	CREATE USER $DB_USER with password '$DB_PASSWORD' CREATEDB;
EOSQL

echo "** Creating DB";

PGDATABASE=postgres PGUSER="$DB_USER" PGPASSWORD="$DB_PASSWORD" psql -v ON_ERROR_STOP=1 <<-EOSQL
	CREATE DATABASE $DB_NAME encoding 'UTF8';
EOSQL

echo "** Finished DB setup";

