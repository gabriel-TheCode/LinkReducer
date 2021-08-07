/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecode.controller;

import com.thecode.dao.LinkDAO;
import com.thecode.models.Link;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabrielthecode
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"/ControllerServlet"})
public class ControllerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LinkDAO LinkDAO;

    @Override
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        LinkDAO = new LinkDAO(jdbcURL, jdbcUsername, jdbcPassword);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertLink(request, response);
                    break;
                case "/delete":
                    deleteLink(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateLink(request, response);
                    break;
                case "/link":
                    updateVisit(request, response);
                default:
                    listLink(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listLink(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Link> listLink = LinkDAO.listAllLinks();
        request.setAttribute("listLink", listLink);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/LinkList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/LinkForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Link existingLink = LinkDAO.getLink(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/LinkForm.jsp");
        request.setAttribute("link", existingLink);
        dispatcher.forward(request, response);

    }
    
    private void updateVisit(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Link existingLink = LinkDAO.getLink(id);

        LinkDAO.updateLinkVisit(existingLink);
        listLink(request, response);
    }

    private void insertLink(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String url = request.getParameter("url");
        String code = getRandomStr(10);
        Date creationDate = new Date(System.currentTimeMillis());  
        String username = request.getParameter("username");

        Link link = new Link(url, code, creationDate, username, 0);
        LinkDAO.insertLink(link);
        response.sendRedirect("list");
    }

    private void updateLink(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String url = request.getParameter("url");
        String code = getRandomStr(10);
        Date creationDate = new Date(System.currentTimeMillis());  
        String username = request.getParameter("username");
        String visit = request.getParameter("visit");
        Link link;
     
        link = new Link(id, url, code, creationDate, username);
      
        LinkDAO.updateLink(link);
        response.sendRedirect("list");
    }

    private void deleteLink(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Link Link = new Link(id);
        LinkDAO.deleteLink(Link);
        response.sendRedirect("list");

    }

    public static String getRandomStr(int n) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder s = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (str.length() * Math.random());
            s.append(str.charAt(index));
        }
        return s.toString();
    }

}
