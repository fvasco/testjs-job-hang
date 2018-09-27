FROM gradle:4.10.2-jdk8

WORKDIR /home/gradle

COPY build.gradle /home/gradle
COPY package.json /home/gradle
COPY package-lock.json /home/gradle

RUN gradle --no-daemon npmInstall

ADD src /home/gradle/src

CMD ["gradle", "--no-daemon", "--info", "build"]
