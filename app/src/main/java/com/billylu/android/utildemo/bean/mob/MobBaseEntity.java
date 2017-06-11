package com.billylu.android.utildemo.bean.mob;

import java.io.Serializable;

/**
 * Created by maning on 2017/5/8.
 */

public class MobBaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 7703166202155685415L;

    /**
     * msg : success
     * retCode : 200
     */

    private T results;
    private String msg;
    private String retCode;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "MobBaseEntity{" +
                "results=" + results +
                ", msg='" + msg + '\'' +
                ", retCode='" + retCode + '\'' +
                '}';
    }
}
