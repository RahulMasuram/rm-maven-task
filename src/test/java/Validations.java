import org.testng.annotations.Test;
public class Validations {

    @Test
    public void testForAddition()
    {
        addition(5,9);
    }

    @Test
    public void testForAddition1()
    {
        addition(9,9);
    }


    private void addition(int num1, int num2) {
        System.out.println("Addition of two nums is "+(num1+num2));
    }

    @Test
    public void java8()
    {
        System.out.println("java8 method is getting executed....");
        String languages = String.join("_", "Java", "HTML", "Python", "CSS", "PHP");

        System.out.println(languages);
    }

    @Test
    public void java11()
    {
        System.out.println("java11 method is getting executed....");
        System.out.println("   ".isBlank());
        System.out.println("\n\n".lines().count());
        System.out.println("1".repeat(5));
    }

    @Test
    public void java15()
    {
        System.out.println("java15 method is getting executed....");
        System.out.println("1) %s 2) %s 3) %s ".formatted("Java", "Python", "JavaScript"));
    }



}
