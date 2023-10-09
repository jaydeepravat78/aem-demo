package com.dummy.aem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.Date;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Edition {

    @ValueMapValue
    private Date editondate;
    @ValueMapValue
    private int bookediton;

    public Date getEditondate() {
        return editondate;
    }

    public int getBookediton() {
        return bookediton;
    }
}
