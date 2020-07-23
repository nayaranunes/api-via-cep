package com.search.viacep.usage;

import com.search.viacep.entity.Address;
import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonObject;

public class ClientViaCep {
    public static Address getAddressByCep(String cep) {

        try {

            JsonObject jsonObject = getZipCodeResponse(cep);

            Address address = new Address(jsonObject.getString("cep"),
                    jsonObject.getString("logradouro"),
                    jsonObject.getString("complemento"),
                    jsonObject.getString("bairro"),
                    jsonObject.getString("localidade"),
                    jsonObject.getString("uf"),
                    jsonObject.getString("unidade"),
                    jsonObject.getString("ibge"),
                    jsonObject.getString("gia")
            );

            return address;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static JsonObject getZipCodeResponse(String cep) {

        JsonObject responseJO;

        try {
            if (!cep.matches("\\d{8}")) {
                throw new RuntimeException("Invalid CEP");
            }

            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("https://viacep.com.br/ws/"+cep+"/json");
            HttpResponse response = (HttpResponse) httpclient.execute(httpGet);

            HttpEntity entity = response.getEntity();

            responseJO = Json.createReader(entity.getContent()).readObject();

        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return responseJO;
/*
            JACKSON
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://viacep.com.br/ws/"+cep+"/json")
                    .build();
            ObjectMapper objectMapper = new ObjectMapper();
            ResponseBody responseBody = client.newCall(request).execute().body();
*/
    }
}
