package kmitl.sci.cs.entp.rentalvehicle.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kmitl.sci.cs.entp.rentalvehicle.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserId(long id);
	void deleteByUserId(long id);
	User findByFirstName(String firstName);
	/*
	private List<User> users;

	public UserRepository() {
		this.users = new ArrayList<>();
		users.add(new User("John", "Henry", "john@gmail.com"));
		users.add(new User("Marry", "Watson", "merry@gmail.com"));
		users.add(new User("Clark", "Kent", "clark@gmil.com"));
	}
	
	public List<User> getUsers(){
		return users;
	}
	
	public void save(User user) {
		this.users.add(user);
	}
	
	public void update(int userId, User user) {
		this.users.set(userId, user);
	}
	
	public void delete(int userId) {
        this.users.remove(userId);
       
    }*/
}