package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

public class NaverBookSearch {
	public JSONObject searchBook(String book, String start, String display) {
		JSONObject obj = new JSONObject();
		//기존 검색하던 내용을 연동
		String clientId = "PWbtPqmChTr4FWM7DX8G";
		String clientSecret = "vGqvzkyqxq";

		try {
			book = URLEncoder.encode(book, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String apiURL = "https://openapi.naver.com/v1/search/book?query=" + book + "&sort=date&start="+start;
		URL url;
		try {
			url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			BufferedReader br;
			int responseCode = con.getResponseCode();
			obj.put("responseCode", responseCode);
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				System.out.println(responseCode);
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			//정상, 에러든 json 데이터를 받는 부분
			String result = "";
			while(true) {
				String str = br.readLine();
				if(str==null)break;
				result += str;
			}
			System.out.println(result);
			JSONObject r = new JSONObject(result);
			if (responseCode == 200) { // 정상 호출
				obj.put("items", r.getJSONArray("items"));
			} else { // 에러 발생
				obj.put("errorCode",r.getString("errorCode"));
				obj.put("errorMessage",r.getString("errorMessage"));
			}
			
			br.close();
			con.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
}
