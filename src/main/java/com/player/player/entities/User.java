package com.player.player.entities;

import com.player.player.annotations.Domain;
import com.player.player.annotations.Nickname;
import com.player.player.annotations.Password;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    @NotEmpty(message = "This field can not be empty")
    @Email(message = "Invalid email. " +
            "For example: dimanakonechnui7@gmail.com")
    @Domain(message = "Invalid domain(it can`t contain .ru)")
    private String email;

    @Column(name = "nickname")
    @NotEmpty(message = "This field can not be empty")
    @Nickname(message = "Invalid nickname." +
            "It should contains up to 15 symbols")
    private String nickname;

    @Column(name = "password", columnDefinition = "TEXT")
    @NotEmpty(message = "This field can not be empty")
    @Password(message = "Invalid password " +
            "It should contains at least one small and one big character," +
            "one digit and special symbol. " +
            "And contains at least 6 symbols")
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<PlayList> playList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getNickname(), user.getNickname()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getNickname(), getPassword());
    }
}