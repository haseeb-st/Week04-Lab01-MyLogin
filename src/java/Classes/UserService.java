/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javax.servlet.http.HttpSession;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 687159
 */
public class UserService 
{
    private String Username1 = "Adam";
    private String Username2 = "Betty";
    private String pass      = "password";
    
    public String login(User user)
    {

        String username = user.getUsername();
        String password = user.getPassword();

        if(user.equals(Username1) && pass.equals(pass))
        {
            System.out.println("Hello Adam.");
            
        }
        else if(user.equals(Username2) && pass.equals(pass))
        {
            System.out.println("Hello Betty");
        }
        return (username);
    }
}
