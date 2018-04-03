package com.younggambyeon.test;

public class JavaThreadLocal {

	private ThreadLocal<?> threadLocal;

	public void setThreadLocal(ThreadLocal<?> threadLocal) {
		this.threadLocal = threadLocal;
	}

	public static void main(String[] args) {
		JavaThreadLocal testClass = new JavaThreadLocal();

		testClass.setThreadLocal(new ThreadLocal<String>());

		String str = (String) testClass.threadLocal.get();

		testClass.threadLocal.remove();
	}
}
