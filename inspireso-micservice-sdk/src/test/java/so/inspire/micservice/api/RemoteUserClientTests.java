package so.inspire.micservice.api;

import java.io.IOException;

import org.junit.Test;

import com.google.common.base.Charsets;

import so.inspireso.remoting.http.HttpSender;

/**
 * Created by Inspireso Tream
 */
public class RemoteUserClientTests {

    private RemoteUserClient client = new RemoteUserClient("http://localhost:1000");

    @Test
    public void testEmptyMap() throws IOException {
        HttpSender.HttpResult result = HttpSender.get("http://192.168.8.92:85/api/ass/getDeclarationAsMap/" , Charsets.UTF_8, 0, 0);

//        Optional<Map> result = client.emptyMap();
        System.out.println(result);
    }
}
