package com.dm.login.config;

import com.dm.login.exception.ErrorMessage;
import com.dm.login.exception.IllegalPropertiesException;
import com.dm.login.exception.NullOrEmptyException;
import com.dm.login.exception.SessionNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 所有验证框架异常捕获处理
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class})
    @ResponseBody
    public ErrorMessage<String> validationExceptionHandler(HttpServletRequest request,Exception exception){
        BindingResult bindingResult = null;
        if(exception instanceof BindingResult){
            bindingResult = ((BindException)exception).getBindingResult();
        }else if(exception instanceof MethodArgumentNotValidException){
            bindingResult = ((MethodArgumentNotValidException)exception).getBindingResult();
        }
        String msg;
        if(bindingResult != null && bindingResult.hasErrors()){
            msg = bindingResult.getAllErrors().get(0).getDefaultMessage();
            if(msg.contains("NumberFormatException")){
                msg = "参数类型错误";
            }
        }else{
            msg = "系统繁忙，请稍后重试....";
        }
        return handleErrorInfo(request,msg,exception);
    }

    @ExceptionHandler(SessionNotFoundException.class)
    @ResponseBody
    public ErrorMessage<String> sessionNotFoundExceptionHandler(HttpServletRequest request,SessionNotFoundException exception) throws Exception{
        return handleErrorInfo(request,exception.getMessage(),exception);
    }

    @ExceptionHandler(NullOrEmptyException.class)
    @ResponseBody
    public ErrorMessage<String> nullOrEmptyExceptionHandler(HttpServletRequest request,NullOrEmptyException exception) throws Exception{
        return handleErrorInfo(request,exception.getMessage(),exception);
    }

    @ExceptionHandler(IllegalPropertiesException.class)
    @ResponseBody
    public ErrorMessage<String> illegalPropExceptionHandler(HttpServletRequest request, IllegalPropertiesException exception) throws Exception {
        return handleErrorInfo(request, exception.getMessage(), exception);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorMessage<String> exceptionHandler(HttpServletRequest request,Exception exception) throws Exception{
        return handleErrorInfo(request,exception.getMessage(),exception);
    }

    private ErrorMessage<String> handleErrorInfo(HttpServletRequest request, String message, Exception exception){
        ErrorMessage<String> errorMessage = new ErrorMessage<>();
        errorMessage.setMessage(message);
        errorMessage.setCode(ErrorMessage.ERROR);
        errorMessage.setData(message);
        errorMessage.setUrl(request.getRequestURI().toString());
        log.error("{}",errorMessage);
        return errorMessage;
    }

}
