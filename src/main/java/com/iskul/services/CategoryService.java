package com.iskul.services;

import com.iskul.model.Category;

import java.util.List;

/**
 * Created by Sowrozit on 2/27/2017.
 */
public interface CategoryService {

    public void addCategory(Category category);

    public List<Category> getAllCategories();

    public void deleteCategory(Integer categoryId);

    public Category getCategory(int categoryid);

    public Category updateCategory(Category category);


}
