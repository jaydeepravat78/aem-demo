/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.dummy.aem.core.models;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.adobe.cq.wcm.core.components.models.Page;
import com.adobe.xfa.ut.StringUtils;
import com.dummy.aem.core.config.OsgiConfigDemo;
import com.dummy.aem.core.services.DemoService;
import com.dummy.aem.core.services.DemoService2;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.*;

import com.day.cq.wcm.api.PageManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Model(adaptables = SlingHttpServletRequest.class,
        resourceType = HelloWorldModel.RESOURCE_TYPE,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson", extensions = "json", selector = "hello",
        options = {
        @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value = "true")
        })
@JsonRootName("details")
public class HelloWorldModel {

    static final String RESOURCE_TYPE = "dummy/components/helloworld";

    @ValueMapValue(name=PROPERTY_RESOURCE_TYPE)
    @Default(values="No resourceType")
    protected String resourceType;

    @SlingObject
    private Resource currentResource;
    @SlingObject
    private ResourceResolver resourceResolver;


    @OSGiService
    private DemoService2 demoService;

    @OSGiService
    private OsgiConfigDemo oserviceConfig;

    @RequestAttribute(name = "requestAttribute")
    private String requestAttribute;


    @ValueMapValue(injectionStrategy = InjectionStrategy.REQUIRED)
    List<String> bookName;

//    @Self
//    private Resource resource;
//
    @ChildResource
    private List<Books> bookdetailswithmap;



    @ChildResource
    private List<Book> nestedbookdetailswithmap;


//
//    @ScriptVariable
//    private Page page;

    @ValueMapValue
    private String title;




    @ValueMapValue
    private String text;
    private String message;

    @PostConstruct
    protected void init() {
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        String currentPagePath = Optional.ofNullable(pageManager)
                .map(pm -> pm.getContainingPage(currentResource))
                .map(com.day.cq.wcm.api.Page::getPath).orElse("");
        String currentPage2 = null;

        if (demoService != null) {
            currentPage2 = demoService.getCurrentPage();
        }

        message = "Hello World!\n"
            + "Resource type is: " + resourceType + "\n"
            + "Current page is:  " + currentPage2 + "\n"
            + "OSGI " + oserviceConfig.getServiceName();
        ;
    }

    public String getTitle() {
        if(null == title)
            return "Please enter a title";
        return title;
    }

    public String getText() {
        return !StringUtils.isEmpty(text)  ? text : "NULL";
    }

    public String getMessage() {
        return message;
    }



    @JsonProperty(value = "bookNames")
    public List<String> getBooks() {
        if(null == bookName) {
            return Collections.emptyList();
        }
        return bookName;
    }

    @JsonProperty(value = "bookDetails")
    public List<Books> getBooks2() {
        if(null == bookdetailswithmap) {
            return Collections.emptyList();
        }
        return bookdetailswithmap;
    }

    @JsonProperty(value = "bookDetailsWithNested")
    public List<Book> getBooks3() {
        if(null == nestedbookdetailswithmap) {
            return Collections.emptyList();
        }
        return nestedbookdetailswithmap;
    }

//    public String getPage() {
//        return page.getTitle();
//    }

}
