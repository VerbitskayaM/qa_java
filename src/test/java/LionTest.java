import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;

public class LionTest {

    private Lion lion;
    @Mock
    private Feline feline;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getKittensTest() throws Exception {
        when(feline.getKittens()).thenReturn(5);
        lion = new Lion("Самка", feline);
        var expectedResult = 5;
        var actualResult = lion.getKittens();
        Assert.assertEquals("Количество котят несоответствует ожидаемому", expectedResult, actualResult);
    }

    @Test
    public void getFoodTest() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы","Рыба"));
        lion = new Lion("Самец", feline);
        var expectedResult = List.of("Животные", "Птицы", "Рыба");
        var actualResult = lion.getFood();
        Assert.assertEquals("Еда для хищника не соответствует ожидаемой", expectedResult, actualResult);
    }

    @Test
    public void createLionThrowsExceptionTest() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        new Lion("null", feline);
    }
}
