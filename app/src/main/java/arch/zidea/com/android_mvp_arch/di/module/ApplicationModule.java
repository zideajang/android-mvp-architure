package arch.zidea.com.android_mvp_arch.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.internal.ConstructorConstructor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;

import javax.inject.Singleton;

import arch.zidea.com.android_mvp_arch.data.AppRepository;
import arch.zidea.com.android_mvp_arch.di.ApplicationContext;
import arch.zidea.com.android_mvp_arch.utils.AppConfig;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        this.mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    Cache provideHttpCache(Application application){
        int cacheSize = AppConfig.HTTP_CACHE_SIZE;
        Cache cache = new Cache(application.getCacheDir(),cacheSize);
        return cache;
    }

    @Provides
    Gson provideGson(){
        Gson gson = new Gson();
        GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
        //定义返回的规则
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .serializeNulls();
        return gsonBuilder.create();
    }

    @Provides
    OkHttpClient provideOkHttpClient(Cache cache, Application application){
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        return client.build();
    }

    @Provides
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient){
        return  new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.github.com/")
                .client(okHttpClient)
                .build();
    }

    @Provides
    AppRepository provideAppRepository(Retrofit retrofit){
        return new AppRepository(retrofit);
    }

}
