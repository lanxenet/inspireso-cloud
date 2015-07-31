package so.inspire.micservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.inspireso.framework.service.BusinessService;

import so.inspire.micservice.domain.User;
import so.inspire.micservice.repository.UserRepository;

/**
 * Created by Inspireso Tream
 */
@Service
public class UserService extends BusinessService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User find(String id) {
        return this.userRepository.findOne(id);
    }

    public User findByCode(String code) {
        return this.userRepository.findByCode(code);
    }

    public void delete(String id) {
        this.userRepository.delete(id);
    }

    public Page<User> findAll(int start, int limit) {
        return this.userRepository.findAll(new PageRequest(start, limit));
    }
}
