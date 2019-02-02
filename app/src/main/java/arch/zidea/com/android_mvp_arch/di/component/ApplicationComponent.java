package arch.zidea.com.android_mvp_arch.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import arch.zidea.com.android_mvp_arch.ZiApp;
import arch.zidea.com.android_mvp_arch.data.AppRepository;
import arch.zidea.com.android_mvp_arch.di.ApplicationContext;
import arch.zidea.com.android_mvp_arch.di.module.ApplicationModule;
import arch.zidea.com.android_mvp_arch.service.SyncService;
import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(ZiApp app);
    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();
    AppRepository getAppRepository();
}
