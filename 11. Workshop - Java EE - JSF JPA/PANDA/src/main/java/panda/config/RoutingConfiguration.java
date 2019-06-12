package panda.config;

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
                .addRule(Join.path("/register").to("/faces/views/register.xhtml"))
                .addRule(Join.path("/login").to("/faces/views/login.xhtml"))
                .addRule(Join.path("/packages/create").to("/faces/views/create-package.xhtml"))
                .addRule(Join.path("/packages/details").to("/faces/views/details-package.xhtml"));
    }

    @Override
    public int priority() {
        return 10;
    }
}
