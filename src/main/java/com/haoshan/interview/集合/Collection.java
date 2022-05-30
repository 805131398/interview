package com.haoshan.interview.集合;

public class Collection {


    public static void main(String[] args) {
        double result = 1;
        // 用 v 来确定此次循环是加还是减, 减还可以用 - 负数来标识,+(-1) = -1
        double v = -1;
        for (double i = 2; i < 101; i++) {
            // 每次循环的结果 p
            double p = 1 / (i * v);
//            result += p;
            result = result + p;
//            v *= -1;
            v = v * -1;
        }
        System.out.printf("result : ", result);
    }
}
