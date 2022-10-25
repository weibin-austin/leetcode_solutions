package OnlineAssignment.unknown;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LombokTest {

    private String name;

    private int age;

    private boolean married;
}

class TestXXX {
    public static void main(String[] args) {
        LombokTest lombokTest = new LombokTest("austin", 26, false);
        System.out.println(lombokTest.isMarried());
    }
}