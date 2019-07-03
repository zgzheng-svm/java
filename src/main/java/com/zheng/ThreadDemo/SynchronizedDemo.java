package com.zheng.ThreadDemo;

/**
 * Hello world!
 *
 */
public class SynchronizedDemo implements Runnable
{
	private static int i = 0;
    public static void main( String[] args )
    {   
    	SynchronizedDemo demo1 = new SynchronizedDemo();
//    	SynchronizedDemo demo2 = new SynchronizedDemo();
    	Thread t1 = new Thread(demo1);
    	Thread t2 = new Thread(demo1);
    	t1.start();
    	t2.start();
    	try {
    		//main线性等待t1线程执行完
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println( "i = " + i);
    }

	public void run() {
		increase();
	}
	private synchronized void increase() {
		for(int j = 0; j<10000; j++){
			i++;
		}
		
	}
}
