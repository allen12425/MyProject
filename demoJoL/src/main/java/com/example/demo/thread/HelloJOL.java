package com.example.demo.thread;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

public class HelloJOL {
    public static void main(String[] args) {
      /*  try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Object obj = new Object();

        /**
         * 前面8个字节就是markword,紧跟后面4个classpoint，最后面4个字节是padding（补齐）
         */
        String s = ClassLayout.parseInstance(obj).toPrintable();
        System.out.println(s);
        System.out.println("======================");

        obj.hashCode();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        System.out.println("==================");

        /**
         * 所谓的加锁就是在对象头markword上修改信息（理解为把线程的ID记录到markWord里）
         */
        synchronized (obj){
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
        System.out.println("====================");

        System.out.println(ClassLayout.parseClass(Object.class).toPrintable());
    }
}
