package arch.zidea.com.android_mvp_arch.data;

import javax.inject.Inject;

import arch.zidea.com.android_mvp_arch.data.network.ApiService;
import arch.zidea.com.android_mvp_arch.data.network.model.UserResponse;
import io.reactivex.Single;
import retrofit2.Retrofit;

public class AppRepository {

    private ApiService apiService;
    private Retrofit retrofit;

    @Inject
    public AppRepository(Retrofit retrofit) {
        this.retrofit = retrofit;
        this.apiService = retrofit.create(ApiService.class);
    }

    public Single<UserResponse> doUserCall(String username){
        return apiService.doUserApiCall(username);
    }
}
