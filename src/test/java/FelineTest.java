import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    @Test
    public void eatMeat() throws Exception {
        Feline testFeline = new Feline();
        List<String> responseEatMeat = testFeline.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), responseEatMeat);
    }

    @Test
    public void getFamily() {
        Feline testFeline = new Feline();
        String responseGetFamily = testFeline.getFamily();
        Assert.assertEquals("Кошачьи", responseGetFamily);
    }

    @Test
    public void getKittens() {
        Feline testFeline = new Feline();
        int responseGetKittens = testFeline.getKittens();
        Assert.assertEquals(1, responseGetKittens);
    }

    @Test
    public void getCountKittents() {
        Feline testFeline = new Feline();
        int count = 10;
        int expected = (int) (count * Math.random());
        int responseCountKittens = testFeline.getKittens(expected);
        Assert.assertEquals(expected, responseCountKittens);
    }

}
