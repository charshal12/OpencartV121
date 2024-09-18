package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    //DataProvide1
    @DataProvider(name="LoginData")
    public String[][] getData() throws IOException {
        String path = ".\\testData\\Opencart_LoginData.xlsx"; //taking xl file from testData
        ExcelUtility xlutil = new ExcelUtility(path); //creating an object for XLUtility

        int totalrows=xlutil.getRowCount("Sheet1");
        int totalcols=xlutil.getCellCount("Sheet1",1);

        String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store

        for(int i=1; i<=totalrows;i++) //1 //read the data from excel storing in 2D array
        {
            for (int j = 0; j < totalcols; j++) //0 //i is row j is col
            {
                logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j); //1,0
            }
        }
        return logindata;
    }
}

//DataProvide2

//DataProvide3
