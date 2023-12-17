package com.player.player.services.servicesImp;

import com.player.player.entities.User;
import com.player.player.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserDetailsService {

    private final UserRepository userRepository;

    public void register(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        user.setEmail(user.getEmail());
        user.setNickname(user.getNickname());
        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid email or password");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}