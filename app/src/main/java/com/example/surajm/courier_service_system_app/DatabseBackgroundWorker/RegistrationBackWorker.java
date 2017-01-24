package com.example.surajm.courier_service_system_app.DatabseBackgroundWorker;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.widget.ProgressBar;

import com.example.surajm.courier_service_system_app.Activity.RegistrationActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Suraj m on 24-01-2017.
 */

public class RegistrationBackWorker extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;
    ProgressBar progress;
    public RegistrationBackWorker(Context context) {
        this.context = context;
    }


    @Override
    protected String doInBackground(String... strings) {
        String type = strings[0];
        String register_url = "http://192.168.43.28/css/user_registration.php";

        if(type.equals("register"))
        {
            try {
                String name1 = strings[1];
                String mobile1 = strings[2];
                String address1 = strings[3];
                String pincode1 = strings[4];
                String gender = strings[5];
                String email1 = strings[6];
                String username1 = strings[7];
                String password1 = strings[8];

                URL url = new URL(register_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("name", "UTF-8")+ "=" + URLEncoder.encode(name1, "UTF-8") + "&"
                        +URLEncoder.encode("mobile", "UTF-8")+ "=" + URLEncoder.encode(mobile1, "UTF-8") + "&"
                        +URLEncoder.encode("address", "UTF-8")+ "=" + URLEncoder.encode(address1, "UTF-8") + "&"
                        +URLEncoder.encode("pincode", "UTF-8")+ "=" + URLEncoder.encode(pincode1, "UTF-8") + "&"
                        +URLEncoder.encode("gender", "UTF-8")+ "=" + URLEncoder.encode(gender, "UTF-8") + "&"
                        +URLEncoder.encode("email", "UTF-8")+ "=" + URLEncoder.encode(email1, "UTF-8") + "&"
                        +URLEncoder.encode("uname", "UTF-8")+ "=" + URLEncoder.encode(username1, "UTF-8") + "&"
                        +URLEncoder.encode("password", "UTF-8")+ "=" + URLEncoder.encode(password1, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String readline = "";

                while ((readline = bufferedReader.readLine()) != null) {

                    result += readline;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            }
            catch (IOException e){
                e.printStackTrace();
            }

            }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();

    }

    @Override
    protected void onPostExecute(String result) {
        if (result == null)
        {
            alertDialog.setTitle("Network Connection  Error");
            alertDialog.setMessage("Please Check Your connection and try again...");
        }
        else
        {
            alertDialog.setTitle("Registration Status");
            alertDialog.setMessage(result);

        }
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
