package com.example.libraryManagementProject.Util;

import com.example.libraryManagementProject.DataAccessLayer.User;

public class UserValidator {

    public static boolean isValidUser(User user){

        if(user.getEmail() == null || user.getEmail() == "")
            return false;
        else return true;
    }
}
