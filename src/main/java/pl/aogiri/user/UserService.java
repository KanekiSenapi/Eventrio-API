package pl.aogiri.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepostiory userRepostiory;

    List<User> getAll(){
        return userRepostiory.findAll();
    }

    Optional<User> getUserById(Integer id){
        return userRepostiory.findById(id);
    }

    User getUserByFbid(String fbid){
        return userRepostiory.findByFbid(fbid);
    }

    User createUserByUserFB(UserFB userFB){
        User user = new User();
        user.setPseudonym(userFB.getName());
        user.setEmail(userFB.getEmail());
        user.setFbid(userFB.getId());
        user.setPicture(userFB.getPicture().getData().getUrl());
        userRepostiory.save(user);
        return user;
    }


}
