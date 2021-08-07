/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecode.dao;

import com.thecode.models.Link;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabrielthecode
 */
public class LinkDAO {

    private final String jdbcURL;
    private final String jdbcUsername;
    private final String jdbcPassword;
    private Connection jdbcConnection;

    public LinkDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertLink(Link link) throws SQLException {
        String sql = "INSERT INTO link (url, code, creation_date, username, visit) VALUES (?, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, link.getUrl());
        statement.setString(2, link.getCode());
        statement.setDate(3, link.getCreationDate());
        statement.setString(4, link.getUsername());
        statement.setInt(5, link.getVisit());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Link> listAllLinks() throws SQLException {
        List<Link> listLink = new ArrayList<>();

        String sql = "SELECT * FROM link";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String url = resultSet.getString("url");
            String code = resultSet.getString("code");
            Date creationDate = resultSet.getDate("creation_date");
            String username = resultSet.getString("username");
            int visit = resultSet.getInt("visit");

            Link link = new Link(id, url, code, creationDate, username, visit);
            listLink.add(link);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listLink;
    }

    public boolean deleteLink(Link link) throws SQLException {
        String sql = "DELETE FROM link where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, link.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateLink(Link link) throws SQLException {
        String sql = "UPDATE link SET url = ?, code = ?, creation_date = ?, username = ?";
        sql += " WHERE id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, link.getUrl());
        statement.setString(2, link.getCode());
        statement.setDate(3, link.getCreationDate());
        statement.setString(4, link.getUsername());
        statement.setInt(5, link.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }
    
        public boolean updateLinkVisit(Link link) throws SQLException {
        String sql = "UPDATE link SET visit = ?";
        sql += " WHERE id = ?";
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        int visit = link.getVisit()+1;
        statement.setInt(1, visit);
        statement.setInt(2, link.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public Link getLink(int id) throws SQLException {
        Link link = null;
        String sql = "SELECT * FROM link WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String url = resultSet.getString("url");
            String code = resultSet.getString("code");
            Date creationDate = resultSet.getDate("creation_date");
            String username = resultSet.getString("username");
            int visit = resultSet.getInt("visit");

            link = new Link(id, url, code, creationDate, username, visit);
        }

        resultSet.close();
        statement.close();

        return link;
    }
}
