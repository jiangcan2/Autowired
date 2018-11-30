package com.auto.util;

import java.lang.annotation.*;

/**
 * ElementType.TYPE——限制在类、接口（包括注解）和枚举范围中
 *
 * ElementType.FIELD——限制在定义的属性字段上标注（包括枚举常量）
 *
 * ElementType.METHOD——限制在方法上使用
 *
 * ElementType.PARAMETER——限制在参数上使用
 *
 * ElementType.CONSTRUCTOR——限制在构造函数上使用
 *
 * ElementType.LOCAL_VARIABLE——限制在局部变量上使用
 *
 * ElementType.ANNOTATION_TYPE——限制在注解上使用
 *
 * ElementType.PACKAGE——限制在包上使用
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value();
}
