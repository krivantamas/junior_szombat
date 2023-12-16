package org.webler.zsolt.blog.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.webler.zsolt.blog.model.User;

public interface IUserService extends UserDetailsService {

    User findByUserName(String userName) throws UsernameNotFoundException;

}
