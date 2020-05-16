package com.edward.spring;

import com.edward.entity.Person;
import com.edward.entity.Student;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetBean {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = ctx.getBean("person", Person.class);
        Person person2 = ctx.getBean("person", Person.class);
        Person person3 = ctx.getBean("person", Person.class);
       /* Person person2 = ctx.getBean("human", Person.class);
        Person person3 = ctx.getBean("person2", Person.class);*/
       // System.out.println(ToStringBuilder.reflectionToString(person,ToStringStyle.JSON_STYLE));
        //spring bean默认情况下都是单例的
        System.out.println(person.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person3.hashCode());


    }

}
