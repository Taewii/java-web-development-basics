package metube.util;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;

public class BeanCreator {

    @Produces
    ModelMapper createModelMapper() {
        return new ModelMapper();
    }
}
