/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sait.cprg352;

import Classes.User;
import Classes.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 687159
 */
public class LoginServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        Cookie[] cks = request.getCookies();
		if (cks != null) {
			for (int i = 0; i < cks.length; i++) {
				String name = cks[i].getName();
				String value = cks[i].getValue();
				if (name.equals("auth")) {
					break; // exit the loop and continue the page
				}
				if (i == (cks.length - 1)) // if all cookie are not valid redirect to error page
				{
					response.sendRedirect("sessionExpired.html");
					return; // to stop further execution
				}
				i++;
			}
		} else {
			response.sendRedirect("sessionExpired.html");
			return; // to stop further execution
		}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String user1 = "Adam";
        String user2 = "Betty";
        String pass  = "password";
        String username = (request.getParameter("user"));
        String password = (request.getParameter("pass"));
        
        
        User users = new User (username, password);
        UserService login = new UserService();
        users.setUsername(username);
        users.setPassword(password);
        
        PrintWriter out = response.getWriter();
        Cookie ck = new Cookie("auth", username);
        ck.setMaxAge(600);  
        
        if(username == null || password == null )
        {
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        else if(username.isEmpty() || password.isEmpty())
        {
            request.setAttribute("errorMessage", "Both values are required!");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        if(login.login(users) != null)
        {
            response.addCookie(ck);
            
            request.getAttribute("username");
            request.getAttribute("password");
            request.setAttribute("logM", "Logged In!");
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            return;
        }
        else if(username.equals(user2) && password.equals(pass))
        {
            request.setAttribute("logM", "Logged In!");
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            return;
        }
        else
        {
            request.setAttribute("logMessage", "Logged out");
            request.setAttribute("wrongValues", "Invalid username or password!");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            return; 
        }
    }
}
