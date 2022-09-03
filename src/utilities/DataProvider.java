package utilities;

import resources.Constants;

import java.lang.reflect.Method;
import java.util.Arrays;

public class DataProvider {

    public static String[][] testData;

    @org.testng.annotations.DataProvider(name = "TestData")
    public static Object[][] createDataObject(Method m) throws Exception {
        testData = ExcelUtil.getExcelDataIn2DArray(System.getProperty("user.dir") + Constants.pathForTestData,Constants.sheetName);

        int rows = testData.length;
        int col = Constants.numberOfColumns;
        Object[][] data_for_calculation = new Object[rows][col];

        for(int i=0;i<rows;i++)
        {
            if(m.getName().equalsIgnoreCase(testData[i][0])) {
                for (int j =0; j < col ; j++) {
                    data_for_calculation[i][j] = testData[i][j];
                }
            }
        }
        return filterData(data_for_calculation);
    }

    public static Object[][] filterData(Object[][] arr){
        String[][] nonEmptyArray = Arrays.stream(arr)
                .map(row -> Arrays.stream(row)
                        .filter(e -> e != null)
                        .toArray(String[]::new))
                .filter(row -> row.length > 0)
                .toArray(String[][]::new);
        return nonEmptyArray;
    }
}
