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

        System.out.println("Added or Git");
        System.out.println("Added or Git");
        System.out.println("Added or Git");

        //newly added
        System.out.println("This is from original project - Gitstuff");
        System.out.println("This is from original project - Gitstuff");
        System.out.println("This is from original project - Gitstuff");


        //newly added after adding "develop" branch
        System.out.println("This is after branching");
        System.out.println("This is after branching");
        System.out.println("This is after branching");


        //possible use:
//        driver.findElement(by.xpath("sadsa")).sendKeys(data.get(1));



    }


}
