package so.inspire.springboot.repository;

import org.springframework.stereotype.Repository;

import com.inspireso.framework.jpa.repository.GenericRepository;

import so.inspire.springboot.domain.User;

/**
 * Created by Inspireso Tream
 */
@Repository
public interface UserRepository extends GenericRepository<User> {

    User findByCode(String code);
}
