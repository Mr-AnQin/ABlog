package top.aqlog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.aqlog.exception.MethodTheRetryMechanismIsException;
import top.aqlog.exception.NotFoundException;
import top.aqlog.exception.PersistenceException;
import top.aqlog.model.vo.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 对Controller层全局异常处理
 * @RestControllerAdvice 捕获异常后，返回json数据类型
 * @Author anqin
 * @Date 2020-08-14
 */
@RestControllerAdvice
public class ControllerExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 没有发现异常处理程序
     * 捕获自定义的404异常
     *
     * @param request 请求
     * @param e       自定义抛出的异常信息
     * @return {@link Result}
     */
    @ExceptionHandler(NotFoundException.class)
    public Result notFoundExceptionHandler(HttpServletRequest request, NotFoundException e) {
        logger.error("Request URL : {}, Exception :", request.getRequestURL(), e);
        return Result.create(404, e.getMessage());
    }

    /**
     * 持久性异常处理程序
     * 捕获自定义的持久化异常
     *
     * @param request 请求
     * @param e       自定义抛出的异常信息
     * @return {@link Result}
     */
    @ExceptionHandler(PersistenceException.class)
    public Result persistenceExceptionHandler(HttpServletRequest request, PersistenceException e) {
        logger.error("Request URL : {}, Exception :", request.getRequestURL(), e);
        return Result.create(500, e.getMessage());
    }

    /**
     * 用户名没有找到异常处理程序
     * 捕获自定义的登录失败异常
     *
     * @param request 请求
     * @param e       自定义抛出的异常信息
     * @return {@link Result}
     */
    @ExceptionHandler(UsernameNotFoundException.class)
    public Result usernameNotFoundExceptionHandler(HttpServletRequest request, UsernameNotFoundException e) {
        logger.error("Request URL : {}, Exception :", request.getRequestURL(), e);
        return Result.create(401, "用户名或密码错误！");
    }

    /**
     * 异常处理程序
     * 捕获其它异常
     *
     * @param request 请求
     * @param e       异常信息
     * @return {@link Result}
     */
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(HttpServletRequest request, Exception e) {
        logger.error("Request URL : {}, Exception :", request.getRequestURL(), e);

        return Result.create(500, "异常错误");
    }

    /**
     * 方法重试机制是例外
     *
     * @param request 请求
     * @param e       e
     */
    @ExceptionHandler(MethodTheRetryMechanismIsException.class)
    public void methodTheRetryMechanismIsException(HttpServletRequest request, Exception e) {
        logger.info("Request URL : {},result:{}", request.getRequestURL(), e.getMessage());
    }
}
