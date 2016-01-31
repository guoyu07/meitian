package com.app.everyday.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.app.everyday.datas.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;


/**
 * Created By: Bushijie 399516791@qq.com
 * Date: 2015-03-26 Time: 16:22
 * Describe:网络层
 */
public class ApiClient {
    private static ApiClient instance;

    private ApiClient() {
        super();
        instance = this;
    }

    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    /*========================================解析类====================================================*/
    private static Gson gson;

    public static Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .create();
        }
        return gson;
    }

    /**
     * 把json格式的字符串转为对象
     *
     * @param classOfT
     * @param json
     * @return T 返回类型
     * @throws Exception
     */
    public static <T> T parserJsontoT(Class<T> classOfT, String json) throws Exception {
        return getGson().fromJson(json, classOfT);
    }

    /**
     * 把对象转为json格式的字符串
     *
     * @param object
     * @return
     * @throws Exception
     */
    public static String Object2Json(Object object) throws Exception {
        String string = getGson().toJson(object);
        DebugLog.e("序列化数据为:" + string);
        return string;
    }

    //网络请求封装

    /*========================================请求====================================================*/
    public static final String BASE_URL = "";

    private static AsyncHttpClient client = new AsyncHttpClient(true, 80, 443);

    //GET： 请求指定的页面信息，并返回实体主体。
    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    // 请求服务器接受所指定的文档作为对所标识的URI的新的从属实体。
    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    //从客户端向服务器传送的数据取代指定的文档的内容。
    public static void put(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.put(getAbsoluteUrl(url), params, responseHandler);
    }

    //只请求页面的首部
    public static void head(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {

        client.head(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        DebugLog.e("============> is web request  this url is " + relativeUrl);
        if (relativeUrl.startsWith("https")) {
            return relativeUrl.replace("https", "http");
        }
        if (relativeUrl.startsWith("http")) {
            return relativeUrl;
        }

        return BASE_URL + relativeUrl;
    }


    //根据项目需求对请求链接进行封装
    public String getAssestApi(int skip) {
        return "http://yangbentong.com/api/v2/624a56dbe1c145f7be3f1df3cc3d78a8/assets?limit=1000";
    }

    //话题
    public String getTopicApi1() {
        return "http://api.meitianapp.com/api/v1/activities";
    }

    public String getTopicApi2() {
        return "http://api.meitianapp.com/api/v1/activities";
    }

    public String getTopicApi3() {
        return "http://api.meitianapp.com/api/v1/posts";
    }

    //推荐
    public String getRecommendApi1() {
        return "http://api.meitianapp.com/api/v1/articles";
    }

    public String getRecommendApi2() {
        return "http://api.meitianapp.com/api/v1/categoryGroups";
    }

    public String getRecommendApi3() {
        return "http://api.meitianapp.com/api/v1/articles";
    }
    //每天
    public String getEveryDayAp11(){return "";}
    public String getEveryDayAp12(){return "http://api.meitianapp.com/api/v1/articles";}
    public String getEveryDayAp13(){return "";}
    //专栏
    public String getComumnApi1(){return "http://api.meitianapp.com/api/v1/authors";}

    /**
     * 数据查询通用类
     * 使用说明： 每个页面都在Constans中定义Key值。
     * 以key值进入每个请求。
     * 请求成功后通过Handler 返回消息体对象， 分别为成功和失败。数据请求成功不对错误码做任何处理。都交给请求接口的界面进行操作。
     */
    public String send(final Context mActivity, int PageTag, AsyncHttpResponseHandler asyncHttpResponseHandler, Object object, String... values) {
        if (!NetWorkUtils.isNetworkAvailable(mActivity)) {//如果网络请求失败，网络未连接
            showToast(mActivity, "网络未连接，请检查网络");
        }
        String postUrl = "";
        RequestParams requestParams = new RequestParams();
        //处理请求参数
        switch (PageTag) {
            case Constants.API_TOPIC_TOP:
                postUrl = getTopicApi1();
                requestParams.put("filter", "isOpen");
                requestParams.put("limit", values[0]);
                get(postUrl, requestParams, asyncHttpResponseHandler);
                break;
            case Constants.API_TOPIC_TWO:
                postUrl = getTopicApi2();
                requestParams.put("filter", "isClosed");
                requestParams.put("limit", values[0]);
                get(postUrl, requestParams, asyncHttpResponseHandler);
                break;
            case Constants.API_TOPIC_Three:
                postUrl = getTopicApi3();
                requestParams.put("filter", "byOpenActivities");
                requestParams.put("limit", values[0]);
                get(postUrl, requestParams, asyncHttpResponseHandler);
                break;
            case Constants.API_RECOMMEND_ONE:
                postUrl = getRecommendApi1();
                requestParams.put("filter", "isFocus");
                requestParams.put("start", "0");
                requestParams.put("limit", "1");
                get(postUrl, requestParams, asyncHttpResponseHandler);
                break;
            case Constants.API_RECOMMEND_TWO:
                postUrl = getRecommendApi2();
                requestParams.put("filter", "withCategory");
                get(postUrl, requestParams, asyncHttpResponseHandler);
                break;
            case Constants.API_RECOMMEND_THREE:
                postUrl = getRecommendApi3();
                requestParams.put("filter", "isDiscoveryByAI");
                requestParams.put("start", "61fddd34-67fe-3afa-aa17-d9b8b8ad3f8a");//61fddd34-67fe-3afa-aa17-d9b8b8ad3f8a
                requestParams.put("limit", values[0]);
                client.addHeader("Content-Type", "application/json");
                client.addHeader("Authorization", "YZX1 v=1.7.0;os=android;id=f4b8db89-1379-34b5-89a4-0338852d1ea2;t=1453267190833;sig=a8818187");
                get(postUrl, requestParams, asyncHttpResponseHandler);
                break;
            case Constants.API_DAY_TWO:
                postUrl=getEveryDayAp12();
                requestParams.put("filter", "isHomepage");
                requestParams.put("start", "0");
                requestParams.put("limit",values);
                get(postUrl,requestParams,asyncHttpResponseHandler);
                break;
            case Constants.API_Comumn_ONE:
                postUrl=getComumnApi1();
                requestParams.put("filter", "isFocus");
                requestParams.put("start", "0");
                requestParams.put("limit", "5");
                get(postUrl,requestParams,asyncHttpResponseHandler);
                break;

        }
        return postUrl;
    }

    public void request(Activity context, String action, String data, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        if (!NetWorkUtils.isNetworkAvailable(context)) {//如果网络请求失败，网络未连接
            showToast(context, "网络未连接，请检查网络");
        }
       /* String postUrl = DataHelper.getInstance().getStringByJSONWithKey(data, "url");
        String header = DataHelper.getInstance().getStringByJSONWithKey(data, "header");
        String redata = DataHelper.getInstance().getStringByJSONWithKey(data, "data");
        boolean haveCache = DataHelper.getInstance().getBooleanByJSONWithKey(data, "cache");
        double timeout = DataHelper.getInstance().getDoubleByJSONWithKey(data, "timeout");*/
        String postUrl = "";
        String header = "";
        String redata = "";
        boolean haveCache = true;
        double timeout = 1;
        DebugLog.e(postUrl);

        if (header != null) {
            try {
                JSONObject jsonObject = new JSONObject(header);
                Iterator<?> iterator = jsonObject.keys();// 应用迭代器Iterator 获取所有的key值
                while (iterator.hasNext()) { // 遍历每个key
                    String key = (String) iterator.next();
                    DebugLog.e("迭代的key" + key);
                    Object ob = jsonObject.get(key);
                    client.addHeader(key, String.valueOf(ob));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        RequestParams requestParams = new RequestParams();
        if (redata != null) {
            try {
                JSONObject jsonObject = new JSONObject(redata);
                Iterator<?> iterator = jsonObject.keys();// 应用迭代器Iterator 获取所有的key值
                while (iterator.hasNext()) { // 遍历每个key
                    String key = (String) iterator.next();
                    DebugLog.e("迭代的key" + key);
                    Object ob = jsonObject.get(key);
                    requestParams.put(key, String.valueOf(ob));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (action.equals("get")) {
            get(postUrl, requestParams, asyncHttpResponseHandler);
        } else if (action.equals("post")) {
            post(postUrl, requestParams, asyncHttpResponseHandler);
        } else if (action.equals("head")) {
            //client.addHeader("sessionId",values[0]);
            head(postUrl, requestParams, asyncHttpResponseHandler);
        }
    }

    public static void headManifest(String manifestUrl, RequestParams o, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        client.addHeader("User-Agent", Remember.getString(Constants.USERAGENT, ""));
        head(manifestUrl, o, asyncHttpResponseHandler);
    }


    private Toast toast;
    private long time = 0;

    public void showToast(Context context, final String text) {

        if (System.currentTimeMillis() - time < 10000) {
            return;
        } else {
            time = System.currentTimeMillis();
        }

        Log.e("Toast", text);
        if (toast == null) {
            toast = Toast.makeText(context, text,
                    Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();

    }
}