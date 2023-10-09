package com.dummy.aem.core.config.impl;

import com.dummy.aem.core.config.OsgiConfigDemo;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(immediate = true, service = OsgiConfigDemo.class)
@Designate(ocd = OsgiConfigDemoImpl.ServiceConfig.class)
public class OsgiConfigDemoImpl implements OsgiConfigDemo {
    @ObjectClassDefinition(name = "Demo Service Configuration Practice",
        description = "The service configuration"
    )
    public @interface ServiceConfig {
        @AttributeDefinition(
                name = "Service Name",
                description = "The service configuration",
                type = AttributeType.STRING
        )
        String getServiceName() default "default";

        @AttributeDefinition(
                name = "Service Name2",
                description = "The service configuration",
                type = AttributeType.STRING
        )
        String getServiceName2() default "default";
    }
    private String serviceName;

    @Activate
    @Modified
    protected void activate(ServiceConfig config) {
        serviceName = config.getServiceName();
    }
    @Override
    public String getServiceName() {
        return serviceName;
    }
}
