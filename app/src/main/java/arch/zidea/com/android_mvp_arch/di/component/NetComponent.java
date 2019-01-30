package arch.zidea.com.android_mvp_arch.di.component;

import javax.inject.Singleton;

import arch.zidea.com.android_mvp_arch.di.module.ApplicationModule;
import arch.zidea.com.android_mvp_arch.di.module.NetModule;
import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                NetModule.class
        }
)
public interface NetComponent {
}
