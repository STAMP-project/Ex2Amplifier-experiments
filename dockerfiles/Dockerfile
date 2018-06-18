FROM maven:3-jdk-8

ENV CASE_STUDY=

COPY install.sh /root/install.sh

RUN /root/install.sh

COPY run_case_study.sh /root/Ex2Amplifier-experiments/run_case_study.sh

ENTRYPOINT /root/Ex2Amplifier-experiments/run_case_study.sh
