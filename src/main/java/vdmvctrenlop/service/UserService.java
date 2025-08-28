package vdmvctrenlop.service;

import vdmvctrenlop.model.User;

public interface UserService {
    User login(String username, String password);
    User get(String username);
}
