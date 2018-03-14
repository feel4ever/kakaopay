package com.kakaopay.feel.common;

public class Response<T> {
    private int responseCode;
    private String responseName;
    private T result;

    public Response() {
    }

    public Response(int responseCode, String responseName) {
        this.responseCode = responseCode;
        this.responseName = responseName;
        this.result = null;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseName() {
        return responseName;
    }

    public void setResponseName(String responseName) {
        this.responseName = responseName;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "responseCode='" + responseCode + '\'' +
                ", responseName='" + responseName + '\'' +
                ", result=" + result +
                '}';
    }
}
