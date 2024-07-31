import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParametrizedTests {

    private final String sex;
    private final boolean hasMane;
    @Mock
    private Feline feline;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    public LionParametrizedTests(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{
                {"Самка", false},
                {"Самец", true}
        };
    }


    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals("Наличие гривы не совпадает с ожидаемым значением", hasMane, lion.doesHaveMane());
    }
}
