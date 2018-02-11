package springmvc_example.service;

import java.util.List;

import springmvc_example.model.User;

public interface UserService {

	public List<User> listUser();
	public void add(User user);
	public void update(User user);
	public void delete(User user);
	public User findUserById(String id);
	
}
