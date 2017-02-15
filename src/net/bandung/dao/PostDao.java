package net.bandung.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.bandung.bean.PostBean;
import net.bandung.dbconnection.ConnectionProvider;

public class PostDao {

    private Connection conn;

    public PostDao() {
    	conn = ConnectionProvider.getConnection();
    }

    public void addPost(PostBean postbean) {
        try {
        	String sql = "INSERT INTO post(postid, judul, isi)" +
    		" VALUES (?, ?, ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, postbean.getPid());
            ps.setString(2, postbean.getJudul());
            ps.setString(3, postbean.getIsi());            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removePost(int postId) {
        try {
        	String sql = "DELETE FROM post WHERE postid=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setInt(1, postId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
      }

    public void editPost(PostBean postbean) {    	
    	try {
    		String sql = "UPDATE post SET judul=?, isi=?" +
            " WHERE postid=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setString(1, postbean.getJudul());
            ps.setString(2, postbean.getIsi());            
            ps.setInt(3, postbean.getPid());
            ps.executeUpdate();            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List getAllPosts() {
        List posts = new ArrayList();
        try {
        	String sql = "SELECT * FROM post";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PostBean postbean = new PostBean();
                postbean.setPid(rs.getInt("postid"));
                postbean.setJudul(rs.getString("judul"));
                postbean.setIsi(rs.getString("isi"));                             
                posts.add(postbean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
    }

    public PostBean getPostById(int postId) {
    	PostBean postBean = new PostBean();
        try {
        	String sql = "SELECT * FROM post WHERE postid=?";
            PreparedStatement ps = conn.
                    prepareStatement(sql);
            ps.setInt(1, postId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	postBean.setPid(rs.getInt("postid"));
            	postBean.setJudul(rs.getString("judul"));
            	postBean.setIsi(rs.getString("isi"));                           
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postBean;
    }
}