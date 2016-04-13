/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wrox;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author UUU
 */
@WebServlet(name = "LoginServlet",
        urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    
    private static final Map<String, String> USERDB = new Hashtable<>();
    
    static {
        USERDB.put("frank", "sun007");
        USERDB.put("John", "password");
        USERDB.put("Mike", "nopass");
    }
  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession();
       
       // user logout
       if(request.getParameter("logout") != null){
           session.invalidate();
           response.sendRedirect("login");
           return;
       }
       else  if(session.getAttribute("username") != null){
           response.sendRedirect("tickets");
           return;
       }
       
       request.setAttribute("loginFailed", false);
       request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
//       if(session.getAttribute("username") != null){
//           response.sendRedirect("tickets");
//           return;
//       }
       
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       
       if(username == null || password == null ||
               !LoginServlet.USERDB.containsKey(username) ||
               !password.equals(LoginServlet.USERDB.get(username))){
           request.setAttribute("loginFailed", true);
           request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp").forward(request, response);
       }
       else{
           session.setAttribute("username", username);
           request.changeSessionId();
           response.sendRedirect("tickets");
       }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
