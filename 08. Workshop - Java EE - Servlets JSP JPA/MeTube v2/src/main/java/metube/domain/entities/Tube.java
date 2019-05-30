package metube.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import metube.domain.enums.TubeStatus;

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
    private long views;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "uploader_id", referencedColumnName = "id")
    private User uploader;

    @Column
    @Enumerated(EnumType.STRING)
    private TubeStatus status;

    public void incrementViews() {
        this.views++;
    }

    public void changeStatus(TubeStatus status) {
        if (status != null) {
            this.status = status;
        }
    }
}
