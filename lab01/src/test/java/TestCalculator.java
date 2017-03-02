import java.util.Arrays;
import ap.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class TestCalculator {

	public final static int MIN_LENGTH = 2;
	public final static int MAX_LENGTH = 5;
	
	@Test
	public void TestNameLength(){
		Calculator calc = new Calculator("cena");
	}

	@Test(expectedExceptions=IllegalArgumentException.class)
	public void TestNameLengthMin(){
		Calculator calc = new Calculator("c");
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void TestNameLengthMax(){
		Calculator calc = new Calculator("cenass");
	}
	
	
	
	@DataProvider(name="invalidNameLengths")
	public static Object[][] invalidNameLengths() {
		return new Object[][] {{MIN_LENGTH - 1}, {MAX_LENGTH + 1}};
	}
	
	@Test(dataProvider = "invalidNameLengths", expectedExceptions=IllegalArgumentException.class)
	public void testInvalidNames(int length){
		// creates String with [length] chars
		char arr[] = new char[length];
		Arrays.fill(arr,'c');
		String s = new String(arr);
		
		Calculator c = new Calculator(s);
	}
	
	@DataProvider(name="validNameLengths")
	public static Object[][] validNameLengths() {
		return new Object[][] {
			{MIN_LENGTH}, {MIN_LENGTH + 1 }, 
			{MAX_LENGTH}, {MAX_LENGTH - 1}};
	}
	
	@Test(dataProvider = "validNameLengths")
	public void testValidNames(int length){
		// creates String with [length] chars
		char arr[] = new char[length];
		Arrays.fill(arr,'c');
		String s = new String(arr);
		
		Calculator c = new Calculator(s);
	}
	
	@Test
	public void testNullSum(){
		Calculator c = new Calculator("abc");
		Assert.assertEquals(7, c.sum(7, null), 0.0, "");
		Assert.assertEquals(7, c.sum(null, 7), 0.0, "");
		Assert.assertEquals(0, c.sum(null, null), 0.0, "");
	}
	
	@Test
	public void simpleSums(){
		Calculator c = new Calculator("abc");
		Assert.assertEquals(3, c.sum(1,2), 0.0, "");
		Assert.assertEquals(3, c.sum(2,1), 0.0, "");
		
		Assert.assertEquals(0, c.sum(0,0), 0.0, "");
		
		Assert.assertEquals(-1, c.sum(1,-2), 0.0, "");
		Assert.assertEquals(-1, c.sum(-2,1), 0.0, "");
	}
	
	@Test
	public void simpleDivisons(){
		Calculator c = new Calculator("abc");
		Assert.assertEquals(2, c.divide(4,2), 0.0, "");
		Assert.assertEquals(0, c.divide(0,2), 0.0, "");
		Assert.assertEquals(-2, c.divide(4,-2), 0.0, "");
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void divisionsByZero(){
		Calculator c = new Calculator("abc");
		c.divide(2,0);
	}
	
	@Test
	public void testNullDivision(){
		Calculator c = new Calculator("abc");
		Assert.assertEquals(0, c.divide(null, 7), 0.0, "");
	}
	
	@Test
	public void testName(){
		String name = "abc";
		Calculator c = new Calculator(name);
		
		Assert.assertEquals(name, c.getName(), "");
	}
}
