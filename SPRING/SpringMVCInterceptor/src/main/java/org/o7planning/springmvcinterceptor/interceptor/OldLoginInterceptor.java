package org.o7planning.springmvcinterceptor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class OldLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("\n-------- OldLoginInterceptor.preHandle --- ");
		System.out.println("Request URL: " + request.getRequestURL());
		System.out.println("Sorry! This URL is no longer used, Redirect to /admin/login");

		response.sendRedirect(request.getContextPath() + "/admin/login");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// This code will never be run.
		System.out.println("\n-------- OldLoginInterceptor.postHandle --- ");
	}

	public void afterCompletition(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) throws Exception {
		System.out.println("\n------ LogInterception.afterCompletition ----");
		long startTime = (Long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();

		System.out.println("Request URL: " + request.getRequestURL());
		System.out.println("End Time: " + endTime);

		System.out.println("Time Taken: " + (endTime - startTime));

	}
}
