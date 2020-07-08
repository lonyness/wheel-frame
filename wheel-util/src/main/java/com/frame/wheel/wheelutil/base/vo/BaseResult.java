package com.frame.wheel.wheelutil.base.vo;

import java.io.Serializable;
import java.util.List;

/**
* @Description:    对返回数据进行封装
* @Author:         lonyness
* @CreateDate:     2020/7/08 0:06
*/
public class BaseResult implements Serializable {

    public static final String RESULT_SUCCESS = "success";
    public static final String RESULT_FALSE = "false";
    public static final String SUCCESS = "成功";

    /**
     * 信息说明
     */
    private String result;
    /**
     * 数据
     */
    private Object data;
    /**
     * 说明
     */
    private String message;
    /**
     * 错误集合
     */
    private List<Error> errors;

    public static String getResultOk() {
        return RESULT_SUCCESS;
    }

    public static String getResultNotOk() {
        return RESULT_FALSE;
    }

    public static String getSUCCESS() {
        return SUCCESS;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    /**
     * 成功，无数据，有说明
     * @return
     */
    public static BaseResult successMessage(){
        return createResult(RESULT_SUCCESS,null,SUCCESS);
    }
    /**
     * 成功，无数据，自定义说明
     * @return
     */
    public static BaseResult successMessage(String message){
        return createResult(RESULT_SUCCESS,null,message);
    }
    /**
     * 成功，有数据，有说明
     * @return
     */
    public static BaseResult successMessage(Object data){
        return createResult(RESULT_SUCCESS,data,SUCCESS);
    }

    /**
     * 失败，无数据，无说明，带错误信息
     * @return
     */
    public static BaseResult faileMessage(String message){
        return createResult(RESULT_FALSE,null,message);
    }
    /**
     * 失败，无数据，无说明，无错误信息
     * @return
     */
    public static BaseResult faileMessage(){
        return createResult(RESULT_FALSE,null,"");
    }

    private static BaseResult createResult(String result,Object data,String message){
        BaseResult baseResult = new BaseResult();
        baseResult.setResult(result);
        baseResult.setData(data);
        baseResult.setMessage(message);
        return baseResult;
    }
}

