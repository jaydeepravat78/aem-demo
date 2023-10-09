package com.dummy.aem.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.Date;
import java.util.List;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Book {

    @ValueMapValue
    private String bookName;

    @ValueMapValue
    private Date publishYear;


    @ChildResource
    private List<Edition> bookeditons;

    public String getBookName() {
        return bookName;
    }

    public Date getPublishYear() {
        return publishYear;
    }

    public List<Edition> getBookeditons() {
        return bookeditons;
    }
}
