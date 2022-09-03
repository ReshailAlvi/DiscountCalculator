package resources;

public class Constants {

    //Remote driver endpoint
    public static String remoteDriver = "http://localhost:4445";
    //config.properties file path
    public static String configProperties = "/src/resources/config.properties";

    //path of excel file and sheet details
    public static String pathForTestData = "/src/resources/testdata.xlsx";
    public static String sheetName = "PercentOff";
    public static int numberOfColumns = 5;

    //Error messages
    public static String errorMsgPositiveDiscountValue = "Please provide a positive discount value.";
    public static String errorMsgPositivePriceBeforeDiscountValue = "Please provide a positive price before discount value";
    public static String errorMsgForMissingInputs = "Please provide 2 values to calculate.";

    //Driver variables
    public static int standardTimeOut = 20;
    public static int standardWaitTime = 10;
}
