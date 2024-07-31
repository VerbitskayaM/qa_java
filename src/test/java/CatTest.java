import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;

    @Mock
    private Feline feline;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundTest() {
        String expectedResult = "Мяу";
        String actualResult = cat.getSound();
        Assert.assertEquals("Звук не совпадает с ожидаемым", expectedResult, actualResult);
    }

    @Test
    public void getFoodTest() throws Exception {
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }
}
