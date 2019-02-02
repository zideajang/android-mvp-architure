package arch.zidea.com.android_mvp_arch.di.module;

import android.app.Service;

import dagger.Module;

@Module
public class ServiceModule {

    private final Service mService;

    public ServiceModule(Service mService) {
        this.mService = mService;
    }
}
