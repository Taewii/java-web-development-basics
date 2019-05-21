package metube.domain.entities;

import javax.persistence.*;

@Entity(name = "tubes")
@Table(name = "tubes")
public class Tube extends BaseEntity {

    private String title;
    private String description;
    private String youtubeLink;
    private String uploader;

    public Tube() {
    }

    @Column(nullable = false)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    @Column
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column
    public String getYoutubeLink() {
        return this.youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    @Column
    public String getUploader() {
        return this.uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}
