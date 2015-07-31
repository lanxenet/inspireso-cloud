import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import com.inspireso.framework.util.Serializing;

import so.inspire.springboot.domain.User;
import so.inspireso.remoting.http.HttpSender;

/**
 * Created by Inspireso Tream
 */
public class UserControllerTests {

    private User user;

    @Before
    public void init() throws IOException {
        user = new User();
        user.setName("lanxe");
        user.setCode("lanxe");
        user.setAge(30);
        HttpSender.HttpResult result = HttpSender.post("http://localhost:1000/user", user, 0, 0);
        if (result.successful()) {
            user = Serializing.json().toObject(result.content, User.class);
        }
    }

//    @After
//    public void delete() throws IOException {
//        HttpSender.HttpResult result = HttpSender.delete("http://localhost:1000/user/" + user.getId(), Charsets.UTF_8, 0, 0);
//        System.out.print(result.toString());
//    }

    @Test
    public void testCreate() throws IOException {
        User user = new User();
        user.setName("lanxe");
        user.setCode("lanxe");
        user.setAge(30);
        HttpSender.HttpResult result = HttpSender.post("http://localhost:1000/user", user, 0, 0);
        System.out.print(result.toString());

        User userREsult = Serializing.json().toObject(result.content, User.class);
        System.out.print(userREsult.getCode());
    }


    @Test
    public void testGetById() throws IOException {
        HttpSender.HttpResult result = HttpSender.get("http://localhost:1000/user/" + user.getId(), Charsets.UTF_8, 0, 0);
        System.out.print(result.toString());
    }


    @Test
    public void testGetByCode() throws IOException {

//        Map<String, String> params = Maps.newHashMap();
//        params.put("code", user.getCode());
//        HttpSender.HttpResult result = HttpSender.get("http://localhost:1000/user",
//                params Charsets.UTF_8, 0, 0);

        HttpSender.HttpResult result = HttpSender.get("http://localhost:1000/user",
                ImmutableMap.of("code", user.getCode()), Charsets.UTF_8, 0, 0);
        System.out.print(result.toString());
    }

    @Test
    public void update() throws IOException {

//        Map<String, String> params = Maps.newHashMap();
//        params.put("code", user.getCode());
//        HttpSender.HttpResult result = HttpSender.get("http://localhost:1000/user",
//                params Charsets.UTF_8, 0, 0);
        user.setAge(31);
        HttpSender.HttpResult result = HttpSender.put("http://localhost:1000/user",
                user, 0, 0);
        System.out.print(result.toString());
    }


}
