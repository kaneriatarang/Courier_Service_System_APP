package com.example.surajm.courier_service_system_app.DatabseBackgroundWorker;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import static com.example.surajm.courier_service_system_app.Activity.Login_mainActivity.progress;

/**
 * Created by Suraj m on 25-01-2017.
 */

public class LoginBackWorker extends AsyncTask<String,Void,String> {

    AlertDialog alertDialog;
    Context context;

    public LoginBackWorker(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        String type = strings[0];

        String login_url = "http://192.168.43.28/css/user_login.php";

        if (type.equals("login")) {
            try {
                String uname = strings[1];
                String Pass = strings[2];

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String postData = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(uname, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(Pass, "UTF-8");

                bufferedWriter.write(postData);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                inputStream.close();
                bufferedReader.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

        @Override
        protected void onPreExecute() {
            alertDialog = new AlertDialog.Builder(context).create();
//            progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String result) {
//            progress.setVisibility(View.GONE);
            if (result == null)
            {
                alertDialog.setTitle("Network Connection  Error");
                alertDialog.setMessage("Please Check Your connection and try again...");
                alertDialog.show();
            }
            else if (result.matches("wrong"))
            {
                alertDialog.setTitle("Login Status");
                alertDialog.setMessage("Username or Password are wrong...");
                alertDialog.show();
            }
            else {
                alertDialog.setTitle("Login Status");
                try {
                    JSONObject json = (JSONObject)new JSONTokener(result).nextValue();
                    JSONObject myjeson = json.getJSONObject("result");
                    String nameout = (String)myjeson.get("Name");
                    Log.d("name",nameout);
                    alertDialog.setMessage(nameout);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                alertDialog.show();
                Toast.makeText(context, "login process..", Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
}
