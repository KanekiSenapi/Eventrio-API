package pl.aogiri.notifi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotifiService {

    @Autowired
    private NotifiRepository notifiRepository;

    boolean setNotifiSeen(Integer id){
        Notifi notifi = notifiRepository.findById(id).get();
        if(notifi==null)
            return false;
        notifi.setShowed(true);
        notifiRepository.save(notifi);
        return notifi.isShowed();
    }

    Notifi getNotifiById(Integer id){
        return notifiRepository.findById(id).get();
    }
}
