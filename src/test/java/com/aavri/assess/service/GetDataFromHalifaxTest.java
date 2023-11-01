package com.aavri.assess.service;

import com.aavri.assess.entity.*;
import com.alibaba.fastjson.JSON;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.aavri.assess.entity.Brancho;

@RunWith(SpringRunner.class)
public class GetDataFromHalifaxTest {

    @Test
    public void shouldReturn200GetDataFromHalifax() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("APIKey", "5567GGH67225HYVGG");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String resourceURL = "https://developer.halifax.co.uk/opendata-v2.2";
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(resourceURL, HttpMethod.GET, entity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println(response);
        } else {
            System.out.println("Error!");
        }
    }

    @Test
    public void GetDataFromSite2() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
//        headers.set("APIKey", "5567GGH67225HYVGG");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String resourceURL = "https://api.halifax.co.uk/open-banking/v2.2/branches";
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(resourceURL, HttpMethod.GET, entity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            String body = response.getBody();
            Halifax halifax = JSON.parseObject(body, Halifax.class);
            ArrayList<Brancho> branchos = new ArrayList<Brancho>();
            for (Data da : halifax.getData()) {
                for (Brand bd : da.getBrand()) {
                    for (Branch bh : bd.getBranch()) {
                        Brancho brancho = new Brancho();
                        brancho.setBranchName(bh.getName());
                        brancho.setLatitude(Float.parseFloat(bh.getPostalAddress().getGeoLocation().getGeographicCoordinates().getLatitude()));
                        brancho.setLongitude(Float.parseFloat(bh.getPostalAddress().getGeoLocation().getGeographicCoordinates().getLongitude()));
                        if (bh.getPostalAddress().getAddressLine() != null)
                            brancho.setStreetAddress(bh.getPostalAddress().getAddressLine()[0]);
                        brancho.setCity(bh.getPostalAddress().getTownName());
                        if (bh.getPostalAddress().getCountrySubDivision() != null)
                            brancho.setCountrySubDivision(bh.getPostalAddress().getCountrySubDivision()[0]);
                        brancho.setCountry(bh.getPostalAddress().getCountry());
                        brancho.setPostCode(bh.getPostalAddress().getPostCode());
                        branchos.add(brancho);
                    }
                }
            }

            System.out.println(response);
        } else {
            System.out.println("Error!");
        }
    }

    @Test
    public void GetDataFromSite3() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.halifax.co.uk/open-banking/v2.2/branches/")
                .get()
                .addHeader("if-modified-since", "REPLACE_THIS_VALUE")      // 2018-11-10
                .addHeader("if-none-match", "REPLACE_THIS_VALUE")           // Physical
                .addHeader("accept", "application/prs.openbanking.opendata.v2.2+json")
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            System.out.println("successfule:\n" + response);
        } else {
            System.out.println("Error!");
        }
    }

    @Test
    public void retriveRequiredFieldValues() throws Exception {
//		File file = new File("./files/halifax2");
        File file = new File("./files/halifax.txt");
        FileInputStream inStream = new FileInputStream(file);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        int limit = 4096, readed = -1;
        byte[] bytes = new byte[limit];
        while ((readed = inStream.read(bytes)) > 0) {
            outStream.write(bytes, 0, readed);
        }
        String json = new String(outStream.toByteArray());
        Halifax halifax = JSON.parseObject(json, Halifax.class);

        ArrayList<Brancho> branchos = new ArrayList<Brancho>();
        for (Data da : halifax.getData()) {
            for (Brand bd : da.getBrand()) {
                for (Branch bh : bd.getBranch()) {
                    Brancho brancho = new Brancho();
                    brancho.setBranchName(bh.getName());
                    brancho.setLatitude(Float.parseFloat(bh.getPostalAddress().getGeoLocation().getGeographicCoordinates().getLatitude()));
                    brancho.setLongitude(Float.parseFloat(bh.getPostalAddress().getGeoLocation().getGeographicCoordinates().getLongitude()));
                    if (bh.getPostalAddress().getAddressLine() != null)
                        brancho.setStreetAddress(bh.getPostalAddress().getAddressLine()[0]);
                    brancho.setCity(bh.getPostalAddress().getTownName());
                    if (bh.getPostalAddress().getCountrySubDivision() != null)
                        brancho.setCountrySubDivision(bh.getPostalAddress().getCountrySubDivision()[0]);
                    brancho.setCountry(bh.getPostalAddress().getCountry());
                    brancho.setPostCode(bh.getPostalAddress().getPostCode());
                    branchos.add(brancho);
                }
            }
        }

        System.out.println(JSON.toJSONString(halifax));
        inStream.close();
    }
}
