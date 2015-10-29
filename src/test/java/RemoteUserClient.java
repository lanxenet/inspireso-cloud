import java.io.IOException;
import java.util.Map;

import com.google.common.base.Optional;

import so.inspire.micservice.domain.User;
import so.inspireso.remoting.client.RemotingClient;

/**
 * Created by Inspireso Tream
 */
public class RemoteUserClient extends RemotingClient {
    protected RemoteUserClient(String address) {
        super(address);
    }

    public Optional<Map> emptyMap() throws IOException {
        return super.execute(Map.class, httpGet(), "test/emptymap");

    }

    public Optional<User> get(String code) throws IOException {
        return super.execute(User.class, httpGet(), "user");

    }

    public Optional<User> create(User user) throws IOException {
        return super.execute(User.class, httpPost(user), "user");

    }

}
