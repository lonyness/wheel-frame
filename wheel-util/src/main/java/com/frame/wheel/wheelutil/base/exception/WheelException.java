package com.frame.wheel.wheelutil.base.exception;

/**
 * 创建自定义异常
 */
public class WheelException extends RuntimeException{

    public WheelException(String ErrorMessage){	//构造方法
        super(ErrorMessage);		//父类构造方法
    }
}