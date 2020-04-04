FROM java:8
VOLUME //usr/local/work-app/docker
COPY target/cloud-blog-register-center.jar register-center.jar
RUN bash -c "touch /register-center.jar"
EXPOSE 20200
ENTRYPOINT ["java","-jar","register-center.jar"]
