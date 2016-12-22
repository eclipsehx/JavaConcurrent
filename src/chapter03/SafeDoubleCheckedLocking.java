package chapter03;

public class SafeDoubleCheckedLocking {

	private volatile static Instance instance;		// instance 为 volatile 变量

	public static Instance getInstance() {

		if (instance == null) {
			synchronized (SafeDoubleCheckedLocking.class) {
				if (instance == null)
					instance = new Instance();		// instance为volatile，现在没问题了
			}
		}

		return instance;
	}

	static class Instance {
	}
}
