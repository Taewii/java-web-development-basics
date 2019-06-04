package fdmc.util;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

import javax.servlet.ServletContext;

@RewriteConfiguration
public class RoutingConfiguration extends HttpConfigurationProvider {

    @Override
    public Configuration getConfiguration(ServletContext context) {
        return ConfigurationBuilder.begin()
                .addRule(Join.path("/").to("/faces/views/index.xhtml"))
                .addRule(Join.path("/create").to("/faces/views/create-cat.xhtml"))
                .addRule(Join.path("/all").to("/faces/views/all-cats.xhtml"));
    }

    @Override
    public int priority() {
        return 10;
    }
}
