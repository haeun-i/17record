package com.example.demo.service;
import com.example.demo.domain.LoginForm;
import com.example.demo.domain.User;
import java.util.List;

public interface UserService {
	public List<User> getUserList();
	public User findUserById(long id);
	public void save(User user);
	public void edit(User user);
	public void delete(long id);
	public Boolean login(LoginForm loginform);
	public Boolean loginAdmin(LoginForm loginform);
}