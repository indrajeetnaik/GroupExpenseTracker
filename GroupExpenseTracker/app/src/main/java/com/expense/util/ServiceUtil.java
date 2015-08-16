package com.expense.util;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by AKivanda on 16-08-2015.
 */
public class ServiceUtil {

    public static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static  HttpPost createHttpPost(String requestString){
        HttpPost httpPost = new HttpPost(requestString);
        httpPost.setHeader("accept" , "application/json");
        httpPost.setHeader("Content-type" , "application/json");
        return httpPost;
    }

    public static HttpGet createHttpGet(String requestString){
        return new HttpGet(requestString);
    }
}
