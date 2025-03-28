#!/bin/sh
# Wait until Postgres is ready

set -e
host="$1"
shift
until pg_isready -h "$host" -p 5432; do
  echo "Waiting for postgres at $host..."
  sleep 2
done

exec "$@"
