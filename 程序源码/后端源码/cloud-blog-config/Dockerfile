FROM java:8
VOLUME //usr/local/work-app/docker
COPY target/cloud-blog-config.jar config.jar
RUN bash -c "touch /config.jar"
EXPOSE 20020
ENTRYPOINT ["java","-jar","config.jar"]
