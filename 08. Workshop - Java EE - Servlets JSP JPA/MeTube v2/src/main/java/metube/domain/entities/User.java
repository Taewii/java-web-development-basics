package metube.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(
            mappedBy = "uploader",
            targetEntity = Tube.class,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER) // TODO: 24.5.2019 г. has to be lazy. figure it out
    private List<Tube> tubes = new ArrayList<>();

    public void addTube(Tube tube) {
        tube.setUploader(this);
        this.tubes.add(tube);
    }

    public void removeTube(Tube tube) {
        this.tubes.remove(tube);
        tube.setUploader(null);
    }
}
