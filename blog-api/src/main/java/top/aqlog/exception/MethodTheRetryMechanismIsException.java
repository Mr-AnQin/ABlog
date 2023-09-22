package top.aqlog.exception;


/**
 * 方法重试机制是例外
 *
 * @author Mr.An
 * @date 2023-04-09 16:18:23
 */
public class MethodTheRetryMechanismIsException extends IllegalArgumentException {

    public MethodTheRetryMechanismIsException() {

    }

    public MethodTheRetryMechanismIsException(String msg) {
        super(msg);
    }

    public MethodTheRetryMechanismIsException(String msg, Throwable t) {
        super(msg, t);
    }
}
