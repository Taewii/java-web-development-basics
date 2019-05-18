package chushka.util;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;

public class Beans {

//    @Produces
//    EntityManager createEntityManager() {
//        return Persistence
//                .createEntityManagerFactory("chushka_db")
//                .createEntityManager();
//    }

    @Produces
    ModelMapper createModelMapper() {
        return new ModelMapper();
    }
}
