import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        var expectedResult = feline.getFood("Хищник");
        var actualResult = feline.eatMeat();
        Assert.assertEquals("Еда для кошачьих не соответствует ожидаемой", expectedResult, actualResult);
    }

    @Test
    public void getFamilyTest() {
        var expectedResult = "Кошачьи";
        var actualResult = feline.getFamily();
        Assert.assertEquals("Принадлежность к семейству не совпадает с ожидаемой", expectedResult, actualResult);
    }

    @Test
    public void getKittensTest() {
        var expectedResult = 5;
        var actualResult = feline.getKittens(5);
        Assert.assertEquals("Количество котят не совпадает с ожидаемым", expectedResult, actualResult);

    }

    @Test
    public void getKittensIsDefaultValueTest() {
        var expectedResult = 1;
        var actualResult = feline.getKittens();
        Assert.assertEquals("Количество котят не совпадает с ожидаемым",expectedResult, actualResult);
    }
}
