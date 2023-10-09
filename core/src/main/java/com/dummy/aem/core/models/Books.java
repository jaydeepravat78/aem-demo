package com.dummy.aem.core.models;


import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Books {
    @ValueMapValue
    private String bookName;

    @ValueMapValue
    private String bookAuthor;


    @ValueMapValue
    private String publishYear;

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getPublishYear() {
        return publishYear;
    }
}
