package OnlineAssignment.bayonesolution;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class testAnnotation {

    private  Map<String,Integer> map;
    private int count = 0;

    public testAnnotation() {

        map = new HashMap<>();

        map.put("foo", 1);

        map.put("bar", 3);

    }

    public int getValue(String input, int numRetries) throws Exception {
        count++;
                    System.out.println(count);

        try {

            return map.get(input);

        }

        catch (Exception e) {

            if (numRetries > 3) {
                throw e;
            }
            return getValue(input, numRetries + 1);

        }

    }

    @Test
    public void basic_test() throws Exception {
        testAnnotation test = new testAnnotation();
//        System.out.println(test.getValue("fubar", 1));
    }
}


