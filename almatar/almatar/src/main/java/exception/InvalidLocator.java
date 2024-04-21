package exception;

        import basepage.SeleniumLocator;

        import java.io.IOException;

public class InvalidLocator extends Exception{

    public String productName;

    public InvalidLocator(SeleniumLocator locatorType, String locatorString) throws IOException {

        System.out.println("some issue with locatorType => " + locatorType +" and locator value => "+locatorString);


    }

    private static final long serialVersionUID = 1L;

}
