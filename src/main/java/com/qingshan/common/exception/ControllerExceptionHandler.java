package com.qingshan.common.exception;

import com.qingshan.common.web.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 通过此注解申明此类为一个全局异常处理类型
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    /**
     * 当spring发现系统出现异常了，且异常的类型为ServiceException
     * 类型，此时就会回调此方法，并将异常值传递给这个方法
     * 这时我们就可以在此方法中对业务异常进行统一处理，例如
     * 封装到jsonResult然后写到客户端告诉客户
     * @param e
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public JsonResult handleServiceException(ServiceException e){
        e.printStackTrace();
        //将异常封装到JsonResult
        return new JsonResult(e);

}

}
