package com.refactor.code.kiss.principle.service;

import com.refactor.code.kiss.principle.model.User;
import com.refactor.code.kiss.principle.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id) throws Exception {
		return userRepository.findById(id).
				orElseThrow(() -> new Exception("user not found"));
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

}
