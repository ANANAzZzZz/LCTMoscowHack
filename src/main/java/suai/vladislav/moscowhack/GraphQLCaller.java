package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class GraphQLCaller {
    public static HttpResponse callGraphQLService(String url, String query)
            throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url);
        request.setHeader("Accept", "*/*");
        request.setHeader("Content-type", "application/json");
        request.setHeader("Connection", "keep-alive");

        // Создаем JSON объект для запроса с query и variables
        Map<String, Object> requestJson = new HashMap<>();
        requestJson.put("query", query);

//        if (variables != null) {
//            requestJson.put("variables", variables);
//        }

        // Конвертация объекта запроса в JSON строку
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(requestJson);

        // Установка тела запроса
        request.setEntity(new StringEntity(requestBody));

        // Выполнение запроса и возврат ответа
        return client.execute(request);
    }
}
