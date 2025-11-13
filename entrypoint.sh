#!/usr/bin/env sh

echo "JAVA_OPTS: $JAVA_OPTS"
echo "Verificando Java:"
java -version
echo "Verificando JAR:"
ls -l /app/app.jar

if [ -f /run/secrets/db_secrets ]; then
  export SPRING_DATASOURCE_PASSWORD="$(cat /app/secrets/db_secrets)"
fi

exec java $JAVA_OPTS -jar /app/app.jar