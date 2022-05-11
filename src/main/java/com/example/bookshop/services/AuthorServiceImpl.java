package com.example.bookshop.services;

import com.example.bookshop.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getRandomAuthor() {

        long size=this.authorRepository.count();
        int authorID=(int)new Random().nextLong(size)+1;
        return this.authorRepository.getById(authorID);
    }


}
