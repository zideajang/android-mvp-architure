package arch.zidea.com.android_mvp_arch;

import android.app.Application;
import android.support.annotation.UiThread;

import arch.zidea.com.android_mvp_arch.data.pref.CacheHelper;
import arch.zidea.com.android_mvp_arch.di.component.DaggerNetComponent;
import arch.zidea.com.android_mvp_arch.di.component.NetComponent;
import arch.zidea.com.android_mvp_arch.di.module.ApplicationModule;
import arch.zidea.com.android_mvp_arch.di.module.NetModule;
import arch.zidea.com.android_mvp_arch.utils.AppConfig;

public class ZiApp extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        CacheHelper.init(this);
    }


    @UiThread
    public  NetComponent getNetComponent(){
        mNetComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .applicationModule(new ApplicationModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule(AppConfig.BASE_URL))
//                .netModule(new NetModule(ScConfig.WEB_SITE_URL))
                .build();
        return mNetComponent;
    }
}
