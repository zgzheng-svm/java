package com.zheng.classinitialized;

public class Insect {
    private int i = 9;
    protected int j = 1;
    static{
    	System.out.println("hahaha");
    }
    protected static int x1 = printInit("static Insect.x1 initialized");
    
    static{
    	System.out.println("hehehe");
    }
    Insect() {
        System.out.println("父类构造函数执行： i = " + i + ", j = " + j);
        j = 39;
    }
    {
    	System.out.println("父类构造代码块执行");
    }
    
    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}