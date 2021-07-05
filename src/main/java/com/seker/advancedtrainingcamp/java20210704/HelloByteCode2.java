package com.seker.advancedtrainingcamp.java20210704;

public class HelloByteCode2 {

    private String name;

    private String idCard;

    HelloByteCode2() {}

    HelloByteCode2(String name, String idCard) {
        this.name = name;
        this.idCard = idCard;
    }

    public static void main(String[] args) {
        HelloByteCode2 helloByteCode2 = new HelloByteCode2("java", "id001");
        helloByteCode2.hasArgsDemo1();
        helloByteCode2.hasArgsDemo2("str1", "str2", "str3");
        HelloByteCode2.noArgsDemo1();
        HelloByteCode2.noArgsDemo2("str1", "str2", "str3", "str4");
    }

    public void hasArgsDemo1() {}

    public void hasArgsDemo2(String str1, String str2, String str3) {
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }

    public static void noArgsDemo1() {}

    public static void noArgsDemo2(String str1, String str2, String str3, String str4) {
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
    }

}
