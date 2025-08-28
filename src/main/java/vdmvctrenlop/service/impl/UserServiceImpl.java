package vdmvctrenlop.service.impl;

import vdmvctrenlop.dao.UserDao;
import vdmvctrenlop.dao.impl.UserDaoImpl;
import vdmvctrenlop.model.User;
import vdmvctrenlop.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        // lấy user từ DB dựa vào username
        User user = this.get(username);
        // kiểm tra password
        if (user != null && password.equals(user.getPassWord())) {
            return user; // đúng mật khẩu
        }
        return null; // sai mật khẩu hoặc user không tồn tại
    }

    @Override
    public User get(String username) {
        return userDao.get(username); // gọi xuống DAO
    }
}
