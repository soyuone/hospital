package com.song.hospital.common.filter;

import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.song.hospital.common.controller.ControllerBase;
import com.song.hospital.common.util.WebsiteConfig;

/**
 * 自定义filter，预处理和后处理
 */
public class PreProcessFilter implements Filter {

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	private static String KEY_ORIG_REQUEST_URI = WebsiteConfig.KEY_ORIG_REQUEST_URI;

	private static String KEY_ORIG_REQUEST_URL = WebsiteConfig.KEY_ORIG_REQUEST_URL;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		try {
			preProcess(request, response, chain);
		}
		catch (Exception e) {
			log.warn("preProcess:", e);
		}

		// doFilter方法为分界线，执行该方法之前对用户请求进行预处理，执行该方法之后即对服务器响应进行后处理
		chain.doFilter(request, response);

		try {
			afterProcess(request, response);
		}
		catch (Exception e) {
			log.warn("afterProcess:", e);
		}
	}

	@Override
	public void destroy() {
		contextDestroyed();
	}

	private final void preProcess(ServletRequest request, ServletResponse response, FilterChain chain) {
		// clear
		//ControllerBase.clearThreadLoginUser();

		if (request instanceof HttpServletRequest) {
			HttpServletRequest hsr = (HttpServletRequest) request;

			String origURI = hsr.getRequestURI();
			String origURL = hsr.getRequestURL().toString();

			hsr.setAttribute(KEY_ORIG_REQUEST_URI, origURI);
			hsr.setAttribute(KEY_ORIG_REQUEST_URL, origURL);
		}
	}

	private final void afterProcess(ServletRequest request, ServletResponse response) {
		// clear
		//ControllerBase.clearThreadLoginUser();
	}

	/**
	 * close any background tasks which may use the DB, then close any DB connection pools. deregister jdbc drivers in
	 * this context's ClassLoader.
	 */
	public final void contextDestroyed() {

		// 获取 webapp's ClassLoader
		// the context ClassLoader for this Thread, or null indicating the system class loader.
		ClassLoader cl = Thread.currentThread().getContextClassLoader();

		// the list of JDBC Drivers loaded by the caller's class loader.
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while (drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			if (driver.getClass().getClassLoader() == cl) {
				// 如果是此webapp's ClassLoader注册的，则deregister it.
				try {
					log.info("Deregister JDBC driver: " + driver.toString());
					DriverManager.deregisterDriver(driver);
				}
				catch (Exception e) {
					log.error("Error occurs when deregister JDBC driver: " + driver.toString(), e);
				}
			}
			else {
				// 如果不是此webapp's ClassLoader注册的， may be in use elsewhere.
				log.trace("Can't deregister JDBC driver: " + driver.toString()
						+ " as it does not belong to this webapp's ClassLoader.");
			}
		}
	}
}
