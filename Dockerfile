FROM gradle:4.10.2-jdk8

copy . /home/gradle

WORKDIR /home/gradle

CMD ["gradle", "--no-daemon", "--info", "npmInstall", "build"]
