package employeeregister.util;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;

public class BeanCreator {

    @Produces
    public ModelMapper createModelMapper() {
        return new ModelMapper();
    }
}
