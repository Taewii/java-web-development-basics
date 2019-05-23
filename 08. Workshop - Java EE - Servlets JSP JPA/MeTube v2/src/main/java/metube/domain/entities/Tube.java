package metube.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tubes")
public class Tube extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column
    private String description;

    @Column(name = "youtube_id", nullable = false)
    private String youtubeId;

    @Column
    private int views;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "uploader_id", referencedColumnName = "id")
    private User uploader;
}
