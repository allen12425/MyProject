package org.edward.annotation;

import java.lang.annotation.*;

@MyAnnotation(value="aa")
public class MetaAnnotation {

}


//target用来声明当前自定义的注解适合用于什么地方，类，方法，变量，包，
@Target({ElementType.METHOD, ElementType.TYPE})
//retention用来表示当前注解适合用于什么环境，是源码级别还是类级别还是运行时环境，一般都是运行时环境（source<class<runtime）
@Retention(RetentionPolicy.CLASS)
//表示该注解是否是显示在javadoc中
@Documented
//表示当前注解是否能够被继承
@Inherited
@interface MyAnnotation {
    //定义的方式看起来像是方法，但是实际上是在定义使用注解的时候该注解拥有的属性，默认的属性是value
    String name() default "zhangshan";
    int age() default 25;
    String value() default  "aaa";
    int id() default 1;
}
