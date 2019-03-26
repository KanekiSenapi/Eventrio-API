package pl.aogiri.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepostiory extends CrudRepository<User, Integer> {

    List<User> findAll();
    User findByFbid(String fid);
}
