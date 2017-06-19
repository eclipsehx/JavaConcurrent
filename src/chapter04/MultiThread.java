package chapter04;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.lang.management.ThreadInfo;

/**
 * 6-1
 */
public class MultiThread {

	public static void main(String[] args) {
		// ��ȡ Java �̹߳��� MXBean
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		// ����Ҫ��ȡͬ���� monitor �� synchronizer ��Ϣ��������ȡ�̺߳��̶߳�ջ��Ϣ
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
		// �����߳���Ϣ������ӡ�߳� ID ���߳�������Ϣ
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
		}
	}
}
