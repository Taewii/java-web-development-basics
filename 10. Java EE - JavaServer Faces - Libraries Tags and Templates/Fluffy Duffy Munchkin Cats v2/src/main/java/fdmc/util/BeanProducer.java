package fdmc.util;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;

public class BeanProducer {

    @Produces
    ModelMapper createModelMapper() {
        return new ModelMapper();
    }
}
