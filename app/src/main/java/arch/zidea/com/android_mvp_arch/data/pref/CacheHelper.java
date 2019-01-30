package arch.zidea.com.android_mvp_arch.data.pref;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

public class CacheHelper {
    private static final String TAG = CacheHelper.class.getSimpleName();
    private static CacheHelper INSTANCE;

    private static int counter = 0;

    private ConcurrentHashMap<String, SoftReference<Object>> mCache;
    private String mPrefFileName = "com.mangoonline.app";
    private Context mContext;

    private CacheHelper(Context mContext,String prefFileName) {
//        System.out.println("init 222");
//        this.mPrefFileName = mPrefFileName;
        this.mContext = mContext.getApplicationContext();
        System.out.println(this.mContext);
        mCache = new ConcurrentHashMap<String, SoftReference<Object>>();
        initDatas(prefFileName);
    }

    private void initDatas(String prefFileName) {
        if(null != prefFileName && prefFileName.trim().length() > 0){
            mPrefFileName = prefFileName;
        }else{
            Log.d(TAG, "initDatas: ");
        }
    }



    public static CacheHelper init(Context context, String prefFileName){
        System.out.println("init" + counter);
        counter++;
        if(INSTANCE == null){
            synchronized (CacheHelper.class){
                if(INSTANCE == null){
                    INSTANCE = new CacheHelper(context, prefFileName);
                }
            }
        }

        return INSTANCE;
    }

    public static CacheHelper init(Context context){
        return init(context,null);
    }

    private static CacheHelper getInstance(){
        if(INSTANCE == null)
            throw new NullPointerException("you show SpcCache.init() ");
        return INSTANCE;
    }

    public static CacheHelper putInt(String key, int val){
        return getInstance().put(key,val);
    }

    public static CacheHelper putLong(String key, long val)
    {
        return getInstance().put(key, val);
    }

    public static CacheHelper putString(String key, String val)
    {
        return getInstance().put(key, val);
    }

    public static CacheHelper putBoolean(String key, boolean val)
    {
        return getInstance().put(key, val);
    }

    public static CacheHelper putFloat(String key, float val)
    {
        return getInstance().put(key, val);
    }

    public CacheHelper _clear()
    {
        mCache.clear();
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.clear();
        SharedPreferencesCompat.apply(editor);
        return INSTANCE;
    }

    public  <T> CacheHelper put(String key, T t){
        mCache.put(key, new SoftReference<Object>(t));

        SharedPreferences.Editor editor = getSharedPreferences().edit();

        if(t instanceof String){
            editor.putString(key, (String) t);
        } else if(t instanceof Integer){
            editor.putInt(key, (Integer) t);
        } else if(t instanceof Boolean){
            editor.putBoolean( key, (Boolean) t);
        } else if( t instanceof Float ){
            editor.putFloat( key, (Float) t);
        } else if ( t instanceof Long ){
            editor.putLong( key, (Long) t);
        }else {
            Log.d(TAG, "you may be put a invalid object :" + t);
            editor.putString(key, t.toString());
        }

        SharedPreferencesCompat.apply(editor);

        return INSTANCE;
    }


    public static int getInt(String key, int defaultVal)
    {
        return (int) (getInstance().get(key, defaultVal));
    }

    public static long getLong(String key, long defaultVal)
    {
        return (long) (getInstance().get(key, defaultVal));
    }

    public static String getString(String key, String defaultVal)
    {
        return (String) (getInstance().get(key, defaultVal));
    }

    public static boolean getBoolean(String key, boolean defaultVal)
    {
        return (boolean) (getInstance().get(key, Boolean.class));
    }

    public static float getFloat(String key, float defaultVal)
    {
        return (float) (getInstance().get(key, defaultVal));
    }


    private Object readDisk(String key, Object defaultObject){

        SharedPreferences sp = getSharedPreferences();

        if(defaultObject instanceof String){
            return sp.getString(key,(String)defaultObject);
        }else if (defaultObject instanceof Integer)
        {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean)
        {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float)
        {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long)
        {
            return sp.getLong(key, (Long) defaultObject);
        }
//        Log.e(TAG, "you can not read object , which class is " + defaultObject.getClass().getSimpleName());

        return null;

    }

    private Object get(String key, Object defaultVal)
    {
        SoftReference reference = mCache.get(key);
        Object val = null;
        if (null == reference || null == reference.get())
        {
            val = readDisk(key, defaultVal);
            mCache.put(key, new SoftReference<Object>(val));
        }
        val = mCache.get(key).get();
        return val;
    }


    private static class SharedPreferencesCompat{

        private static final Method sApplyMethod = findApplyMethod();

        @SuppressWarnings({"unchecked","rawtypes"})
        private static Method findApplyMethod() {

            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            return null;
        }

        private static void apply(final SharedPreferences.Editor editor){

            try {
                if(sApplyMethod != null){
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    editor.commit();
                    return null;
                }
            };

        }
    }

    private SharedPreferences getSharedPreferences(){
        return mContext.getSharedPreferences(mPrefFileName,Context.MODE_PRIVATE);
    }
}
