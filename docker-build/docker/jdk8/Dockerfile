FROM ubuntu:trusty
MAINTAINER kkamimura@seamark.co.jp
RUN apt-get update && apt-get -y upgrade

RUN apt-get install -y aptitude && \
  aptitude -y install language-pack-ja-base language-pack-ja && \
  update-locale LANG=ja_JP.UTF-8 LANGUAGE="ja_JP:ja"

ENV LANG ja_JP.UTF-8
ENV LC_ALL ja_JP.UTF-8
ENV LC_CTYPE ja_JP.UTF-8

RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  apt-get install -y software-properties-common && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y oracle-java8-installer && \
  apt-get install -y git && \
  apt-get autoclean && \
  apt-get clean
