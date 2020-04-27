import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ExcelDrivenTest {

	//WE WILL HAVE ERROR AFTER FIRST RUN, BECAUSE WE CAN'T POST BOOK WITH THE EXISTING ID; Change ID in excel file;
	@Test
	public void addBook() throws IOException{

		DataDriven d = new DataDriven();
		ArrayList data = d.getData("RestAddBook", "RestAssuredLibraryAPI");  //in our method, we are finding "RestAddBook" row,...
																		//...and storing in list everything that exists in that same row
		
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", data.get(1));	//we don't want to the (0) cell in the row, because it is the name of the row, and we don't need it
		map.put("isbn", data.get(2));
		map.put("aisle", data.get(3));
		map.put("author", data.get(4));
		
	/*	HashMap<String, Object>  map2nested = new HashMap<>();
		map.put("lat", "121234543");
		map.put("lng", "-345464645");
		map.put("location", map2nested);*/      //if we have nested values (look in json file), than we would put HashMap in HashMap!!!!!!!
		
		
		RestAssured.baseURI="http://216.10.245.166";
		Response resp = given()
						   .header("Content-Type","application/json")
						   .body(map)
						.when()
							.post("/Library/Addbook.php")
						.then().assertThat().statusCode(200)
								.extract().response();
		 JsonPath js= ReusableMethods.rawToJson(resp);
		 String id=js.get("ID");
		 System.out.println("ID is: " + id);
		
		
	
		
		
		
	// Create a place =response (place id)
		
		// delete Place = (Request - Place id)	
		

	}
	
	public static String GenerateStringFromResource(String path) throws IOException {

	    return new String(Files.readAllBytes(Paths.get(path)));

	}
}
