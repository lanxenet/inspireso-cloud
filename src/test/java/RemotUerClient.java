import java.io.IOException;

import com.google.common.base.Optional;

import so.inspire.micservice.domain.User;
import so.inspireso.remoting.client.RemotingClient;

/**
 * Created by Inspireso Tream
 */
public class RemotUerClient extends RemotingClient {
    protected RemotUerClient(String address) {
        super(address);
    }

    public Optional<User> get(String code) throws IOException {
        return super.execute(User.class, httpGet(), "user");

    }

    public Optional<User> create(User user) throws IOException {
        return super.execute(User.class, httpPost(user), "user");

    }

}
