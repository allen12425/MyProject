package org.edward.test;

import org.edward.entity.Dish;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        //test6();
        //test11();
        test12();
    }

    static List<Dish> initList() {
        List<Dish> list = Arrays.asList(new Dish(1230, "面包", Dish.Type.OTHER)
                , new Dish(1800, "牛肉", Dish.Type.MEAT)
                , new Dish(2000, "花鲢", Dish.Type.MEAT));
        return list;
    }

    static void test() {
        List<Dish> list = initList();
        /**
         * 筛选出大于1500卡路里的菜肴，然后按卡路里排序，再提取菜肴的名称
         * 串行单线程
         */
        list.stream().filter(dish -> dish.getCalories() > 1500)
                .sorted(Comparator.comparing(Dish::getCalories))
                .collect(Collectors.toList());
    }

    static void test1() {
        List<Dish> list = initList();
        /**
         * 筛选出大于1500卡路里的菜肴，然后按卡路里排序，再提取菜肴的名称
         * 并行，默认线程数与cpu核数一致
         */
        list.parallelStream().filter(dish -> dish.getCalories() > 1500)
                .sorted(Comparator.comparing(Dish::getCalories))
                .collect(Collectors.toList());
    }

    static void test2() {
        List<Dish> list = initList();
        /**
         * 筛选出大于1500卡路里的菜肴，然后按卡路里排序，再提取菜肴的名称
         * 并行，默认线程数与cpu核数一致
         */
        List<String> listDishName = list.stream()
                .filter(dish -> dish.getCalories() > 1300)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
    }

    static void test3() {
        List<Integer> list = Arrays.asList(1, 1, 2, 4, 8, 5, 7, 6);
        int sum = list.stream().reduce(0, (a, b) -> a + b);
        int sum2 = list.stream().reduce(0, Integer::sum);
        int sum3 = list.stream().mapToInt(e -> e).sum();
        int count = list.stream().map(d -> 1).reduce(0, (a, b) -> a + b);
        long count2 = list.stream().count();
    }

    static void test4() {
        List<Dish> list = initList();
        Map<String, List<Dish>> map = list.stream().collect(Collectors.groupingBy(Dish::getName));
    }

    static List<Trader> initTrader() {
        List<Trader> traders = Arrays.asList(new Trader("allen", "beijing")
                , new Trader("tom", "shanghai")
                , new Trader("jack", "hangzhou")
                , new Trader("teng", "shenzhen"));
        return traders;
    }

    static List<Transaction> initTransaction() {
        List<Transaction> transactions = Arrays.asList(new Transaction(new Trader("allen", "beijing"), 2018, 1000)
                , new Transaction(new Trader("tom", "shanghai"), 2018, 2000)
                , new Transaction(new Trader("jack", "hangzhou"), 2019, 3000)
                , new Transaction(new Trader("teng", "shenzhen"), 2020, 5000));
        return transactions;
    }

    static void test5() {
        List<Transaction> transactions = initTransaction();
        //获取2018年的所有交易并按交易金额排序
        List<Transaction> tr2018 = transactions.stream().filter(transaction -> transaction.getYear() == 2018)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    static void test6() {
        List<Transaction> transactions = initTransaction();
        //交易员都在那些不同的城市工作
        List<String> cityList = transactions.stream().map(transaction -> transaction.getTrader().getCity())
                .distinct().collect(Collectors.toList());
        Set<String> set = transactions.stream().map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());

        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(e -> "beijing".equals(e.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        Optional<Integer> highestValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        Optional<Transaction> smallTransaction = transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        Optional<Transaction> smallestTransaction = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        System.out.println(smallTransaction);
    }

    /**
     * 由文件生成流
     */
    static void test7() {
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split("")))
                    .distinct()
                    .count();
        } catch (IOException e) {

        }
    }

    /**
     * 创建无限流
     */
    static void test8() {
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }

    /**
     * 按类型分组菜肴
     */
    static void test9() {
        List<Dish> list = initList();
        Map<Dish.Type, List<Dish>> map = list.stream().collect(Collectors.groupingBy(Dish::getType));

        Map<Dish.Type, Integer> typeIntegerMap = list.stream().collect(Collectors.groupingBy(Dish::getType
                , Collectors.summingInt(Dish::getCalories)));
    }

    static void test10() {
        List<Dish> list = initList();
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
                list.stream().collect(
                        Collectors.partitioningBy(Dish::isVegetarian,
                                Collectors.groupingBy(Dish::getType)));

    }

    static void test11() {
        long sum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
        System.out.println(sum);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> max =list.stream().max(Integer::compareTo);
        Optional<Integer> max1 = list.stream().max((a, b) -> a - b);
        System.out.println(list.stream().min((a, b) -> a - b).get());
        System.out.println(max.get());
        Optional<Integer> findAny = list.stream().filter(x->x%2==0).findAny();
        System.out.println(findAny.get()+"-----------");

        List<Integer> lista = list.stream().filter(x->x%2==0).collect(Collectors.toList());
        System.out.println(lista+"--");
        Optional<Integer> first = list.stream().filter(x->x%2==0).findFirst();
        System.out.println(first.get());
        Stream<Integer> generate = Stream.generate(()->1);
        generate.limit(10).forEach(System.out::println);

        Stream<Integer> iterate = Stream.iterate(1, i -> i + 1);
        iterate.limit(10).forEach(System.out::println);

        String str = "abcdefg";
        IntStream stream = str.chars();
        stream.forEach(System.out::println);
    }

    static void test12(){
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 6);
      Stream<Integer> stream = list.stream().filter(x->{
            System.out.println("运行代码");
            return x%2==0;
        });
        System.out.println(stream.findAny().get());

        Optional<Integer> first = list.stream().sorted().findFirst();
        Optional<Integer> max = list.stream().sorted((x,y)->y-x).findFirst();
        System.out.println(first.get());
        System.out.println(max.get());


        Arrays.asList("java","c#","python","php").stream().sorted().forEach(System.out::println);
        Arrays.asList("java", "c#", "python", "php").stream().sorted((a, b) -> a.length() - b.length())
                .forEach(System.out::println);

        List<Integer> collection = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        collection.forEach(System.out::println);

        Arrays.asList(1,2,3,5,1,1,3,5,3,5,3,2,6,7,8,3).stream().distinct().forEach(System.out::println);
        Arrays.asList(1, 2, 3, 5, 1, 1, 3, 5, 3, 5, 3, 2, 6, 7, 8, 3).stream().collect(Collectors.toSet()).forEach(System.out::println);
        //打印20-30这样的集合数据
        Stream.iterate(1, x -> x + 1).limit(50).skip(20).limit(10).forEach(System.out::println);
        String str = "11,22,33,44";
        System.out.println(Stream.of(str.split(",")).mapToInt(x->Integer.valueOf(x)).sum());
        System.out.println(Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum());
        System.out.println(Stream.of(str.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum());
        System.out.println(Stream.of(str.split(",")).map(Integer::valueOf).mapToInt(x -> x).sum());

        //创建一组自定义对象
        String str2 = "java,c#,python,php";
        Stream.of(str2.split(",")).map(x->new Person(x)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::new).forEach(System.out::println);
        Stream.of(str2.split(",")).map(x->Person.build(x)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::build).forEach(System.out::println);

        //将str的每一个数值都打印出来，同时算出最终的求和结果
        System.out.println(Stream.of(str.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum());

        System.out.println(list.stream().allMatch(x->x%2==0));
        System.out.println(list.stream().allMatch(x->x>=0));

    }



}
