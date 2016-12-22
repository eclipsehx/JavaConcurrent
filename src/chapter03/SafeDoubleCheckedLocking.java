package chapter03;

public class SafeDoubleCheckedLocking {

	private volatile static Instance instance;		// instance Ϊ volatile ����

	public static Instance getInstance() {

		if (instance == null) {
			synchronized (SafeDoubleCheckedLocking.class) {
				if (instance == null)
					instance = new Instance();		// instanceΪvolatile������û������
			}
		}

		return instance;
	}

	static class Instance {
	}
}
