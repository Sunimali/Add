package com.example.user.add;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

class SharedPrefManager {
    Context contex;
    SharedPrefManager(Context contex){
        this.contex=contex;
    }
    /*params.put("name",p.get(0));
                params.put("username", username);
                params.put("password", p.get(1));
                params.put("address", p.get(2));
                params.put("email", p.get(3));
                params.put("mobile", p.get(4));
                params.put("id",id);
                params.put("imageURL",imageToString(bitmap));*/
    public static String myConnection(String webUrl,String name, String username, String password, String address, String email, String mobile, String id, String imageURL) {//2
            try {
                URL url = new URL(webUrl);
                URLConnection con = url.openConnection();
                con.setDoOutput(true);


                OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());

                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&" +
                        URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("mobile", "UTF-8") + "=" + URLEncoder.encode(mobile, "UTF-8") + "&" +
                        URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8") + "&" +
                        URLEncoder.encode("imageURL", "UTF-8") + "=" + URLEncoder.encode(imageURL, "UTF-8");
                writer.write(data);
                writer.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {

                    sb.append(line);
                    break;
                }
                return sb.toString();


            } catch (Exception e) {


                System.out.println(e);
                return "Error : Check your Connection";

            }
    }

}
