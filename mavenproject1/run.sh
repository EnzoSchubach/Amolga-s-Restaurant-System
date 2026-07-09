#!/bin/bash
# Script para compilar e rodar o projeto localmente
cd "$(dirname "$0")"
echo "Compilando o projeto..."
mkdir -p target/classes
find src/main/java -name "*.java" > sources.txt
javac -d target/classes -cp "/home/mirella/.m2/repository/org/netbeans/external/AbsoluteLayout/RELEASE300/AbsoluteLayout-RELEASE300.jar" @sources.txt
rm sources.txt

echo "Executando a aplicação..."
java -cp "/home/mirella/.m2/repository/org/netbeans/external/AbsoluteLayout/RELEASE300/AbsoluteLayout-RELEASE300.jar:target/classes" com.amolga.mavenproject1.view.InitialScreen
