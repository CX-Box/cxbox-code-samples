package org.demo.conf.cxbox.customization.role;

import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.CxboxUserDetails;
import org.cxbox.api.service.session.CxboxUserDetailsInterface;
import org.demo.conf.cxbox.meta.User;
import org.demo.conf.cxbox.meta.User_;
import org.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User getUserByLogin(String login) {
		return userRepository.findOne(
				(root, cq, cb) -> cb.equal(cb.upper(root.get(User_.login)), login.toUpperCase())
		).orElse(null);
	}

	public CxboxUserDetailsInterface createUserDetails(final User user, final String userRole) {
		return CxboxUserDetails.builder()
				.id(user.getId())
				.departmentId(user.getDepartmentId())
				.userRole(userRole)
				.authorities(Collections.emptySet())
				.build();
	}

}
