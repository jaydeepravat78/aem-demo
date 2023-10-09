package com.dummy.aem.core.services.impl;


import com.day.cq.wcm.api.PageManager;
import com.dummy.aem.core.services.DemoService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Component(service = DemoService.class)
public class DemoServiceImpl implements DemoService {

    private static final Logger log = LoggerFactory.getLogger(DemoServiceImpl.class);

    @SlingObject
    private Resource currentResource;

    @SlingObject
    private ResourceResolver resourceResolver;

    @Override
    public String getCurrentPagePath() {
//        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
//        return Optional.ofNullable(pageManager)
//                .map(pm -> pm.getContainingPage(currentResource))
//                .map(com.day.cq.wcm.api.Page::getPath).orElse("");
        return "current Page";
    }

    @Activate
    protected void activate() {
        log.info("Activating");
    }

    @Deactivate
    protected void deactivate() {
        log.info("Deactivating");
    }


}
