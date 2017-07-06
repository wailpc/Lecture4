package com.zain;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by w.yousif on 6/22/2017.
 */

@WebServlet(name = "CreateSession", urlPatterns = "/login")
public class CreateSession extends HttpServlet
{
    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginName = request.getParameter("loginname");
        AppUser appUser = new AppUser();
        appUser.setUsername(loginName);
        appUser.setDisplayName(loginName);

        System.out.println("loginName=" + loginName);
        //request.getSession().setAttribute("loginName", loginName);
        request.getSession().setAttribute("appUser", appUser);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(request, response);
        //response.sendRedirect("home.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        handleLogin(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
        //requestDispatcher.forward(request, response);
    }
}
