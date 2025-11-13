#!/usr/bin/env sh

echo "JAVA_OPTS: $JAVA_OPTS"
echo "Verificando Java:"
java -version
echo "Verificando JAR:"
ls -l /app/app.jar

exec java $JAVA_OPTS -jar /app/app.jar