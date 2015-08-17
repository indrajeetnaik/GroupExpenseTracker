package com.expense.service;

import com.expense.model.User;
import com.expense.util.ServiceUtil;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by AKivanda on 16-08-2015.
 */

public class UserService {



    public static User validateUser(User user){
        HttpClient client = new DefaultHttpClient();
        HttpPost request = ServiceUtil.createHttpPost("http://10.0.2.2:8080/user/signin");
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("userName",user.getUserName());
            jsonObject.put("password", user.getPassword());
            request.setEntity(new StringEntity(jsonObject.toString()));
            HttpResponse response = client.execute(request);
            String jsonResponse = null;
            if ( response.getStatusLine().getStatusCode() ==200 && response.getEntity() != null) {
                InputStream instream =  response.getEntity().getContent();
                jsonResponse = ServiceUtil.convertStreamToString(instream);
                jsonObject = new JSONObject(jsonResponse);
                user.setUserId(jsonObject.getInt("userId"));
                user.setEmailAddress(jsonObject.getString("emailId"));
                user.setMobileNum(jsonObject.getString("phoneNumber"));
                // Closing the input stream will trigger connection release
                instream.close();
            }else{
                return  null;
            }
        }catch(Exception e){
            return null;
        }
        return  user;
    }

    public static User signUpUser(User user){
        HttpClient client = new DefaultHttpClient();
        HttpPost request = ServiceUtil.createHttpPost("http://10.0.2.2:8080/user/signupuser");
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("userName",user.getUserName());
            jsonObject.put("password", user.getPassword());
            jsonObject.put("firstName" , user.getFirstName());
            jsonObject.put("lastName",user.getLastName());
            jsonObject.put("emailId",user.getEmailAddress());
            jsonObject.put("phoneNumber",user.getMobileNum());
            request.setEntity(new StringEntity(jsonObject.toString()));
            HttpResponse response = client.execute(request);
            String jsonResponse = null;
            if ( response.getStatusLine().getStatusCode() ==200 && response.getEntity() != null) {
                InputStream instream =  response.getEntity().getContent();
                jsonResponse = ServiceUtil.convertStreamToString(instream);
                jsonObject = new JSONObject(jsonResponse);
                user.setUserId(jsonObject.getInt("userId"));
                // Closing the input stream will trigger connection release
                instream.close();
            }else{
                return  null;
            }
        }catch(Exception e){
            return null;
        }
        return  user;
    }
}
