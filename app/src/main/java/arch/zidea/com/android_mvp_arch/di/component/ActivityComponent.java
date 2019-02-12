package arch.zidea.com.android_mvp_arch.di.component;

import javax.inject.Singleton;

import arch.zidea.com.android_mvp_arch.di.ApiInfo;
import arch.zidea.com.android_mvp_arch.di.PerActivity;
import arch.zidea.com.android_mvp_arch.di.PerService;
import arch.zidea.com.android_mvp_arch.di.module.ActivityModule;
import arch.zidea.com.android_mvp_arch.page.feed.FeedActivity;
import arch.zidea.com.android_mvp_arch.page.login.LoginActivity;
import arch.zidea.com.android_mvp_arch.page.main.MainActivity;
import arch.zidea.com.android_mvp_arch.page.splash.SplashActivity;
import dagger.Component;


@PerService
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity activity);

    void inject(LoginActivity activity);

    void inject(MainActivity activity);

    void inject(FeedActivity activity);
}
