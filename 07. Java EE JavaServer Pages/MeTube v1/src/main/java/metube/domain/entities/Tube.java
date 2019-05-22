package metube.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "tubes")
@Table(name = "tubes")
@NamedQueries({
        @NamedQuery(name = "Tube.findAll", query = "SELECT t FROM tubes t"),
        @NamedQuery(name = "Tube.findByTitle", query = "SELECT t FROM tubes t WHERE t.title = :title")
})
public class Tube extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String youtubeLink;

    @Column(nullable = false)
    private String uploader;
}
