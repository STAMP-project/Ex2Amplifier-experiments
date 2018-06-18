package retrofit2;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Rule;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public final class AmplRetrofitTest {
    interface CallMethod {
        @GET("/")
        public abstract Call<String> disallowed();

        @POST("/")
        public abstract Call<ResponseBody> disallowed(@Body
        String body);

        @GET("/")
        public abstract Call<Response> badType1();

        @GET("/")
        public abstract Call<okhttp3.Response> badType2();

        @GET("/")
        public abstract Call<ResponseBody> getResponseBody();

        @GET("/")
        public abstract Call<Void> getVoid();

        @POST("/")
        public abstract Call<ResponseBody> postRequestBody(@Body
        RequestBody body);

        @GET("/")
        public abstract Call<ResponseBody> queryString(@Query("foo")
        String foo);

        @GET("/")
        public abstract Call<ResponseBody> queryObject(@Query("foo")
        Object foo);
    }

    interface FutureMethod {
        @GET("/")
        public abstract Future<String> method();
    }

    interface Extending extends AmplRetrofitTest.CallMethod {}

    interface StringService {
        @GET("/")
        public abstract String get();
    }

    interface UnresolvableResponseType {
        @GET("/")
        public abstract <T> Call<T> typeVariable();

        @GET("/")
        public abstract <T extends ResponseBody> Call<T> typeVariableUpperBound();

        @GET("/")
        public abstract <T> Call<List<Map<String, Set<T[]>>>> crazy();

        @GET("/")
        public abstract Call<?> wildcard();

        @GET("/")
        public abstract Call<? extends ResponseBody> wildcardUpperBound();
    }

    interface UnresolvableParameterType {
        @POST("/")
        public abstract <T> Call<ResponseBody> typeVariable(@Body
        T body);

        @POST("/")
        public abstract <T extends RequestBody> Call<ResponseBody> typeVariableUpperBound(@Body
        T body);

        @POST("/")
        public abstract <T> Call<ResponseBody> crazy(@Body
        List<Map<String, Set<T[]>>> body);

        @POST("/")
        public abstract Call<ResponseBody> wildcard(@Body
        List<?> body);

        @POST("/")
        public abstract Call<ResponseBody> wildcardUpperBound(@Body
        List<? extends RequestBody> body);
    }

    interface VoidService {
        @GET("/")
        public abstract void nope();
    }

    interface Annotated {
        @Retention(RetentionPolicy.RUNTIME)
        @interface Foo {}

        @GET("/")
        @AmplRetrofitTest.Annotated.Foo
        public abstract Call<String> method();

        @POST("/")
        public abstract Call<ResponseBody> bodyParameter(@AmplRetrofitTest.Annotated.Foo
        @Body
        String param);

        @GET("/")
        public abstract Call<ResponseBody> queryParameter(@AmplRetrofitTest.Annotated.Foo
        @Query("foo")
        Object foo);
    }

    interface MutableParameters {
        @GET("/")
        public abstract Call<String> method(@Query("i")
        AtomicInteger value);
    }

    @Rule
    public final MockWebServer server = new MockWebServer();
}

