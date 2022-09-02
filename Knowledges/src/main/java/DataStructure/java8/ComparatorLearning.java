package DataStructure.java8;

import DataStructure.java8.entity.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *  Comparator 一般是针对reference data type 的比较
 *  1. (a, b) -> a[0] - b[0]
 *  2. (a, b) -> Integer.compare(a[0], b[0])
 *  3. Comparator.comparingInt(o -> o[0])
 */
public class ComparatorLearning {
    //Comparator1
    public static Comparator<Student> comp1 = (o1, o2) -> {
        if(o1.id == o2.id) {
            return o2.name.charAt(0) - o1.name.charAt(0);
        } else {
            return o1.id - o2.id;
        }
    };

    public static Comparator<Student> comp2 = new Comparator<Student>(){
        @Override
        public int compare(Student s1, Student s2) {
            return s2.id * s2.name.charAt(0) - s1.id * s1.name.charAt(0);
        }
    };


    public static void main(String[] args) {
        Student s1 = new Student(1, "a");
        Student s2 = new Student(2, "b");
        Student s3 = new Student(1, "c");
        Student s4 = new Student(2, "d");
        Student s5 = new Student(1, "e");
        Student s6 = new Student(2, "f");
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s6);
        list.add(s4);
        list.add(s2);
        list.add(s3);
        list.add(s5);

        // Comparator1
        list.sort(comp1);
        list.forEach(System.out::print);
        System.out.println();

        // Comparator2
        list.sort(comp2);
        list.forEach(System.out::print);
        System.out.println();

        // Comparator3
        list.sort((o1, o2) -> {
            if (o1.id == o2.id) {
                return o1.name.charAt(0) - o2.name.charAt(0);
            } else {
                return o1.id - o2.id;
            }
        });
        list.forEach(System.out::print);
        System.out.println();

        /*
          Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
          Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
         */

    }
}

