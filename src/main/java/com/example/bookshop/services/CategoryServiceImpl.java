package com.example.bookshop.services;

import com.example.bookshop.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getRandomCategories() {
        Random random=new Random();
        long size=this.categoryRepository.count();
        int categoriesCount=(int)random.nextLong(size);
        Set<Integer> categoriesIds=new HashSet<>();
        for (int i=0;i<categoriesCount;i++){
            int nextId=(int)random.nextLong(size)+1;
            categoriesIds.add(nextId);
        }
        List<Category> allById=this.categoryRepository.findAllById(categoriesIds);
        return new HashSet<>(allById);
    }
}
