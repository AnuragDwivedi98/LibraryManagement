package com.example.libraryManagementProject.Util;

import com.example.libraryManagementProject.DataAccessLayer.Book;

public class BookValidator {
    public boolean isValid(Book book){

        if(book.getTitle() == "" || book.getTitle() == null)
            return false;
        return true;

    }
}

