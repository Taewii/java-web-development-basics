package chushka.util;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;

public class Beans {

    @Produces
    ModelMapper createModelMapper() {
        return new ModelMapper();
    }
}
