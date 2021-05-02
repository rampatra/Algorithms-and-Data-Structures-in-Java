import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class ReverseIntegerTest {
    private ReverseInteger so = new ReverseInteger();
    
    @Test
    @DisplayName("Test1")
    public void case1(){
        assertEquals(123, so.reverse(321), "Not Pass");
        assertEquals(0, so.reverse(0), "Not Pass");
        assertEquals(-123, so.reverse(-321), "Not Pass");
    }   
    @Test
    @DisplayName("Test2")
    public void case2(){
     
        assertEquals(0, so.reverse(Integer.MAX_VALUE+1), "Not Pass");
        assertEquals(0, so.reverse(Integer.MIN_VALUE-1), "Not Pass");
    }  
}
