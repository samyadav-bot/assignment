package com.example.Project1.util;

public class URLUtility {

   static String url_without_parameter="http://%s:%s/%s";

    public  static  String getURLString(String host , int port, String callingUrl)
    {
      return String.format(url_without_parameter, host, port,callingUrl);
    }
}
