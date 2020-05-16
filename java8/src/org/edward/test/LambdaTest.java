package org.edward.test;

import org.edward.entity.Apple;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class LambdaTest {
    public static void main(String[] args) {
        Apple apple = new Apple("green", 1.20);
        Apple apple2 = new Apple("black", 1.25);
        Apple apple3 = new Apple("white", 1.50);
        List<Apple> inventory = new ArrayList<>();
        inventory.add(apple);
        inventory.add(apple2);
        inventory.add(apple3);


        //test2(inventory);
        //test3();
        test4();
    }

    static void test1() {
        File[] hiddenFiles = new File("d\\a").listFiles(File::isHidden);
        Arrays.stream(hiddenFiles).forEach(System.out::println);
    }

    static void test2(List<Apple> list) {
        list = list.stream().filter((Apple a) -> a.getWeight() > 1.20).collect(Collectors.toList());
        list.forEach(System.out::println);
        list.sort(Comparator.comparing(Apple::getWeight));
    }


    static void test3() {
        List<Apple> list = Arrays.asList(
                new Apple("red", 1.24),
                new Apple("green", 1.50),
                new Apple("black", 1.56));
        list = list.stream().filter((Apple a) -> a.getWeight() > 1.20).collect(Collectors.toList());
        list.forEach(System.out::println);
        list.sort(Comparator.comparing(Apple::getWeight));
        List<String> listStr = list.stream().map((Apple::getColor)).collect(Collectors.toList());
        listStr.forEach(s -> System.out.println(s + "....."));
    }

    //T->R
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }

    static void test4() {
        List<Apple> list = Arrays.asList(
                new Apple("red", 1.24),
                new Apple("green", 1.50),
                new Apple("black", 1.56));
        List<String> strList = map(list, (Apple apple) -> apple.getColor());
        strList.forEach(e -> System.out.println(e));
    }

    //(int,int)->int
    static void test5() {
        IntBinaryOperator intBinaryOperator = (int x, int y) -> x + y;
    }

    //T->boolean
    static void test6() {
        Predicate<Apple> predicate = (Apple apple) -> "green".equals(apple.getColor());
    }

    //T->R
    static void test7() {
        Function<Apple, String> stringFunction = (Apple apple) -> apple.getColor();
        Function<BufferedReader, String> f = (BufferedReader b) -> {
            String a = null;
            try {
                a = b.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return a;
        };
    }

    //T->void
    static void test8() {
        List<Apple> list = Arrays.asList(
                new Apple("red", 1.24),
                new Apple("green", 1.50),
                new Apple("black", 1.56));
        Consumer<Apple> consumer = (Apple apple) -> System.out.println(apple.getColor());
        Consumer<String> b = s -> System.out.println("a");
        Consumer<String> c = s -> list.add(new Apple("red", 1.24));
    }

    //(T,U)->R
    static void test9() {
        BiFunction<Apple, Apple, Integer> biFunction = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
    }

    static void test10() {
        Supplier<Apple> t = ()->new Apple();
        Supplier<Apple> c1 = Apple::new;
        Apple apple = c1.get();

        Function<Integer,Apple> t2 = (aid)-> new Apple(aid);
        Function<Integer,Apple> c2 = Apple::new;
        Apple a2 = c2.apply(1);

        BiFunction<Integer, String, Apple> c3 = Apple::new;
        Apple a3 = c3.apply(1,"green");
        BiFunction<Integer,String,Apple> c4 = (aid,color)->new Apple(aid,color);
        Apple a4 = c4.apply(1,"red");
    }

    static List<Apple> initList(){
        List<Apple> list = Arrays.asList(
                new Apple("red", 1.24),
                new Apple("green", 1.50),
                new Apple("black", 1.56));
        return list;
    }

    static void test11() {
        List<Apple> list = initList();
        list.sort(Comparator.comparing(Apple::getWeight));
    }

    static void test12(){
        List<Apple> list = initList();
        list.stream().filter(a->a.getWeight()>150 || ("green").equals(a.getColor())).collect(Collectors.toList());
    }

}