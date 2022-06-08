package com.example.demo.service;
import com.example.demo.domain.LoginForm;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUserList() {
		return userRepository.findAll();
	}

	@Override
	public User findUserById(long id) {
		return userRepository.findById(id);
	}

	@Override
	public User findUserByLogId(String logid) {
		return userRepository.findbylogid(logid);
	}
	
	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void edit(User user) {
		userRepository.save(user);
	}

	@Override
	public void delete(long id) {
		userRepository.deleteById(id);
	}
	
	@Override
	public Boolean login(LoginForm loginform) {
		User user = userRepository.findbylogid(loginform.getLogid());
		String userPw = user.getUserPw();
		if(userPw.equals(loginform.getPassword())) {
			return true;
		}
		else return false;
	}
	
	@Override
	public Boolean loginAdmin(LoginForm loginform) {
		User user = userRepository.findbylogid(loginform.getLogid());
		String userPw = user.getUserPw();
		if(userPw.equals(loginform.getPassword()) && user.getUserRole().equals("ROLE_ADMIN")) {
			return true;
		}
		else return false;
	}
}