package com.whh.spring.boot.service.impl;

/**
 * @author huahui.wu
 * @date 2018/6/25 11:21
 * @description
 */
public class RegexTest {

    public static void main(String[] args) {
        String url = "http://www.fapiao.com/dddp-web/pdf/download?request=6e7JGxxxxx4ILd-kExxxxxxxqJ4-CHLmqVnenXC692m74H38sdfdsazxcUmfcOH2fAfY1Vw__%5EDadIfJgiEf";
        String regex = "^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)++([A-Za-z0-9-~\\\\/])+$";

        if (url.matches(regex)) {
            System.out.println("match!!");
        } else {
            System.out.println("no match!!");
        }
    }
}
