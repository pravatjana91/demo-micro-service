package com.videoplayer.brightcove.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrightcoveJSONApi {

	/*
	 * @GetMapping("/getRelatedVideoData") public String
	 * getRelatedVideoData( @RequestParam String accountId,
	 * 
	 * @RequestParam String tagName,
	 * 
	 * @RequestParam String videoName,
	 * 
	 * @RequestParam String limit ) { System.out.println(" Account ID -> "+accountId
	 * ); System.out.println(" tagName  -> "+tagName );
	 * System.out.println(" videoName  -> "+videoName );
	 * System.out.println(" limit  -> "+limit );
	 * 
	 * 
	 * JSONObject relatedVideoData= getBrightcoveRelatedVideoData("1752604059001",
	 * "public", "Lions Play", "9");
	 * 
	 * System.out.print(relatedVideoData.toString()); return ""; }
	 */

	 @PostMapping("/relatedVideoData")
	  public String getRelatedVideoDatapost( @RequestBody Map<String, String> payload
			  ) {
		 
		 String accountId=payload.get("accountId"),
		  tagName=payload.get("tagName"),
		  videoName=payload.get("videoName"),
		 limit=payload.get("limit");
		 
		 System.out.println(" Account ID -> "+accountId );
		 System.out.println(" tagName  -> "+tagName );
		 System.out.println(" videoName  -> "+videoName );
		 System.out.println(" limit  -> "+limit );


		 JSONObject relatedVideoData=  getBrightcoveRelatedVideoData(accountId, tagName, videoName, limit);
	  
		 System.out.print(relatedVideoData.toString());
		 return relatedVideoData.toString();
	  }
	 
	 
//https://edge.api.brightcove.com/playback/v1/accounts/1752604059001/videos?q=tags:"public" -name:"Lions Play"&limit=9
public JSONObject getBrightcoveRelatedVideoData(String accountId,String tagName,String videoName, String limit) throws JSONException {
	String apiUrl = "https://edge.api.brightcove.com/playback/v1/accounts/{0}/videos?q={1}&limit={2}";
		
	String qParam=("tags:%22public%22%20-name:%22Lions%20Play%22");
	
	apiUrl=MessageFormat.format(apiUrl, accountId,qParam,limit);
		JSONObject eventsDataJSONObject = new JSONObject();
		try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet getRequest = new HttpGet(apiUrl);
			getRequest.addHeader("Accept", "application/json;pk=BCpkADawqM1eifBpAkEr4aJrH9i950qErQCg8FvHXBCigF0JjC-zZyhN4T1XGGGBbB0hojevaABtp54BTvT9Er0KplSpC6tqm8YgyCtIzGl5sc77i23GLWYdpLdtF7Aei45EuLqlUznlkiXU");
			HttpResponse httpResponse = httpClient.execute(getRequest);
			try(BufferedReader br = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), StandardCharsets.UTF_8))) {
				StringBuilder sb = new StringBuilder();
				String output;
				while ((output = br.readLine()) != null) {
					sb.append(output);
				}
				eventsDataJSONObject = new JSONObject(sb.toString());
			}
		} catch (IOException e) {
			//LOG.error("Unable to retrieve date from API: {} Reason: {}", apiURL,e.getMessage());
		}
		return eventsDataJSONObject;
	}

}


