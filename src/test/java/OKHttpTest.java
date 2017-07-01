import okhttp3.*;
import org.junit.Test;

import java.io.IOException;

/**
 * @author loufeng
 * @date 2017/5/20 下午10:20.
 * 听说超好用的http三方包
 */
public class OKHttpTest {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @Test
    public void test() throws IOException {
        String result = get("http://wx.souche.com/api/wechathousekeeperapi/getAuthUrl.json");
        System.out.println(result);
    }

}
