package arch.zidea.com.android_mvp_arch;

import android.app.Application;

import javax.inject.Inject;

import arch.zidea.com.android_mvp_arch.data.AppRepository;
import arch.zidea.com.android_mvp_arch.di.component.ApplicationComponent;
import arch.zidea.com.android_mvp_arch.di.component.DaggerApplicationComponent;
import arch.zidea.com.android_mvp_arch.di.module.ApplicationModule;

public class ZiApp extends Application {

    @Inject
    AppRepository appRepository;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
