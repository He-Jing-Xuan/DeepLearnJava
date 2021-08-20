package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//	 DoSomething ds1=new DoSomething("小贺");
//	 DoSomething ds2=new DoSomething("小谢");
//	 Thread thread=new Thread(ds1);
//	 Thread thread2=new Thread(ds2);
//	 thread.start();
//	 thread2.start();
//		List<List<String>> fa=new LinkedList<>();
//		List<String> c=new ArrayList<>();
//		c.add("before");
//		fa.add(c);
//		c.add(" ad");
//		System.out.println(fa);
		String s1="hello";
		String s2="world";
		change(s1,s2);
		System.out.println(s1+"---"+s2);
		StringBuffer sb1=new StringBuffer("hello");
		StringBuffer sb2=new StringBuffer("world");
		System.out.println(sb1+"---"+sb2);
		change(sb1,sb2);
		System.out.println(sb1+"---"+sb2);
    }
    public static void change(StringBuffer sb1,StringBuffer sb2){
    	sb1=sb2;
    	sb2.append(sb1);
	}
	public static void change(String s1,String s2){
    	s1=s2;
    	s2=s1+s2;
	}
}
