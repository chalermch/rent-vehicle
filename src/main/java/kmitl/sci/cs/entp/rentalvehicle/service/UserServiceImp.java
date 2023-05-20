package kmitl.sci.cs.entp.rentalvehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kmitl.sci.cs.entp.rentalvehicle.model.PatchUserRequest;
import kmitl.sci.cs.entp.rentalvehicle.model.User;
import kmitl.sci.cs.entp.rentalvehicle.repository.UserRepository;


@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository repo;
	@Override
	public List<User> getUsers() {
		
		return repo.findAll();
	}

	@Override
	public User getUser(long userId) {
		
		return repo.findByUserId(userId);
	}

	@Override
	public void create(User user) {
		repo.save(user);
	}

	@Override
	public void delete(long userId) {
        repo.deleteByUserId(userId);
    }

	@Override
	public void update(User user, PatchUserRequest request) {
		updateUser(user, request);
		repo.save(user);
		
	}

	public void updateUser(User user, PatchUserRequest request) {
        if (request.getFirstname() != null) {
            user.setFirstName(request.getFirstname());
        }
        if (request.getLastname() != null) {
            user.setLastName(request.getLastname());
        }
        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }
		
	}

	@Override
	public User getUserByFirstName(String firstName) {
		return repo.findByFirstName(firstName);
	}


}

