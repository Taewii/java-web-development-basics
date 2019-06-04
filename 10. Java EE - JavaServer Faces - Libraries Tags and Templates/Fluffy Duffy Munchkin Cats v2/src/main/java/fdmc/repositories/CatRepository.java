package fdmc.repositories;

import fdmc.domain.entities.Cat;

import java.util.List;

public interface CatRepository {

    void save(Cat entity);

    List<Cat> findAll();
}
