package hu.neuron.java.project.online;

import hu.neuron.java.project.core.UserService;
import hu.neuron.java.project.core.vo.RoleVO;
import hu.neuron.java.project.core.vo.UserVO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {

		UserVO user; 
		try {
			user = userService.findUserAndRolesByName(username);

			List<GrantedAuthority> authorities = buildUserAuthority(user
					.getRoles());

			return buildUserForAuthentication(user, authorities);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(e.getMessage());
		}
	}

	private User buildUserForAuthentication(UserVO user,
			List<GrantedAuthority> authorities) {
		return new User(user.getUserName(), user.getPassword(), true, true,
				true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<RoleVO> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (RoleVO userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				setAuths);

		return Result;
	}

}