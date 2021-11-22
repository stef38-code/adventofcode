package org.advent.of.code;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class MyHttp {
    protected String getUserHome(){
        return System.getProperty("user.home");
    }
    protected HttpClient getNewHttpClient(){
        return HttpClient.newBuilder().build();
    }
    protected HttpRequest getNewBuilder(String url){
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
    }
}
