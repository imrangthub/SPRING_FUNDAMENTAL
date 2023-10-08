package com.imranmadbar.domain.response.categories;

import lombok.ToString;

import java.util.List;


@ToString
public class CategoryResponse {
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }


}
