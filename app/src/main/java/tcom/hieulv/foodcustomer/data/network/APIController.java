package tcom.hieulv.foodcustomer.data.network;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import tcom.hieulv.foodcustomer.MyApplication;

public class APIController {
    private static final int TIME_OUT = 10;
    private static APIService instance;

    public static APIService getInstance() {
        if (instance == null) {
            instance = builder(MyApplication.BASE_URL, TIME_OUT);
        }
        return instance ;

    }

    public static APIService init(String baseUrl) {
        instance = builder(baseUrl, TIME_OUT);
        return instance;
    }

    private static APIService builder(String baseUrl, int timeout) {
        Retrofit.Builder builder = new Retrofit.Builder();
        OkHttpClient httpClient = getUnsafeOkHttpClient(timeout);
        Gson gson = new GsonBuilder()
                .setLenient()
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        Retrofit retrofit = builder
                .baseUrl(baseUrl)
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(APIService.class);

    }

    private static OkHttpClient getUnsafeOkHttpClient(int readTimeoutSecs) {
        return getUnsafeOkHttpClient(readTimeoutSecs, TIME_OUT);
    }

    private static OkHttpClient getUnsafeOkHttpClient() {
        return getUnsafeOkHttpClient(TIME_OUT, TIME_OUT);
    }

    private static OkHttpClient getUnsafeOkHttpClient(int readTimeoutSecs, int connectionTimeout) {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            });
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            builder.connectTimeout(connectionTimeout, TimeUnit.SECONDS)
                    .readTimeout(readTimeoutSecs, TimeUnit.SECONDS)
                    .connectionPool(new ConnectionPool(0, connectionTimeout, TimeUnit.SECONDS));

            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
