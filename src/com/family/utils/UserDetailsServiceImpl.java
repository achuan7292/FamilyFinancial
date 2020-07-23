package com.family.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.family.service.UserService;

public class UserDetailsServiceImpl implements UserDetailsService {

	
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("������");
		try {
			username=new String(username.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//������ɫ�б�
		List<GrantedAuthority> grantedAuths = new ArrayList();
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
		/*com.family.domain.User user = userService.findById("002");*/
		com.family.domain.User user = userService.findOne(username);
		if (user != null) {
			return new User(username, user.getPassword(), grantedAuths);
		} else {

			return null;
		}
	}
	

}
