package com.jxedu.commons;

public class Result {

       private String status;

        private String message;

        private Object result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Result(String status, Object result) {
        this.status = status;
        this.result = result;
    }

    public Result(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
