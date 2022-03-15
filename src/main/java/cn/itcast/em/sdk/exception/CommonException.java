package cn.itcast.em.sdk.exception;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/15
 */
public class CommonException extends RuntimeException {

    private String msg;

    public CommonException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
