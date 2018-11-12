import org.junit.Test;
import hw_4.util.Calc;

import static org.junit.Assert.*;

public class CalcTest {


    @Test
    public void expressionWithSpace(){
        String exp = "2+ 2";
        Double res = Calc.eval(exp);

        assertEquals(res,4d,0.0);
    }

    @Test
    public void expressionWithBrackets(){
        String exp = "2+(2-1)";
        Double res = Calc.eval(exp);

        assertEquals(res,3d,0.0);
    }

    @Test
    public void expressionWithBracketsAndSpace(){
        String exp = "2+ 2  + (2-1)";
        Double res = Calc.eval(exp);

        assertEquals(res,5,0.0);
    }

    @Test
    public void expressionWithSin(){
        String exp = "s(15*(1+1))";
        Double res = Calc.eval(exp);

        assertEquals(res,0.5,0.0);
    }

    @Test
    public void expressionWithPow(){
        String exp = "2^5";
        Double res = Calc.eval(exp);

        assertEquals(res,32,0.0);
    }
}