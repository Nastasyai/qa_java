import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;


@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final List food;
    private final String type;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Spy
    Feline feline;

    public LionTest(String sex, List food, boolean mane, String type) {
        this.sex = sex;
        this.food = food;
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][] {
                {"Самец", List.of("Животные", "Птицы", "Рыба"), true, "Хищник"},
                {"Самка", List.of("Животные", "Птицы", "Рыба"), true, "Хищник"},
                {"Самец", List.of("Животные", "Птицы", "Рыба"), false, "Хищник"},
                {"Самка", List.of("Животные", "Птицы", "Рыба"), false, "Хищник"},
        };
    }

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion (feline, sex);
        lion.getKittens();
        int actual = 1;
        Assert.assertEquals("Используйте допустимые значения", actual, lion.getKittens());
    }

    @Test
    public void doesHaveMane () {
        try {
            Lion lion = new Lion(feline, sex);
            lion.doesHaveMane();
        }
        catch (Exception mess) {
            Assert.assertEquals("Используйте допустимые значения", mess.getMessage());
        }
    }

    @Test
    public void getFood() throws Exception {
    Lion lion = new Lion(feline, sex);
        Mockito.when(feline.getFood(type)).thenReturn(food);
        Assert.assertEquals("Несоответствующая пища", food, lion.getFood());
    }
}
