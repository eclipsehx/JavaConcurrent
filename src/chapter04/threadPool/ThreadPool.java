package chapter04.threadPool;

/**
 * 6-19
 */
public interface ThreadPool<Job extends Runnable> {

	// 执行一个 Job，这个 Job 需要实现 Runnable
	void execute(Job job);

	// 关闭线程池
	void shutdown();

	// 增加工作者线程
	void addWorkers(int num);

	// 减少工作者线程
	void removeWorker(int num);

	// 得到正在等待执行的任务数量
	int getJobSize();
}
