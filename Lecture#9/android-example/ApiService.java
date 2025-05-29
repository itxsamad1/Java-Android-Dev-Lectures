package com.example.smiuapp.api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;
import java.util.List;

public class ApiService {
    private static final String BASE_URL = "http://your-api-url:3000/api/";
    private static ApiService instance;
    private final ApiInterface api;

    private ApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(ApiInterface.class);
    }

    public static synchronized ApiService getInstance() {
        if (instance == null) {
            instance = new ApiService();
        }
        return instance;
    }

    // API Interface
    public interface ApiInterface {
        // User endpoints
        @GET("users")
        Call<List<User>> getUsers();

        @GET("users/{id}")
        Call<User> getUser(@Path("id") int userId);

        @POST("users")
        Call<User> createUser(@Body User user);

        // Product endpoints
        @GET("products")
        Call<List<Product>> getProducts();

        @GET("products/{id}")
        Call<Product> getProduct(@Path("id") int productId);

        // Order endpoints
        @GET("orders")
        Call<List<Order>> getOrders();

        @POST("orders")
        Call<Order> createOrder(@Body OrderRequest orderRequest);
    }

    // Data Models
    public static class User {
        public int id;
        public String name;
        public String email;
        public String password;
    }

    public static class Product {
        public int id;
        public String name;
        public String description;
        public double price;
        public int stock_quantity;
    }

    public static class Order {
        public int id;
        public int user_id;
        public double total_amount;
        public String status;
        public List<OrderItem> items;
    }

    public static class OrderItem {
        public int product_id;
        public int quantity;
        public double price;
    }

    public static class OrderRequest {
        public int user_id;
        public List<OrderItem> items;
    }

    // Example usage methods
    public void getAllProducts(final ApiCallback<List<Product>> callback) {
        api.getProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    // Callback interface
    public interface ApiCallback<T> {
        void onSuccess(T result);
        void onError(String error);
    }
} 