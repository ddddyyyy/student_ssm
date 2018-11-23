package com.mdy.student.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandler implements HandlerExceptionResolver {
	
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		 Map<String, Object> model = new HashMap<>();
	        model.put("ex", arg3);
	        // 根据不同错误转向不同页面
	        return new ModelAndView("errors/error",model);
	}

}
