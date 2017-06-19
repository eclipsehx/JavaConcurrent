package chapter05;

import java.util.concurrent.locks.Lock;

import org.junit.Test;

import chapter04.SleepUtils;

/**
 * 10-11
 */
public class TwinsLockTest {

	@Test
	public void test() {

		final Lock lock = new TwinsLock();

		class Worker extends Thread {

			@Override
			public void run() {

				while (true) {

					lock.lock();

					try {
						SleepUtils.second(1);
						System.out.println(Thread.currentThread().getName());
						SleepUtils.second(1);
					} finally {
						lock.unlock();
					}
				}
			}
		}

		// 启动 10 个线程
		for (int i = 0; i < 10; i++) {
			Worker w = new Worker();
			w.setDaemon(true);
			w.start();
		}

		// 每隔 1 秒换行
		for (int i = 0; i < 10; i++) {
			SleepUtils.second(1);
			System.out.println();
		}
	}
}
