package exodia.config;

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
                .addRule(Join.path("/register").to("/faces/views/user/register.xhtml"))
                .addRule(Join.path("/login").to("/faces/views/user/login.xhtml"));
    }

    @Override
    public int priority() {
        return 10;
    }
}
