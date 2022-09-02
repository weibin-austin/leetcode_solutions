package DataStructure.java8;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * create stream
 *      使用List创建流
 *      list.stream();
 *
 *      使用数组创建流
 *      Arrays.stream(T[] array)
 *
 *      使用一个或多个元素创建流
 *      Stream.of(T value)
 *      Stream.of(T... values)
 *
 * 流的中间操作   intermediate operation
 *      元素过滤
 *     1. filter(Predicate)       Predicate 返回 Boolean, obj
 *     2. limit()
 *     3. skip()
 *     4. distinct()
 *
 *      映射
 *     5. map()
 *     6. flatmap()
 *
 *      排序
 *     7. sorted()                                  不是sort()
 *        sorted(Comparator.reverseOrder())
 *
 *      查看
 *     8. peek(System.Out::println)
 *
 * 终止操作: terminal operation
 *     1. count()
 *     2. void forEach(Consumer<? super T> action); -> 对stream的每个element都执行相同的操作
 *     3. Object[] toArray();                                                                   collect(Collectors.toMap(Employee::getId, Employee::getName));
 *     4. Optional<T> reduce(BinaryOperator<T> accumulator);  + orElse();                       collect(Collectors.joining(", "))
 *     5. collect(Collectors.toList()) ------------------------------------------------------>  collect(Collectors.toSet());
 *     6. List<T> toList()                                                                      collect(Collectors.toCollection(Vector::new));
 *     7. Optional<T> max(Comparator<? super T> comparator);  + orElse();                       collect(Collectors.toList());
 *     8. Optional<T> min(Comparator<? super T> comparator);  + orElse();                       Map<String, List<Person>> peopleByCity = personStream.collect(Collectors.groupingBy(Person::getCity));
 *     9. Optional<T> findFirst();  + orElse();
 *     10.Optional<T> findAny();    + orElse();
 *
 *     https://www.helloworld.net/p/1568884076
 */
public class StreamApiLearning {
    public List<Integer> integerListOne;
    public List<Integer> integerListTwo;
    public List<String> stringList;
    @BeforeEach
    public void setup() {
        this.integerListOne = new ArrayList<Integer>(){{
            add(1); add(9); add(5); add(4); add(7); add(2); add(6); add(1); add(4);
        }};  //[1, 9, 5, 4, 7, 2, 6, 1, 4]

        this.integerListTwo = new ArrayList<Integer>(){{
            add(2); add(7); add(11); add(4); add(3); add(12); add(6); add(5); add(0);
        }};  //[2, 7, 11, 4, 3, 12, 6, 5, 0]

        this.stringList = new ArrayList<String>(){{
            add("student"); add("teacher"); add("class"); add("apple"); add("pencil"); add("football"); add("zoo");
        }}; // [student, teacher, class, apple, pencil, football, zoo]
    }
    // how to delete an element in a list by using for loop? stream api?  thread-safe? without using collect(Collection.asList)

    @Test
    public void integerList_test() {
        //  Terminal operation: max(), min()
        //   1. stream().max() 和 stream().min()，两个方法中都要有Comparator
        //     .max(Comparator.comparingInt(a -> a)) 升序中的最大值
        //     .min(Comparator.comparingInt(a -> a)) 升序中的最小值

        //   2. stream().max() 和 stream().min() 输出值为 Optional<Integer> 所以需要.orElse(value)来处理null的值
        //     .max(Comparator.comparingInt(a -> a)).orElse(Integer.MIN_VALUE);

        int max = integerListOne.stream()
                .max(Comparator.comparingInt(a -> a))
                .orElse(Integer.MIN_VALUE);

        int min = integerListOne.stream()
                .min(Comparator.comparingInt(a -> a))
                .orElse(Integer.MAX_VALUE); // orElse()方法是来自Optional class.   max() or main() is terminate operation

        System.out.println("max value: " + max + " , min value: " + min);

        // Intermediate operation:  filter(Predicate)
        List<Integer> integerList1 = integerListOne.stream()
                .filter(a -> a > 5)
                .peek(a -> System.out.print(a + ","))
                .collect(Collectors.toList()); // [9,7,6]
        System.out.println();

        // Intermediate operation:  limit(n): return the first n elements
        List<Integer> integerList2 = integerListOne.stream()
                .limit(3)
                .peek(a -> System.out.print(a + ","))
                .collect(Collectors.toList()); // [1,9,5]
        System.out.println();

        // Intermediate operation:  skip(n):  跳过n个元素，输出剩下的元素
        List<Integer> integerList3 = integerListOne.stream()
                .skip(3)
                .peek(a -> System.out.print(a + ","))
                .collect(Collectors.toList()); // [4,7,2,6,1,4]
        System.out.println();

        // Intermediate operation:  distinct():  去重
        Set<Integer> integerSet4 = integerListOne.stream()
                .distinct()
                .peek(a -> System.out.print(a + ","))
                .collect(Collectors.toSet()); // [1, 9, 5, 4, 7, 2, 6]
        System.out.println();

        // Intermediate operation:  map(n -> n + 1)
        List<Integer> integerList5 = integerListOne.stream()
                .map(a-> a + 1)
                .peek(a -> System.out.print(a + ","))
                .collect(Collectors.toList()); //[2, 10, 6, 5, 8, 3, 7, 2, 5]
        System.out.println();

        // Intermediate operation:  flatMap(list -> list.stream()) 把两个list都展开成stream。
        // 基本flatMap()方法内都会有构造 sub-stream 的操作。 一般是对多维的stream操作。
        List<List<Integer>> listList = Arrays.asList(integerListOne, integerListTwo);
        List<Integer> integerList6 = listList.stream()
                .flatMap(list -> list.stream())
                .sorted()
                .peek(a -> System.out.print(a + ","))
                .collect(Collectors.toList()); // [0,1,1,2,2,3,4,4,4,5,5,6,6,7,7,9,11,12]
        System.out.println();


    }

    @Test
    public void basic_test() {
                                                                                                                        System.out.println("1. filter(str -> str.length() > 6) : ");
                                                                                                                        System.out.print("       ");
        // 1. filter(str -> str.length() > 6)
        List<String> stringList1 = stringList.stream()
                .filter(str -> str.length() > 6)
                .peek(str -> System.out.print(str + ", "))
                .collect(Collectors.toList());
                                                                                                                        System.out.println();
                                                                                                                        System.out.println("2. map(str -> str.substring(0,3)) : ");
                                                                                                                        System.out.print("       ");
        // 2. map(str -> str.substring(0,3))
        List<String> stringList2 = stringList.stream()
                .map(str -> str.substring(0,3))
                .peek(str -> System.out.print(str + ", "))
                .collect(Collectors.toList());

                                                                                                                        System.out.println();
                                                                                                                        System.out.println("3. sorted(), Ascending order : ");
                                                                                                                        System.out.print("       ");
        // 3.1 sorted(), Ascending order
        List<String> stringList3 = stringList.stream()
                .sorted()
                .peek(str -> System.out.print(str + ", "))
                .collect(Collectors.toList());
                                                                                                                        System.out.println();
                                                                                                                        System.out.println("3. sorted(Collections.reverseOrder()), Descending order : ");
                                                                                                                        System.out.print("       ");
        // 3.2 sorted(Collections.reverseOrder()), Descending order
        List<String> stringList4 = stringList.stream()
                .sorted(Collections.reverseOrder())
                .peek(str -> System.out.print(str + ", "))
                .collect(Collectors.toList());
                                                                                                                        System.out.println();

    }
}
