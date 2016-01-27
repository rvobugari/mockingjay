package com.npixels.mockingjay;

import com.npixels.mockingjay.config.MockingjayConfiguration;
import com.npixels.mockingjay.resources.MockingjayResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.springframework.beans.BeansException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.github.nhuray.dropwizard.spring.SpringBundle;



public class MockingjayApp extends Application<MockingjayConfiguration> {

    public static void main(String[] args) throws Exception {
        new MockingjayApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<MockingjayConfiguration> bootstrap) {
      bootstrap.addBundle(new SpringBundle<MockingjayConfiguration>(applicationContext(), true, true, true));
    }

    @Override
    public void run(MockingjayConfiguration configuration, Environment environment) {

    }


    private ConfigurableApplicationContext applicationContext() throws BeansException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.npixels");
        return context;
    }

}