import org.junit.Assert;
import org.junit.Test;
import ua.teamdev.drozdov.vadim.EvaluationException;
import ua.teamdev.drozdov.vadim.StateMachineCalculator;

public class CalculationTest {

    @Test
    public void testNumber(){
        final double expected = 1.0;
        final String expression = "1";
        StateMachineCalculator calculator = new StateMachineCalculator();
        try{
            Assert.assertEquals(expected, calculator.evaluate(expression), 0);
        }catch (EvaluationException e){
            Assert.fail();
        }
    }

    @Test
    public void testPlusOperator(){
        final double expected = 7.0;
        final String expression = "1+2+4";
        StateMachineCalculator calculator = new StateMachineCalculator();
        try{
            Assert.assertEquals(expected, calculator.evaluate(expression), 0);
        }catch (EvaluationException e){
            Assert.fail();
        }
    }

    @Test
    public void testMinusOperator(){
        final double expected = 14-12-1;
        final String expression = "1";
        StateMachineCalculator calculator = new StateMachineCalculator();
        try{
            Assert.assertEquals(expected, calculator.evaluate(expression), 0);
        }catch (EvaluationException e){
            Assert.fail();
        }
    }

    @Test
    public void testDivideOperator(){
        final double expected = 3;
        final String expression = "45/15";
        StateMachineCalculator calculator = new StateMachineCalculator();
        try{
            Assert.assertEquals(expected, calculator.evaluate(expression), 0);
        }catch (EvaluationException e){
            Assert.fail();
        }
    }

    @Test
    public void testMultiplyOperator(){
        final double expected = 8;
        final String expression = "2*2*2";
        StateMachineCalculator calculator = new StateMachineCalculator();
        try{
            Assert.assertEquals(expected, calculator.evaluate(expression), 0);
        }catch (EvaluationException e){
            Assert.fail();
        }
    }

    @Test
    public void testBrackets(){
        final double expected = 8;
        final String expression = "(2 + 2) * 2 ";
        StateMachineCalculator calculator = new StateMachineCalculator();
        try{
            Assert.assertEquals(expected, calculator.evaluate(expression), 0);
        }catch (EvaluationException e){
            Assert.fail();
        }
    }

    @Test
    public void testPriority(){
        final double expected = 6;
        final String expression = "2 + 2 * 2 ";
        StateMachineCalculator calculator = new StateMachineCalculator();
        try{
            Assert.assertEquals(expected, calculator.evaluate(expression), 0);
        }catch (EvaluationException e){
            Assert.fail();
        }
    }
}
