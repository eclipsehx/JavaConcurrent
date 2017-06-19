package chapter04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 6-3
 */
public class ThreadState {

	private static Lock lock = new ReentrantLock();

	public static void main(String[] args) {

		new Thread(new TimeWaiting(), "TimeWaitingThread").start();
		new Thread(new Waiting(), "WaitingThread").start();

		// 使用两个 Blocked 线程，一个获取锁成功，另一个被阻塞
		new Thread(new Blocked(), "BlockedThread-1").start();
		new Thread(new Blocked(), "BlockedThread-2").start();

		new Thread(new Sync(), "SyncThread-1").start();
		new Thread(new Sync(), "SyncThread-2").start();
	}

	/**
	 * 该线程不断的进行睡眠
	 */
	static class TimeWaiting implements Runnable {
		@Override
		public void run() {
			while (true) {
				SleepUtils.second(100);
			}
		}
	}

	/**
	 * 该线程在 Waiting.class 实例上等待
	 */
	static class Waiting implements Runnable {

		@Override
		public void run() {

			while (true) {
				synchronized (Waiting.class) {
					try {
						Waiting.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * 该线程在 Blocked.class 实例上加锁后，不会释放该锁
	 */
	static class Blocked implements Runnable {

		@Override
		public void run() {
			synchronized (Blocked.class) {
				while (true) {
					SleepUtils.second(100);
				}
			}
		}
	}

	static class Sync implements Runnable {

		@Override
		public void run() {

			lock.lock();

			try {
				SleepUtils.second(100);
			} finally {
				lock.unlock();
			}
		}
	}

}
