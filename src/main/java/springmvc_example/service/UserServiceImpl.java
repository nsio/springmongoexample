package springmvc_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_example.dao.UserDao;
import springmvc_example.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return this.userDao.listUser();
	}

	public void add(User user) {
		// TODO Auto-generated method stub
		this.userDao.add(user);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		this.userDao.update(user);
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		this.userDao.delete(user);
	}

	public User findUserById(String id) {
		// TODO Auto-generated method stub
		return this.userDao.findUserById(id);
	}

}
