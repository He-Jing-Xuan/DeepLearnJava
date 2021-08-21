package string;

import code.test3;

public class StringTest4 {

    public static void test1(){
        String s2 ="abc";//字符串常量池
        String s1 ="a"+"b"+"c";

        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
    }
    public static void test2(){
        String s1 = "javaEE";
        String s2 ="hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE"+"hadoop";
        String s5 = s1+"hadoop";
        String s6 = "javaEE"+s2;
        String s7 = s1+s2;
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s6 == s5);
        System.out.println(s5 == s7);
        System.out.println(s6 == s7);
        String s8 = s6.intern();
        System.out.println(s3 == s8);
    }
    public static void test3(){
        //变量  stringBuilder
        String s1 ="a";
        String s2 = "b";
        String s3 ="ab";
        String s4 = s1+s2;
        System.out.println(s3==s4);// false
    }
    public static void test4(){
        //常量 直接拼接  编译器优化
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        String s4 = s1 +s2;
        System.out.println(s3 == s4); // TURE
    }
    public static void test5(){
        String s = new String("1");//堆中
        s.intern();
        String s2 ="1";//常量池中
        System.out.println(s==s2);//ture

        String s3 = new String("1")+new String("1");//堆中的 11
        s3.intern();//因为常量池之前没有 11  因此 将 堆中 11的地址放入常量池
        String s4 = "11";// 拿到常量池中的11
        System.out.println(s3 == s4);// true   因为 s4 常量池中的 11  指向的是 堆中的11
    }
    public static void test6(){
        String s0 ="ab";
       String s1 = s0.intern();
        System.out.println(s0==s1);//true  字符串常量池的 ab
        String s2 = new String("a")+new String("b");  //在堆中 new的 ab
        System.out.println(s1==s2);//false
        String s3 =s2.intern();// s2.intern() 将 堆中的ab 放到常量池中， 但是常量池中已经有了ab  因此将 ab 的引用返回给s3
        System.out.println(s3 == s1);//true 在常量池的 ab
        System.out.println(s3 == s2);// false; 因为 s3拿到的是 常量池中的ab  而s2 是在堆中的ab

    }
    public static void test7(){
        String s2 = new String("a")+new String("b");
        String s3 =s2.intern();//  因为 常量池中 没有 ab  因为将 堆中ab的地址放到常量池 并返回给 s3
        System.out.println(s3 == s2);//  true    因为 s3拿到的是常量池ab的引用， 而常量池中 又指向的 堆中的 ab

    }
    public static void test8(){
        String s0 ="ab";
        String s2 = new String("a")+new String("b");
        String s3 =s2.intern();//  因为 常量池中 没有 ab  因为将 堆中ab的地址放到常量池 并返回给 s3
        System.out.println(s3 == s2);//  true    因为 s3拿到的是常量池ab的引用， 而常量池中 又指向的 堆中的 ab

    }
    public static void main(String[] args) {
        test5();
        test7();
        test8();
    }
}
