#!/usr/bin/env bash

if [ -z "${VERSION}" ]
then
  echo "VERSION not set"
  exit -1
fi
echo "Version = ${VERSION}"

./gradlew clean build
