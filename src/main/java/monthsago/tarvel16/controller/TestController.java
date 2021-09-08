package monthsago.tarvel16.controller;

import monthsago.tarvel16.Model.Test;
import monthsago.tarvel16.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TestController {


    @Autowired
    private TestService testService;

    //getAllBoard - mobile
    @GetMapping("/test")
    public List<Test> getTest() {
        return testService.getTest();
    }

    @GetMapping("/getinformation")
    public String test() throws IOException {

        String urlBuilder = "http://api.data.go.kr/openapi/tn_pubr_public_trrsrt_api" + "?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D" + /*Service Key*/
                "&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("0", "UTF-8") + /*페이지 번호*/
                "&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8") + /*한 페이지 결과 수*/
                "&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8") ;
        URL url = new URL(urlBuilder);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        System.out.println(sb.toString());
        return sb.toString();
    }

}
