package files;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;

public class GraphQLScript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String response=given().log().all().header("ContentType","application/json")
		.body("{\"query\":\"mutation\\n{\\n  createLocation(location : {name: \\\"US\\\", type: \\\"Country\\\", dimension: \\\"abc\\\"} )\\n  {\\n    id\\n  }\\n  createCharacter(character:{name:\\\"Roy\\\",type:\\\"baseball player\\\",status:\\\"alive\\\",species:\\\"human\\\",gender:\\\"male\\\",image:\\\"NA\\\",originId:12,locationId:12})\\n  {\\n    id\\n  }\\n  createEpisode(episode:{name:\\\"The first one\\\",air_date:\\\"6 Feb 2023\\\",episode:\\\"1\\\"})\\n  {\\n    id\\n  }\\n}\",\"variables\":null}")
		.when().post("https://rahulshettyacademy.com/gq/graphql")
		.then().log().all().extract().response().asString();
		System.out.println(response);
		JsonPath js= new JsonPath(response);
		String episodeId= js.getString("data.createEpisode.id");
		System.out.println(episodeId);
		
		
	}

}
