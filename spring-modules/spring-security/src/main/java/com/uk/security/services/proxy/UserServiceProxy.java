package com.uk.security.services.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.slf4j.LoggerFactory;

public class UserServiceProxy implements InvocationHandler {

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceProxy.class);
	private Object object;

	public UserServiceProxy(Object object) {
		this.object = object;
	}

	public static Object newInstance(Object obj) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new UserServiceProxy(obj));
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result;
        try {
            logger.info("before method " + method.getName());
            long start = System.nanoTime();
            result = method.invoke(object, args);
            long end = System.nanoTime();
            logger.info(String.format("%s took %d ns", method.getName(), (end-start)) );
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        } finally {
            logger.info("after method " + method.getName());
        }
        return result;
	}
}
