package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.UserDao;
import model.User;
import dao.DatabaseConnect;

public class UserDaoImpl implements UserDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public User get(String username) {
        String sql = "SELECT * FROM [User] WHERE userName = ?";
        try {
            conn = new DatabaseConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setPassWord(rs.getString("passWord"));
                user.setEmail(rs.getString("email"));
                user.setFullName(rs.getString("fullName"));
                user.setPhone(rs.getString("phone"));
                user.setAvatar(rs.getString("avatar"));
                user.setRoleId(rs.getInt("roleId"));
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
        String sql = "INSERT INTO [User](userName, passWord, email, fullName, phone, avatar, roleId, createdDate) VALUES(?,?,?,?,?,?,?,?)";
        try {
            conn = new DatabaseConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassWord());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getFullName());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getAvatar());
            ps.setInt(7, user.getRoleId());
            ps.setDate(8, new java.sql.Date(user.getCreatedDate().getTime()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkExistEmail(String email) {
        String sql = "SELECT 1 FROM [User] WHERE email = ?";
        try {
            conn = new DatabaseConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExistUsername(String username) {
        String sql = "SELECT 1 FROM [User] WHERE userName = ?";
        try {
            conn = new DatabaseConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        String sql = "SELECT 1 FROM [User] WHERE phone = ?";
        try {
            conn = new DatabaseConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getByEmail(String email) {   // thêm mới
        String sql = "SELECT * FROM [User] WHERE email = ?";
        try {
            conn = new DatabaseConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setPassWord(rs.getString("passWord"));
                user.setEmail(rs.getString("email"));
                user.setFullName(rs.getString("fullName"));
                user.setPhone(rs.getString("phone"));
                user.setAvatar(rs.getString("avatar"));
                user.setRoleId(rs.getInt("roleId"));
                user.setCreatedDate(rs.getDate("createdDate"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
