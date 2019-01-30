package arch.zidea.com.android_mvp_arch.data.network;

import arch.zidea.com.android_mvp_arch.data.network.model.UserResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiService {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("/users/{username}")
    Single<UserResponse> loadUser(
            @Path("username") String username
    );
}
