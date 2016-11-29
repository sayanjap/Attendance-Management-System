package com.akshaysonvane.cmpe273.adapters;

import com.akshaysonvane.cmpe273.api.ConnectionApi;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

import static com.akshaysonvane.cmpe273.utils.Utils.BASE_URL;

/**
 * Created by Akshay on 11/20/2016.
 */

public class RestAdapterClass
{

    public ConnectionApi getApiClassObject()
    {
        final OkHttpClient client = new OkHttpClient();
        client.setReadTimeout(60, TimeUnit.SECONDS);
        client.setConnectTimeout(60, TimeUnit.SECONDS);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(client))
                .build();

        return restAdapter.create(ConnectionApi.class);
    }


}
