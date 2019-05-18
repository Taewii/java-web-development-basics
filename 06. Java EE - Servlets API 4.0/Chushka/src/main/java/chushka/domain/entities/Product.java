package chushka.domain.entities;

import chushka.domain.entities.enums.Type;
import chushka.domain.entities.enums.TypeConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String name;
    private String description;
    private Type type;

    public Product() {
    }

    public Product(String name, String description, Type type) {
        this.name = name;
        this.description = description;
        this.type = type;
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
    @Convert(converter = TypeConverter.class)
    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
