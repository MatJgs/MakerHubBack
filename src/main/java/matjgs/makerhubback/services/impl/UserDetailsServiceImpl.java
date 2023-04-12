package matjgs.makerhubback.services.impl;

import matjgs.makerhubback.repository.UtilisateurRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UtilisateurRepository utilisateurRepository;

    public UserDetailsServiceImpl(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository=utilisateurRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
        return utilisateurRepository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("username not found"));
    }
}
