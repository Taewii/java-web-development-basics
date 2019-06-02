package employeeregister.util;

import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class BeanCreator {

    @Produces
    @ApplicationScoped
    public ModelMapper createModelMapper() {
        return new ModelMapper();
    }
}
