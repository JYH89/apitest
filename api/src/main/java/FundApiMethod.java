import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by zhoulei17344 on 2019-4-25.
 */
public class FundApiMethod {
    @Test
    public static JSONObject loginInterface() throws IOException {
        HttpClient client=new DefaultHttpClient ();
        HttpPost post=new HttpPost ("http://10.139.102.123:9064/fundapi/restful/integrate/login");
        //添加参数
        JSONObject param = new JSONObject();
        param.put("certificatetype","0");
        param.put("channel","1");
        param.put("custname","0");
        param.put("format","1");
        param.put("function","0");
        param.put("lognumber","1");
        param.put("logtype","0");
        param.put("merid","1");
        param.put("password","0");
        param.put("signmode","1");
        param.put("version","0");
        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象来进行响应结果的存储
        String result;
        //执行post方法
        HttpResponse response = client.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        JSONObject resultJson = new JSONObject(result);
        return resultJson;
    }
}
