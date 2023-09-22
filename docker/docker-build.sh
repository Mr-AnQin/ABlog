#!/usr/bin/env zsh
set -e
set -x
export DOCKER_BUILDKIT=1
#年-月-日
timestamp=$(date +'%y-%m-%d')
##git commit hash code
hash=$(git rev-parse --short HEAD)
# shellcheck disable=SC2034
branch=$(git rev-parse --abbrev-ref HEAD)
tag="${timestamp}"-"${hash}"
buildApplication(){

  ## 构建 正式 环境
  docker \
      build \
      -f Dockerfile \
      .. \
      -t aqlog-docker.pkg.coding.net/blog/back-end/blog:"${tag}" \
      -t aqlog-docker.pkg.coding.net/blog/back-end/blog:latest


  ## 上传镜像仓储
  docker push \
    aqlog-docker.pkg.coding.net/blog/back-end/blog:"${tag}" & \

  docker push \
    aqlog-docker.pkg.coding.net/blog/back-end/blog:latest

}
buildApplication