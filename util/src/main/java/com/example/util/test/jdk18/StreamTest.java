package com.example.util.test.jdk18;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yuanjie
 * @date 2018/12/20 14:21
 */
public class StreamTest {

    public static void main(String[] args) {
        List<User> list = arrayListTest();
        testForEach(list);
        System.out.println("------------------");
        testSort(list);
        System.out.println("-----------");
//        testFilter(list);
//        System.out.println("-------------");
//        testNum(list);
//        testMap(list);
        testFlatMap(list);
    }

    /**
     * findFirst 使用该方法获取第一个元素
     * @param list
     */
    public static void testFindFirst(List<User> list) {
        User user = list.stream().findFirst().get();
    }

    /**
     * flatMap 对每个元素执行mapper指定的操作，并用所有mapper返回的Stream中的元素组成一个新的Stream作为最终返回结果
     * 通俗易懂就是将原来的stream中的所有元素都展开组成一个新的stream
     * @param list
     */
    public static void testFlatMap(List<User> list) {
        // 创建一个装有两个泛型为integer的集合
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5));
        // 将两个合为一
        Stream<Integer> integerStream = listStream.flatMap(integers -> integers.stream());
        // 为新的集合
        List<Integer> collect = integerStream.collect(Collectors.toList());
        System.out.println("新的stream的大小： " + collect.size());
        collect.forEach(o -> System.out.println(o));
    }

    /**
     * map映射 接收一个方法作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     * @param list
     */
    public static void testMap(List<User> list) {
        List<Integer> ages = list.stream().map(user -> user.getAge()).collect(Collectors.toList());
        ages.forEach(age -> System.out.println(age));

        // 小写转大写
        List<String> words = Arrays.asList("aaa", "vvvv", "cccc");
        List<String> collect = words.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        collect.forEach(s -> System.out.println(s));
    }

    /**
     * 测试计算 max,min,sum,avg,count
     * @param list
     */
    public static void testNum(List<User> list) {
        IntSummaryStatistics num = list.stream().mapToInt(u -> u.getAge()).summaryStatistics();
        System.out.println("总共人数： " + num.getCount());
        System.out.println("平均年龄： " + num.getAverage());
        System.out.println("最大年龄： " + num.getMax());
        System.out.println("最小年龄： " + num.getMin());
        System.out.println("年龄之和： " + num.getSum());

    }

    /**
     * distinct 使用该方法去重
     * @param list
     */
    public static void testDistinct(List<User> list) {
        list.stream().distinct().forEach(user -> System.out.println(user));
    }

    /**
     * skip与limit互斥，使用该方法跳过元素
     * @param list
     */
    public static void testSkip(List<User> list) {
        list.stream().skip(3).forEach(user -> System.out.println(user));
    }

    /**
     * limit截断
     * @param list
     */
    public static void testLimit(List<User> list) {
        list.stream().limit(3).forEach(user -> System.out.println(user));
    }


    /**
     * filter过滤
     * @param list
     */
    public static void testFilter(List<User> list) {
        list.stream().filter(user -> user.getAge()>50).forEach(user -> System.out.println(user));
    }

    /**
     * sort排序
     * @param list
     */
    public static void testSort(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        Collections.sort(list, Comparator.comparing(User::getAge));
        list.stream().sorted(Comparator.comparing(User::getAge)).forEach(user -> System.out.println(user));

    }

    public static void testForEach(List<User> list) {
        list.forEach(user -> System.out.println(user));
    }

    private static List<User> arrayListTest() {
        List<User> list = Arrays.asList(
                new User("张三", 11),
                new User("王五", 20),
                new User("王五", 91),
                new User("张三", 8),
                new User("李四", 44),
                new User("李四", 44),
                new User("李四", 44)
        );
        return list;
    }

    public void getStram() {
        // 数组
        String[] arr = new String[]{"ab", "cd", "ef"};
        Stream<String> arrStream = Arrays.stream(arr);

        // 集合
        List<String> list = Arrays.asList("ab", "cd", "ef");
        Stream<String> colStream = list.stream();

        Stream<String> stream = Stream.of("ab", "cd", "ef");
    }

}
