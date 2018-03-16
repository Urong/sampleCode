package com.younggambyeon.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Dynamic Proxy
 * 
 * newProxyInstance
 * 
 */

public class DynamicProxyTest implements java.lang.reflect.InvocationHandler {

	private Object obj;

	public static Object newInstance(Object obj) {
		return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				new DynamicProxyTest(obj));
	}

	private DynamicProxyTest(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		Object result;
		try {
			System.out.print("begin method " + m.getName() + "(");
			for (int i = 0; i < args.length; i++) {
				if (i > 0)
					System.out.print(",");
				System.out.print(" " + args[i].toString());
			}
			System.out.println(" )");
			result = m.invoke(obj, args);
		} catch (InvocationTargetException e) {
			throw e.getTargetException();
		} catch (Exception e) {
			throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
		} finally {
			System.out.println("end method " + m.getName());
		}
		return result;
	}

}
