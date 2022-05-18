package com.air_research.airwarningsystem.exception;

import com.air_research.airwarningsystem.response.ResultEnum;

/**
 * @author zwell
 */
public class CommonException extends RuntimeException {
    private Boolean success;
    private Integer code;
    private String msg;

    public CommonException(ResultEnum resultEnum, String message) {
        super(message);
        this.success = resultEnum.getSuccess();
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMessage();
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CommonException)) {
            return false;
        } else {
            CommonException other = (CommonException)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof CommonException;
    }

    @Override
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getCode();
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CommonException(code=" + this.getCode() + ", msg=" + this.getMsg() + ")";
    }
}
