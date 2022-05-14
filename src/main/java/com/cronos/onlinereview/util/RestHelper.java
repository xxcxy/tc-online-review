package com.cronos.onlinereview.util;

import com.cronos.onlinereview.model.api.EditProjectResponse;
import com.cronos.onlinereview.model.api.ListProjectResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.topcoder.util.errorhandling.BaseException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RestHelper {
    public static final String REST_API_BASE_URL = "http://host.docker.internal:9999";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static <T> T get(String url, Map<String, String> param, Class<T> clazz) {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            String params = param.entrySet().stream()
                    .map(e -> String.join("=", e.getKey(), URLEncoder.encode(e.getValue())))
                    .collect(Collectors.joining("&"));
            HttpGet httpGet = new HttpGet(new URI(String.join(url.contains("?") ? "&" : "?", url, params)));
            httpGet.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new BaseException("Failed to get the token:" + response.getStatusLine().getReasonPhrase());
            }
            String data = EntityUtils.toString(entity);
            return objectMapper.readValue(data, clazz);
        } catch (Exception exp) {
            throw new RuntimeException("Get data from api error", exp);
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    public static void main(String[] args) {
        Map<String, String> param = new HashMap<>();
        param.put("activeTab", String.valueOf(1));
        param.put("scope", "my");
        param.put("userId", String.valueOf(132456L));
        param.put("role", "Global Manager");
        EditProjectResponse data = RestHelper.get("http://localhost:9999/projects/671", param, EditProjectResponse.class);
        System.out.println(data.toString());
    }
}
