package com.zheng.ThreadDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {
//	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static ThreadLocal<SimpleDateFormat> threadLocal= new ThreadLocal<SimpleDateFormat>();
	public static class ParseDate implements Runnable{
		private int i;
		public ParseDate(int i){
			this.i = i;
		}
		public void run() {
			SimpleDateFormat sdf = null;
			if(null == threadLocal.get()){
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//set的时候会跟当前线程相关联
				threadLocal.set(sdf);
			}else{
				//get的时候会跟当前线程相关联
				sdf = threadLocal.get();
			}
			try {
				Date date = sdf.parse("2019-04-14 15:07:"+i%60);
				System.out.println(i+":"+date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(5);
		for(int j = 0;j < 100; j++){
//			es.submit(new ParseDate(j));
			es.execute(new ParseDate(j));
		}
	}
}
