package com.player.player.services.servicesImp;

import com.player.player.entities.User;
import com.player.player.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp {

    private final PostRepository postRepository;

    @Autowired
    public UserServiceImp(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void register(User user) {
        user.setEmail(user.getEmail());
        user.setNickname(user.getNickname());
        user.setPassword(user.getPassword());

        postRepository.save(user);
    }

    public User findByEmail(String email) {
        return postRepository.findByEmail(email);
    }

    public User findByNickname(String nickname) {
        return postRepository.findByNickname(nickname);
    }

    public User findByEmailAndPassword(String email, String password) {
        return postRepository.findByEmailAndPassword(email, password);
    }
}