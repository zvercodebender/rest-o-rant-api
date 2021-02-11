#!/usr/bin/env bash

if [ -z "${VERSION}" ]
then
  echo "VERSION not set"
  exit -1
fi
echo "Version = ${VERSION}"

mkdir -p build/docker
cp build/libs/*.war build/docker

cp Dockerfile build/docker/Dockerfile

cd build/docker
docker build -t rbroker/rest-o-rant-api:${VERSION} .
docker login --username $DOCKER_USER --password $DOCKER_PASSWORD docker.io
docker push rbroker/rest-o-rant-api:${VERSION}
cd ../..
