package me.eroshenkoam.examples;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * @author Artem Eroshenko <erosenkoam@me.com>
 */
public class ClientFactory {

    private ClientFactory() {
    }

    public static Gson createGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .serializeNulls()
                .create();
    }

    public static <T> T createClient(Class<T> clientClass, String endpoint) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .baseUrl(endpoint)
                .build();

        return retrofit.create(clientClass);
    }
}
