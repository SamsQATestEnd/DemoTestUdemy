import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {

    public ArrayList<String> getData(String testcaseName, String sheetName) throws IOException {

        //fileInputStream argument
        ArrayList<String> arrayList = new ArrayList<String>();

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\RestApiUdemyCourseTable.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheetsNumber = workbook.getNumberOfSheets();

        for (int i = 0; i < sheetsNumber; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
                XSSFSheet sheet = workbook.getSheetAt(i);

                //Identify TestCases column by scanning the entire 1st row
                Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
                Row firstRow = rows.next();
                Iterator<Cell> cells = firstRow.cellIterator();//row is collection of cells
                int k = 0;
                int column = 0;
                while (cells.hasNext()) {  //while (if next cell is present is true)
                    Cell value = cells.next();

                    if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
                        column = k;   //then this is index of our desired column
                    }
                    k++;
                }
                System.out.println("Our desired column number is: " + column);

                //once column is identified then scan entire testcase column to identify "purchase" row of "testcase" sheet
                while(rows.hasNext()) { //if next row is present in the selected column, then go inside

                    Row r = rows.next();  //take the next row (r) of the selected column

                    if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {

                        //after you grab "purchase" row of "testcase" sheet = pull all the data of that row and feed into test
                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
//                            System.out.println(cv.next().getStringCellValue());  //print all cell values from that row, while there is next cell available

                            Cell c = cv.next();

                            if (c.getCellTypeEnum() == CellType.STRING) {  //if the content of cell is a String
                                arrayList.add(c.getStringCellValue());
                            } else {
                                arrayList.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }
        return arrayList;

    }
}
