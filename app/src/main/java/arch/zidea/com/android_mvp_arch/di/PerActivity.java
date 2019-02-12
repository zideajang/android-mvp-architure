package arch.zidea.com.android_mvp_arch.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Scope;


@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
