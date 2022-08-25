import org.junit.Assert;
import org.junit.Test;

public class OATest {
    @Test
    public void basic_test(String s) {
//        Assert.assertTrue(true);

        String res = new StringBuilder(s).reverse().toString();
    }
}
