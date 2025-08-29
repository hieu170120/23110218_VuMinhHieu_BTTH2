package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import service.UserService;

public class UserImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User user = userDao.get(username);
        if (user != null && password.equals(user.getPassWord())) {
            return user;
        }
        return null;
    }
    
    @Override
    public User get(String username) {
        return userDao.get(username);
    }

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}
}