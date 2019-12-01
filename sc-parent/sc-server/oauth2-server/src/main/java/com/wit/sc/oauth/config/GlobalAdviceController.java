package com.wit.sc.oauth.config;

import com.wit.sc.oauth.web.entity.ResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ctw
 * @Project： sc-parent
 * @Package: com.wit.sc.portal.config
 * @Description:全局异常捕获
 * @date 2019/6/16 11:24
 */
@ControllerAdvice(
        basePackages={"com.wit.sc.oauth.web.controller"},
        annotations = {RestController.class, Controller.class})
public class GlobalAdviceController {

    Logger logger = LoggerFactory.getLogger(GlobalAdviceController.class);

    /**
     * 全局异常处理
     * @param e
     * @param response
     * @return
     */
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public ResultDto<String> exceptionHandler(RuntimeException e, HttpServletResponse response) {
        logger.error(e.getMessage(), e);
        return ResultDto.failT(e.getMessage());
    }
}
