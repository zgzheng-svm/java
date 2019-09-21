package com.zheng.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * 模拟Jvm堆溢出
 * 设置堆区参数 -Xmx10m -Xms10m
 * -XX:+HeapDumpOnOutOfMemoryError  -XX:HeapDumpPath=E:\opt\applog\jvm\heapDumpOnOutOfMemoryError.hprof
 */
public class HeapDumpDemo {
	static class OOMObject{
		
	}
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}

}
