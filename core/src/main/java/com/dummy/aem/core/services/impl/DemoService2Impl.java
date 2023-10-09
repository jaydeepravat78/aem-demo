package com.dummy.aem.core.services.impl;

import com.dummy.aem.core.services.DemoService;
import com.dummy.aem.core.services.DemoService2;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(service = DemoService2.class)
public class DemoService2Impl implements DemoService2 {

    @Reference
    DemoService demoService;

    @Override
    public String getCurrentPage() {
        return demoService.getCurrentPagePath();
    }
}
