package org.advent.of.code;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;

@Slf4j
public class HttpTools {
    String url_entree ="https://adventofcode.com/{0}/day/{1}/input";
    String url_reponse ="https://adventofcode.com/{0}/day/{1}/answer";
    String cookieSession ="53616c7465645f5fb57821b8d8872e7695320602d509fa64524f014f6b0a552b2c538b0aad6e0b27d83bf114a0a1eb3a";
    protected String getUserHome(){
        return System.getProperty("user.home");
    }
    protected HttpClient getNewHttpClientGet(){
        return HttpClient.newBuilder().build();
    }
    protected HttpRequest getNewRequestBuilder(String url){
        log.info("url:{}",url);
        return HttpRequest.newBuilder()
                .GET()
                .setHeader("Cookie", "session=".concat(cookieSession))
                .uri(URI.create(url))
                .build();
    }
    protected String getFileContent(String year, String day){
        HttpClient httpClient = getNewHttpClientGet();

        String url = MessageFormat.format(url_entree, year, day);
        HttpRequest request = getNewRequestBuilder(url);
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            HttpHeaders headers = response.headers();
            headers.map().forEach((k, v) -> log.info("heard {} = {}",k , v));
            if(response.statusCode() == 200 ) {
                return response.body();
            }
        } catch (IOException | InterruptedException e) {
            log.error("--------------------->",e);
        }
        return StringUtils.EMPTY;
    }
}
