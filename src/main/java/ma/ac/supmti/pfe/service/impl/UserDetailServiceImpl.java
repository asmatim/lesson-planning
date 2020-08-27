package ma.ac.supmti.pfe.service.impl;

import ma.ac.supmti.pfe.model.ModeratorModel;
import ma.ac.supmti.pfe.service.ModeratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private ModeratorService moderatorService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ModeratorModel moderatorModel = moderatorService.getModerator(username);
        if(Objects.nonNull(moderatorModel)) {
            UserDetails userDetails = User.withDefaultPasswordEncoder().username(moderatorModel.getUsername()).password(moderatorModel.getPassword()).roles("MODERATOR").build();
            return userDetails;
        }
        throw new UsernameNotFoundException(username);
    }

}
