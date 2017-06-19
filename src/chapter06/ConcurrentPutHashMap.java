/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package chapter06;

import java.util.HashMap;
import java.util.UUID;

/**
 * ���� put	--> ����ʱ�ܿ����ͽ����ˣ���û�з�����ѭ���������� JDK �汾���⣬JDK1.8 ���ܲ�����ѭ���� @2015-12-25 21:25:50
 * 
 * @author tengfei.fangtf
 * @version $Id: Snippet.java, v 0.1 2015-7-31 ���� 11:53:55 tengfei.fangtf Exp $
 */
public class ConcurrentPutHashMap {

	public static void main(String[] args) throws InterruptedException {

		final HashMap<String, String> map = new HashMap<String, String>(2);

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10000; i++) {

					new Thread(new Runnable() {
						@Override
						public void run() {
							map.put(UUID.randomUUID().toString(), "");
						}
					}, "ftf" + i).start();
				}
			}

		}, "ftf");

		t.start();
		t.join();
	}
}
