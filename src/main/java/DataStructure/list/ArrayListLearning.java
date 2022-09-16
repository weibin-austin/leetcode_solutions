package DataStructure.list;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ArrayListLearning {
    public static void main(String[] args) {
        // List<Integer> list = new ArrayList<>();
        // ArrayList<Integer> list = new ArrayList<>();

        ArrayList<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("Pratap", "Peter", "Harsh"));

        System.out.println("Elements are:"+integerList);
        System.out.println("Elements are:"+stringList);
        // 对于List的地址输出可以直接输出List中的每个元素

        // 对于array的地址输输出的是array在heap中的地址
        // Arrays.toString(a), Arrays类的静态方法 Arrays.toString(a) 可以输出array中的每一个元素
        int[] a = new int[]{1, 2, 3};
        System.out.println(a);                  // [I@5caf905d
        System.out.println(a.toString());       // [I@5caf905d
        System.out.println(Arrays.toString(a)); // [1, 2, 3]: Returns a string representation of the contents of the specified array.



        /*    Initialize an ArrayList
                1. Arrays.asList() method
         */
        ArrayList<Integer> integerList1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<String> stringList1 = new ArrayList<>(Arrays.asList("Pratap", "Peter", "Harsh"));

        System.out.println("Elements are:"+integerList1);
        System.out.println("Elements are:"+stringList1);


        /*    Initialize an ArrayList
                2. Anonymous inner class method to initialize an ArrayList：

                ArrayList<T> obj = new ArrayList<T>(){{
		                                                add(Object o1);
		                                                add(Object o2);
                                                        add(Object o3);
                                                                ...   }};

         */

        ArrayList<String> cities =
                new ArrayList<String>(){{
                    add("Delhi");
                    add("Agra");
                    add("Chennai");
                    add("Pune");
                    add("Noida");
        }};
        System.out.println("Content of Array list cities:"+cities);



         /*    Initialize an ArrayList         
                 3. Normal way of ArrayList initialization
                  Initializing an ArrayList with multiple same elements using Collections.ncopies()
          */
        ArrayList<String> books = new ArrayList<String>();
        books.add("Java Book1");
        books.add("Java Book2");
        books.add("Java Book3");
        System.out.println("Books stored in array list are: "+books);




        /*    Initialize an ArrayList
                 4. Initializing an ArrayList with multiple same elements using Collections.ncopies()
                 Collections.ncopies() method is used, when we need to initialize the ArrayList with multiple same elements.
          */

        ArrayList<Integer> intlist = new ArrayList<Integer>(Collections.nCopies(10, 5)); // multiple same elements.
        intlist.add(0,1000);
        System.out.println("ArrayList items: "+intlist); //  [5, 5, 5, 5, 5, 5, 5, 5, 5, 5]

        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.add(3);
        list.add(2);
        list.add(4);
        Collections.reverse(list);
//        list.set(1, 2);
//        list.set(0, 100);
        System.out.println(list);


    }

    @Test
    public void basic_test() {
        ArrayList<Integer> intlist = new ArrayList<Integer>(Collections.nCopies(10, 5)); // multiple same elements.
        intlist.add(0,1000);
        System.out.println("ArrayList items: "+intlist); //  [5, 5, 5, 5, 5, 5, 5, 5, 5, 5]
    }
}
