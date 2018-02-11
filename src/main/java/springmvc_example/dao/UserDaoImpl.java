package springmvc_example.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import springmvc_example.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	private static final String COLLECTION_NAME = "user";
	
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return this.mongoTemplate.findAll(User.class, COLLECTION_NAME);
	}

	public void add(User user) {
		// TODO Auto-generated method stub
		if(!this.mongoTemplate.collectionExists(User.class)){
			this.mongoTemplate.createCollection(User.class);
		}
		user.setId(UUID.randomUUID().toString());
		this.mongoTemplate.insert(user, COLLECTION_NAME);
	}

	public void update(User user) {
		this.mongoTemplate.save(user);

	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		this.mongoTemplate.remove(user, COLLECTION_NAME);
	}

	public User findUserById(String id) {
		// TODO Auto-generated method stub
		return this.mongoTemplate.findById(id, User.class);
	}

}
