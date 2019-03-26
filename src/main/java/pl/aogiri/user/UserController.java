package pl.aogiri.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    @ResponseBody private List<User> getUsers(){
        return userService.getAll();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @ResponseBody private User getUser(@PathVariable Integer id, HttpServletResponse response){
        User user = userService.getUserById(id).get();
        if(user==null)
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        return user;
    }

    @RequestMapping(path = "fb/{fbid}", method = RequestMethod.GET)
    @ResponseBody private User getUserByFbid(@PathVariable String fbid, HttpServletResponse response){
        User user = userService.getUserByFbid(fbid);
        if(user==null)
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        return user;
    }

    @RequestMapping(path = "fb/create", method = RequestMethod.POST)
    @ResponseBody private User createUserByFb(@RequestBody UserFB userFB, HttpServletResponse response){
        System.out.println(userFB.getPicture().toString());
        User user = userService.createUserByUserFB(userFB);
        if(user.getId()==null)
            response.setStatus(HttpServletResponse.SC_GONE);
        else
            response.setStatus(HttpServletResponse.SC_CREATED);
        return user;

    }

}
