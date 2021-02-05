package papago;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.json.JSONObject;

public class PaPaGoMain {

	public static void main(String[] args) {
		 String clientId = "PWbtPqmChTr4FWM7DX8G";//애플리케이션 클라이언트 아이디값";
	        String clientSecret = "vGqvzkyqxq";//애플리케이션 클라이언트 시크릿값";
	        try {
	        	String str = JOptionPane.showInputDialog("번역할 문장 입력");
	            String text = URLEncoder.encode(str, "UTF-8");
	            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("POST");
	            con.setRequestProperty("X-Naver-Client-Id", clientId);
	            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	            // post request
	            String postParams = "source=ko&text=" + text;
	            con.setDoOutput(true);
	            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	            wr.writeBytes(postParams);
	            wr.flush();
	            wr.close();
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 에러 발생
	            	System.out.println(responseCode);
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            System.out.println(response.toString());
	            
	            if(responseCode != 200) {
	            	FileWriter fw = new FileWriter("error.txt",true);
	            	PrintWriter pw = new PrintWriter(fw);
	            	JSONObject obj = new JSONObject(response.toString());
	            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	            	String date = sdf.format(Calendar.getInstance().getTime());
	            	String msg = date + "\t" + responseCode + "\t" + obj.getString("errorCode")
	            	+ "\t" + obj.getString("errorMessage");
	            	pw.println(msg);
	            	pw.flush();
	            	pw.close();
	            	fw.close();
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }

	}

}
