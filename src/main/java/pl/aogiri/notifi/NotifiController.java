package pl.aogiri.notifi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class NotifiController {

    @Autowired
    NotifiService notifiService;

    @RequestMapping(value = "users/notifi/{nid}/seen", method = RequestMethod.POST)
    @ResponseBody
    private void setNotifisSeen(@PathVariable Integer nid, HttpServletResponse response){
        if(notifiService.setNotifiSeen(nid))
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        else
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
