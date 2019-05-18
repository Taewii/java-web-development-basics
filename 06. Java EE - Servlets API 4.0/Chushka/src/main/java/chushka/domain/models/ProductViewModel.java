package chushka.domain.models;

import chushka.domain.entities.enums.Type;

public class ProductViewModel {

    private String name;
    private String description;
    private Type type;

    public ProductViewModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
