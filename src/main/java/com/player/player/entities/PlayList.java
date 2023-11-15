package com.player.player.entities;

import com.player.player.enums.PlayListType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "play_lists")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private PlayListType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "playList", fetch = FetchType.EAGER)
    private PlayListsMusic playListsMusic;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayList playList)) return false;
        return Objects.equals(getId(), playList.getId()) && getType() == playList.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType());
    }
}