#!/usr/bin/env sh
set -eu

# Lê a senha do secret e exporta para a variável que o Spring espera
if [ -f /run/secrets/db_secrets ]; then
  export SPRING_DATASOURCE_PASSWORD="$(cat /run/secrets/db_secrets)"
fi

exec sh -c "java $JAVA_OPTS -jar /app/app.jar"
