package home.petshop.sys.controller;

import home.petshop.commons.service.ServiceException;
import home.petshop.commons.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler
    public R handlerServiceException(ServiceException e){
        return R.failed(e);
    }

    @ExceptionHandler
    public R handlerException(Exception e){
        return R.failed(e);
    }
}
