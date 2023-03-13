package com.example.Service;

import com.example.model.Users;

public interface LoginRepo {
    Users login(String email, String password);
}
