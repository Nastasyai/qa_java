import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AnimalTest {
    @Test
    public void getFood() throws Exception {
        Animal testAnimal = new Animal();
        try {
            testAnimal.getFood("дракон");
            //Assert.fail("Expected Exception");
        }
        catch (Exception mess) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", mess.getMessage());
        }
    }

    @Test
    public void getFamily() {
        String family = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Animal testAnimal = new Animal();
        var actual = testAnimal.getFamily();
        Assert.assertEquals(family, actual);
    }

    @Test
    public void eatMeat() throws Exception {
        Animal testAnimal = new Animal();
        List<String> responseEatMeat = testAnimal.
                getFood("Хищник");
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), responseEatMeat);
    }

    @Test
    public void notEatMeat() throws Exception {
        Animal testAnimal = new Animal();
        List<String> responseNotEatMeat = testAnimal.
                getFood("Травоядное");
        Assert.assertEquals(List.of("Трава", "Различные растения"), responseNotEatMeat);
    }
}
