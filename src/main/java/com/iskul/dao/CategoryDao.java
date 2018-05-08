package com.iskul.dao;


import com.iskul.model.Category;
import com.iskul.model.Subject;


import java.util.List;

/**
 * Created by Sowrozit on 2/27/2017.
 */
public interface CategoryDao {

    public void addCategory(Category category);

    public List<Category> getAllCategories();

    public List<Subject> showAllSubjectsByCategory();

    public void deleteCategory(Integer categoryId);

    public Category updateCategory(Category category);

    public Category getCategory(int categoryid);
}
