#!/usr/bin/env bash

export CLI_VERSION="10.0.0"
if [ -z "${VERSION}" ]
then
  echo "VERSION not set"
  exit -1
fi
echo "Version = ${VERSION}"

cp -R src/yaml build/yaml
sed "s/{{VERSION}}/${VERSION}/g" src/yaml/artifacts/rest-o-rant-api.yaml > build/yaml/artifacts/rest-o-rant-api.yaml
cd build/yaml
if [ -z "${GET_LOCAL}" ]
then
  xl apply --file web.yaml --values version=$VERSION
else
  curl -LO https://dist.xebialabs.com/public/xl-cli/$CLI_VERSION/linux-amd64/xl
  chmod +x xl
  ./xl apply --xl-deploy-url="${XLD_URL}" --xl-deploy-username="${XLD_USER}" --xl-deploy-password="${XLD_PASSWD}" --file api.yaml --values version=$VERSION
  rm xl
fi
cd ../..
