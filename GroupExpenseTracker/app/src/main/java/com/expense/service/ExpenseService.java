package com.expense.service;

import com.expense.model.Expense;
import com.expense.model.Group;
import com.expense.util.ServiceUtil;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AKivanda on 17-08-2015.
 */
public class ExpenseService {

    public static List<Expense> getAllExpenses(String groupName){
        HttpClient client = new DefaultHttpClient();
        List<Expense>  expenses= new ArrayList<Expense>();
        String requestString = "http://10.0.2.2:8080/expense/"+groupName+"/getExpenses";
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
                    Expense expense = new Expense();
                    expenses.add(expense);
                }
            }else{
                return null;
            }
        }catch (Exception e){
            return null;
        }
        return expenses;
    }
}
