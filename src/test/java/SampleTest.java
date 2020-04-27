import java.io.IOException;
import java.util.ArrayList;

public class SampleTest {

    public static void main(String[] args) throws IOException {

        DataDriven dataDriven = new DataDriven();

        ArrayList data = dataDriven.getData("Add Profile", "testdata");  //in our method, we are finding "Add Profile" row,...
                                                                            //...and storing in list everything that exists in that same row
        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));

        //possible use:
//        driver.findElement(by.xpath("sadsa")).sendKeys(data.get(1));



    }


}
