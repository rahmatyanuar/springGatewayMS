package com.rahmat.gateway.implementation;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.rahmat.gateway.model.User;
import com.rahmat.gateway.repo.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	UserRepository userRepo;
	
    @Autowired
    private WebApplicationContext applicationContext;
	
	 @PostConstruct
    public void completeSetup() {
		 userRepo = applicationContext.getBean(UserRepository.class);
    }
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user = userRepo.findByUsername(username).
				orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		return UserDetailsImpl.build(user);
	}
	
	public void updateToken(String username, String token, Date tokenExp) {
		try {
			User user = userRepo.findByUsername(username).
					orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
			user.setTokenExpiry(tokenExp);
			user.setToken(token);
//			userRepo.updateExpiredDate(tokenExp, username);
		} catch (Exception e) {
			// TODO: handle exception
			e.getCause();
		}
	}
}
