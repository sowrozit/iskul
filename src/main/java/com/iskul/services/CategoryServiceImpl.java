package com.iskul.services;

import com.iskul.dao.CategoryDao;
import com.iskul.dao.UserDao;
import com.iskul.model.Category;
import com.iskul.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sowrozit on 2/27/2017.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public void addCategory(Category category)
    {
        categoryDao.addCategory(category);
    }

    @Override
    @Transactional
    public List<Category> getAllCategories()
    {
        return categoryDao.getAllCategories();
    }

    @Override
    @Transactional
    public void deleteCategory(Integer categoryId)
    {
        categoryDao.deleteCategory(categoryId);
    }

    public Category getCategory(int ctgid)
    {
        return categoryDao.getCategory(ctgid);
    }

    public Category updateCategory(Category category)
    {
        return categoryDao.updateCategory(category);
    }

    public void setCategoryDao(CategoryDao categoryDao)
    {
        this.categoryDao = categoryDao;
    }
}
