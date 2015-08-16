package com.expense.service;

import com.expense.model.Group;
import com.expense.util.ServiceUtil;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AKivanda on 16-08-2015.
 */
public class GroupService {

    public static List<Group> viewYourGroups(String userName){
        HttpClient client = new DefaultHttpClient();
        List<Group> groups = new ArrayList<Group>();
        String requestString = "http://10.0.2.2:8080/group/viewgroups/"+userName;
        HttpGet request = ServiceUtil.createHttpGet(requestString);
        JSONObject jsonObject = null;
        try {
            HttpResponse response  = client.execute(request);
            String jsonResponse = null;
            if(response.getStatusLine().getStatusCode()==200 && response.getEntity() != null){
                InputStream instream =  response.getEntity().getContent();
                jsonResponse = ServiceUtil.convertStreamToString(instream);
                JSONArray jsonArray = new JSONArray(jsonResponse);
                for (int i=0 ; i<jsonArray.length();i++){
                    JSONObject json = jsonArray.getJSONObject(i);
                    Group group = new Group();
                    group.setGroupName(json.getString("groupName"));
                    group.setGroupId(json.getInt("groupId"));
                    groups.add(group);
                }
            }else{
                return null;
            }
        }catch (Exception e){
            return null;
        }
        return groups;
    }
}
