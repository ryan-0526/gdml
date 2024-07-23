# gsql 简介

gdml：主要实现 bi 项目 select 语句生成

## 基础架构
嵌套在任意项目maven中作为一个工具包使用

## 项目环境
    java version: jdk8
    maven version: 3.8.4

## 项目包结构
    gsql
    |-- bi     -- 生成sql信息的实体类
    |-- gselect       --生成select

然后用maven编译项目

    $ mvn clean install

## 项目测试
    
    1.测试启动类
        com.geominfo.gsql.DmlContextTest
    

