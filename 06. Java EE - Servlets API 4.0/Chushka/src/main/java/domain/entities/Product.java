package domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Product {

    private long id;
    private String name;
    private String description;
    private String type;

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
