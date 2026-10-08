package com.example.demojspmvc.util;

import com.example.demojspmvc.model.Account;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountUtil {
    private DataSource dataSource;

    public AccountUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Account> getDsAccount(){
        List<Account> dsacc = new ArrayList<>();
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            String sql = "Select * from accounts order by ID";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt("ID");
                String fname = rs.getString("FIRSTNAME");
                String lname = rs.getString("LASTNAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                Date dateofbirth = rs.getDate("DATEOFBIRTH");
                Account am = new Account(id, fname, lname, email, password, dateofbirth);
                dsacc.add(am);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(conn, stm, rs);
        }
        return dsacc;
    }

    public void themAccount(Account acc){
        String sql = "insert into accounts (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, DATEOFBIRTH) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, acc.getFirstname());
            ps.setString(2, acc.getLastname());
            ps.setString(3, acc.getEmail());
            ps.setString(4, acc.getPassword());
            ps.setDate(5, acc.getDateOfBirth());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(conn, ps, null);
        }
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try {
            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
