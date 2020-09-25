import org.testng.Assert;


public class Test {
	public boolean test(){
		String a="Test";
		return a.equals("Test");
		
	}
public static void main(String[]args){
	Test a=new Test();
	Assert.assertTrue(a.test());
}
}
