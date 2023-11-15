package com.player.player.repositories;

import com.player.player.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<User, Long> {
}
