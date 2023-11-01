package com.aavri.assess.backup;

import com.aavri.assess.Common.ObjectAndJsonConvertter;
import com.aavri.assess.entity.Halifax;
import com.aavri.assess.service.ProvidedBranchLocationToClientService;
import com.alibaba.fastjson.JSON;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;

@RestController
@RequestMapping("/branchs")
public class GetDataFromHalifaxController {

    @Autowired
   private ProvidedBranchLocationToClientService bs;

    @RequestMapping("/halifax")
    public String GetDataFromSite() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("APIKey", "5567GGH67225HYVGG");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String resourceURL = "https://developer.halifax.co.uk/opendata-v2.2";
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(resourceURL, HttpMethod.GET, entity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
//            System.out.println(response);
            return response.toString();
        } else {
//            System.out.println("Error!");
            return "Error!";
        }
    }

    @RequestMapping("/halifax1")
    public String GetDataFromSite1() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("APIKey", "5567GGH67225HYVGG");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String resourceURL = "https://api.halifax.co.uk/open-banking/v2.2/branches";
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(resourceURL, HttpMethod.GET, entity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
//            System.out.println(response);
            return response.toString();
        } else {
//            System.out.println("Error!");
            return "Error!";
        }
    }

    @RequestMapping("/halifax2")
    public ResponseEntity GetDataFromSite2() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("APIKey", "5567GGH67225HYVGG");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String resourceURL = "https://api.halifax.co.uk/open-banking/v2.2/branches";
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(resourceURL, HttpMethod.GET, entity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
//            System.out.println(response);
            return response;
        } else {
//            System.out.println("Error!");
            return null;
        }
    }

    @RequestMapping("/halifax3")
    public static String GetDataFromSite3() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.halifax.co.uk/open-banking/v2.2/branches/")
                .get()
                .addHeader("if-modified-since", "2018-11-10")      // REPLACE_THIS_VALUE
                .addHeader("If-none-match", "noPhysical")           // REPLACE_THIS_VALUE
                .addHeader("accept", "application/prs.openbanking.opendata.v2.2+json")
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @RequestMapping("/halifax31")
    public static ResponseBody GetDataFromSite31() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.halifax.co.uk/open-banking/v2.2/branches")
                .get()
                .addHeader("if-modified-since", "2018-11-10")      // REPLACE_THIS_VALUE
                .addHeader("if-none-match", "noPhysical")
                .addHeader("accept", "application/prs.openbanking.opendata.v2.2+json")
                .build();
        Response response = client.newCall(request).execute();
        return response.body();
    }

    @RequestMapping("/halifax4")
    public static String GetDataFromSite4() throws IOException {
        final String url = "https://api.halifax.co.uk/open-banking/v2.2/branches";
        URL restURL = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
        conn.setRequestMethod("GET"); // POST GET PUT DELETE
        conn.setRequestProperty("Accept", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while((line = br.readLine()) != null ){
            System.out.println(line);
    }
        br.close();
        return line;
    }

    @RequestMapping("/halifax5")
    public String retriveRequiredFieldValues() throws Exception {
//		File file = new File("./files/halifax2");
        File file = new File("./files/halifax.txt");
        FileInputStream inStream = new FileInputStream( file );
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        int limit = 4096, readed=-1;
        byte[] bytes = new byte[limit];
        while( (readed=inStream.read(bytes)) > 0){
            outStream.write(bytes, 0, readed);
        }
        String json = new String( outStream.toByteArray() );
        Halifax halifax = JSON.parseObject( json, Halifax.class);
        System.out.println( JSON.toJSONString(halifax));
        inStream.close();
        return JSON.toJSONString(halifax);
    }

    @RequestMapping("/all")
    public String getAllBranch() {
        return ObjectAndJsonConvertter.object_2_json(bs.getAllBranchInfoService());
    }
//
//    @RequestMapping("{id}")
//    public Brancho getBranch(@PathVariable("id") String id) {
//        return bs.getBranch(id);
//    }
}
