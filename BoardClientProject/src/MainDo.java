import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainDo {

	public static void main(String[] args) {
		//문자열 하나 콘솔에서 입력받음  --> 검색할 이름 일부분 입력
		//HTTP로 데이터를 요청
		//1. 데이터를 요청할 API 주소를 문자열로 선언
		//2. 전달할 파라메터를 인코딩 작업
		try {
			//3. Url 완성 주소랑 파라메터(쿼리 스트링)를 조합
			String apiUrl = "http://localhost:9999";
			URL url = new URL(apiUrl);
			//4. open connection 요청
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//5. inputstream 초기화 해서 읽음
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			//6. json이면 json 파싱해서 원하는 데이터만 추출 후 출력
			String result = "";
			while(true) {
				String str = br.readLine();
				if(str == null) break;
				result += str;
			}
			System.out.println(result);
			br.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}






