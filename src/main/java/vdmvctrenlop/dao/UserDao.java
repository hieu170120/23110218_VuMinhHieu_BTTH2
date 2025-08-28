package vdmvctrenlop.dao;

import vdmvctrenlop.model.User;

public interface UserDao {
    User get(String username);
    User login(String username, String password);
}
