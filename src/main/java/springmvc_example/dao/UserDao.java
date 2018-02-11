package springmvc_example.dao;

import java.util.List;

import springmvc_example.model.User;

public interface UserDao {

	public List<User> listUser();
	public void add(User user);
	public void update(User user);
	public void delete(User user);
	public User findUserById(String id);
	
}
