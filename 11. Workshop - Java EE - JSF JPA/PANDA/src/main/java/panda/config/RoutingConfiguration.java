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
                .addRule(Join.path("/register").to("/faces/views/user/register.xhtml"))
                .addRule(Join.path("/login").to("/faces/views/user/login.xhtml"))
                .addRule(Join.path("/packages/create").to("/faces/views/packets/create-package.xhtml"))
                .addRule(Join.path("/packages/details").to("/faces/views/packets/details-package.xhtml"))
                .addRule(Join.path("/packages/pending").to("/faces/views/packets/pending-packages.xhtml"))
                .addRule(Join.path("/packages/shipped").to("/faces/views/packets/shipped-packages.xhtml"))
                .addRule(Join.path("/packages/delivered").to("/faces/views/packets/delivered-packages.xhtml"))
                .addRule(Join.path("/receipts").to("/faces/views/receipts/receipts.xhtml"))
                .addRule(Join.path("/receipt").to("/faces/views/receipts/details-receipt.xhtml"));
    }

    @Override
    public int priority() {
        return 10;
    }
}
