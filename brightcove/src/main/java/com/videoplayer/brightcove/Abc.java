package com.videoplayer.brightcove;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Abc {
	public static void createPackage(String[] args) throws IOException {
		URL url = new URL("http://localhost:4502/crx/packmgr/service/.json/etc/packages/mycontent.zip?cmd=create");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("POST");

		httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		byte[] message = ("admin:admin").getBytes("UTF-8");
		String basicAuth = Base64.getEncoder().encodeToString(message);
		httpConn.setRequestProperty("Authorization", "Basic " + basicAuth);

		httpConn.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
		writer.write("packageName=testpackage&groupName=my_packages");
		writer.flush();
		writer.close();
		httpConn.getOutputStream().close();

		InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
		Scanner s = new Scanner(responseStream).useDelimiter("\\A");
		String response = s.hasNext() ? s.next() : "";
		System.out.println(response);
	}
	
	public static void addingFilters(String[] args) throws IOException {
		URL url = new URL("http://localhost:4502/crx/packmgr/update.jsp");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("POST");

		byte[] message = ("admin:admin").getBytes("UTF-8");
		String basicAuth = Base64.getEncoder().encodeToString(message);
		httpConn.setRequestProperty("Authorization", "Basic " + basicAuth);

		httpConn.setDoOutput(true);
		
		Map<String,String> params = new LinkedHashMap<>();
		
		  params.put("path", "/etc/packages/my_packages/testpackage.zip");
	      params.put("packageName", "testpackage");
	      params.put("groupName", "my_packages");
	      params.put("filter", "[{\"root\" : \"/content/tdcom/ca/en/investing/qa-testing/jcr:content\", \"rules\": []},{\"root\" : \"/content/tdcom/ca/en/investing/pravat/jcr:content\", \"rules\": []},{\"root\" : \"/content/tdcom/ca/en/investing\", \"rules\": []}]");
	      params.put("_charset_", "UTF-8");

        StringBuilder postData = new StringBuilder();
        for (String param : params.keySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param, "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(params.get(param)), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        httpConn.getOutputStream().write(postDataBytes);
        
		httpConn.getOutputStream().close();

		
		InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
		Scanner s = new Scanner(responseStream).useDelimiter("\\A");
		String response = s.hasNext() ? s.next() : "";
		System.out.println(response);
	}
	
	public static void buildPackage(String[] args) throws IOException {
		URL url = new URL("http://localhost:4502/crx/packmgr/service/.json/etc/packages/my_packages/testpackage.zip?cmd=build");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("POST");

		byte[] message = ("admin:admin").getBytes("UTF-8");
		String basicAuth = Base64.getEncoder().encodeToString(message);
		httpConn.setRequestProperty("Authorization", "Basic " + basicAuth);

		InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
		Scanner s = new Scanner(responseStream).useDelimiter("\\A");
		String response = s.hasNext() ? s.next() : "";
		System.out.println(response);
	}
	
	public static void downloadPackage(String[] args) throws IOException {
		URL url = new URL("http://localhost:4502/etc/packages/my_packages/testpackage.zip");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");

		byte[] message = ("admin:admin").getBytes("UTF-8");
		String basicAuth = Base64.getEncoder().encodeToString(message);
		httpConn.setRequestProperty("Authorization", "Basic " + basicAuth);

		InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
		Scanner s = new Scanner(responseStream).useDelimiter("\\A");
		String response = s.hasNext() ? s.next() : "";
		System.out.println(response);
	}
	
	
	public static void uploadPackage(String[] args) throws IOException {
		URL url = new URL("http://localhost:4502/crx/packmgr/service/.json");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("POST");

		byte[] message = ("admin:admin").getBytes("UTF-8");
		String basicAuth = Base64.getEncoder().encodeToString(message);
		httpConn.setRequestProperty("Authorization", "Basic " + basicAuth);

		InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
		Scanner s = new Scanner(responseStream).useDelimiter("\\A");
		String response = s.hasNext() ? s.next() : "";
		System.out.println(response);
	}
	
	public static void installPackage(String[] args) throws IOException {
		URL url = new URL("http://localhost:4502/crx/packmgr/service/.json/etc/packages/my_packages/testpackage.zip");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("POST");

		byte[] message = ("admin:admin").getBytes("UTF-8");
		String basicAuth = Base64.getEncoder().encodeToString(message);
		httpConn.setRequestProperty("Authorization", "Basic " + basicAuth);

		InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
		Scanner s = new Scanner(responseStream).useDelimiter("\\A");
		String response = s.hasNext() ? s.next() : "";
		System.out.println(response);
	}
}
