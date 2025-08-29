package dao.impl;

import model.User;
import java.sql.*;

import dao.DatabaseConnect;
import dao.UserDao;

public class UserDaoImpl implements UserDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public UserDaoImpl() {
        try {
            conn = new DatabaseConnect().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User get(String username) {
        String sql = "SELECT * FROM [User] WHERE username = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassWord(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFullName(rs.getString("fullname"));
                user.setPhone(rs.getString("phone"));
                user.setAvatar(rs.getString("avatar"));
                user.setRoleId(rs.getInt("roleid"));
                user.setCreatedDate(rs.getDate("createdDate"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO [User] (userName, passWord, email, phone, fullname, roleid, createdDate) "
                   + "VALUES (?, ?, ?, ?, ?, ?, GETDATE())";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassWord());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getFullName());
            ps.setInt(6, user.getRoleId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkExistEmail(String email) {
        String sql = "SELECT 1 FROM [User] WHERE email = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExistUsername(String username) {
        String sql = "SELECT 1 FROM [User] WHERE userName = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        String sql = "SELECT 1 FROM [User] WHERE phone = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
