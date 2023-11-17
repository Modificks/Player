package com.player.player.repositories;

import com.player.player.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    User findByNickname(String nickname);

    User findByPassword(String password);
}