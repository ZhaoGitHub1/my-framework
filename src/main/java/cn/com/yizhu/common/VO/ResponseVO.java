package cn.com.yizhu.common.VO;

import java.io.Serializable;

/**
 * 全局响应VO
 */
public class ResponseVO<T> implements Serializable {
    private static final long serialVersionUID = 2635002588308355785L;
    private int status;
    private String msg;
    private T data;

    public ResponseVO() {
    }

    public ResponseVO(int status) {
        this.status = status;
    }

    public ResponseVO(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResponseVO(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public ResponseVO(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}