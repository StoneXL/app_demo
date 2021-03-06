package com.example.ai.myapplication2.application;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @author zhaoyun
 * @desc 功能描述
 * @date 2016/7/22 11:58
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Remote {

}
