# 使用基础的Java镜像
FROM openjdk:8-jdk-alpine

# 将本地jar文件复制到容器中
#COPY AnQin.jar /app/AnQin.jar
COPY ../blog-api/target/AnQin.jar /app/AnQin.jar

# 设置工作目录
WORKDIR /app

# 暴露容器端口
EXPOSE 8080

# 运行jar文件
CMD ["java", "-jar", "AnQin.jar", "--spring.profiles.active=prod", "--server.port=8080"]


#健康检查
#HEALTHCHECK --interval=5s --timeout=60s \
#  CMD curl -fs http://10.0.4.7:8080/about || exit 1


# 指定维护者的名字
MAINTAINER anqin<1306895785@qq.com>