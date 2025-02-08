import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

public class ReverseIntegerTest {
    private ReverseInteger num;
    
    @BeforeEach                                         
    public void setUp() throws Exception {
        num = new ReverseInteger();
    }

    @Test
    @DisplayName("Test1")
    public void case1(){
        assertEquals(123, num.reverse(321), "Not Pass");
        assertEquals(0, num.reverse(0), "Not Pass");
        assertEquals(-123, num.reverse(-321), "Not Pass");
    }   
    @Test
    @DisplayName("Test2")
    public void case2(){
     
        assertEquals(0, num.reverse(Integer.MAX_VALUE+1), "Not Pass");
        assertEquals(0, num.reverse(Integer.MIN_VALUE-1), "Not Pass");
    }  
}
