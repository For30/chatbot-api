package com.xaiobao.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;


import javax.swing.text.html.parser.Entity;
import java.io.IOException;

public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/topics/412528458851528/comments?sort=asc&count=30&with_sticky=true");

        get.addHeader("cookie","sensorsdata2015jssdkcross={\"distinct_id\":\"187544034591d3-08ded9951ae6398-26031851-1327104-1875440345a283\",\"first_id\":\"\",\"props\":{\"$latest_traffic_source_type\":\"引荐流量\",\"$latest_search_keyword\":\"未取到值\",\"$latest_referrer\":\"https://www.code-nav.cn/\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3NTQ0MDM0NTkxZDMtMDhkZWQ5OTUxYWU2Mzk4LTI2MDMxODUxLTEzMjcxMDQtMTg3NTQ0MDM0NWEyODMifQ==\",\"history_login_id\":{\"name\":\"\",\"value\":\"\"},\"$device_id\":\"187544034591d3-08ded9951ae6398-26031851-1327104-1875440345a283\"}; zsxq_access_token=522E4153-658E-6821-70D6-8203F18F0700_0DB247FFA6E82F0F; zsxqsessionid=b38abf55e9b92acb4884533e4c4c77cf; abtest_env=product");
        get.addHeader("Content-Type","application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String s = EntityUtils.toString(response.getEntity());
            System.out.println(s);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        //首先创建了一个 CloseableHttpClient 对象 httpClient，该对象用于发送 HTTP 请求
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //创建了一个 HttpPsot 对象 post，该对象表示一个 post 请求
        HttpPost httpPost = new HttpPost("https://api.zsxq.com/v2/topics/412528458851528/comments");

        //接下来，使用 addHeader() 方法向请求头中添加了两个参数，分别为 cookie 和 Content-Type。其中 cookie 是知识星球个人的 cookie 信息，Content-Type 表示请求体的类型为 application/json; charset=UTF-8
        httpPost.addHeader("cookie","sensorsdata2015jssdkcross={\"distinct_id\":\"187544034591d3-08ded9951ae6398-26031851-1327104-1875440345a283\",\"first_id\":\"\",\"props\":{\"$latest_traffic_source_type\":\"引荐流量\",\"$latest_search_keyword\":\"未取到值\",\"$latest_referrer\":\"https://www.code-nav.cn/\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3NTQ0MDM0NTkxZDMtMDhkZWQ5OTUxYWU2Mzk4LTI2MDMxODUxLTEzMjcxMDQtMTg3NTQ0MDM0NWEyODMifQ==\",\"history_login_id\":{\"name\":\"\",\"value\":\"\"},\"$device_id\":\"187544034591d3-08ded9951ae6398-26031851-1327104-1875440345a283\"}; zsxq_access_token=522E4153-658E-6821-70D6-8203F18F0700_0DB247FFA6E82F0F; zsxqsessionid=b38abf55e9b92acb4884533e4c4c77cf; abtest_env=product");
        httpPost.addHeader("Content-Type","application/json; charset=UTF-8");

        //创建了一个字符串 paramJson，表示评论内容的 JSON 格式数据
        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"去问马云爸爸！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        //接着，将 paramJson 转换成 StringEntity 对象，并设置请求体的类型和编码格式为 "text/json" 和 "UTF-8"
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        //最后，将 StringEntity 设置到 HttpPost 对象中
        httpPost.setEntity(stringEntity);
        //然后，执行 httpClient 的 execute() 方法发送 HTTP 请求，并将返回结果封装在 CloseableHttpResponse 对象 response 中。
        CloseableHttpResponse response = httpClient.execute(httpPost);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String s = EntityUtils.toString(response.getEntity());
            System.out.println(s);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
}
