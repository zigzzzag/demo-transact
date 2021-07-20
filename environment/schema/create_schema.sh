docker cp ./create-schema.sql postgres_db:/docker-entrypoint-initdb.d/create-schema.sql
docker exec -u postgres postgres_db psql -d demo admin -f docker-entrypoint-initdb.d/create-schema.sql