package com.starting.Chapter2_CDI.AnnotationLiterals;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Target({ElementType.TYPE, ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Retention(RUNTIME)
@Documented

public @interface  OrderCancelled
{
    String value() default  "";
}
