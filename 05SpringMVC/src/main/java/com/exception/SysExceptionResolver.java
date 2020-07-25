package com.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException exception = null;
        if(e instanceof SysException){
            exception = (SysException) e;
        }else{
            exception = new SysException("系统运行异常");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errormsg",exception.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
