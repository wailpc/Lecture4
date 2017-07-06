package com.zain;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by w.yousif on 7/6/2017.
 */

@WebFilter(filterName = "FilterCheckSession", urlPatterns = "/*")
public class FilterCheckSession implements Filter
{
    public void init(FilterConfig config) throws ServletException { }
    public void destroy() { }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
    {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        String requestURI = request.getRequestURI();
        System.out.println("requestURI=" + requestURI);

        if (requestURI.equals("/login"))
        {
            chain.doFilter(req, resp);
            return;
        }

        AppUser appUser = (AppUser)request.getSession().getAttribute("appUser");
        if (appUser != null)
        {
            chain.doFilter(req, resp);
        }
        else
        {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
