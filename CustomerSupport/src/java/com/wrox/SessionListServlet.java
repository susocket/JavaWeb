/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wrox;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author UUU
 */
@WebServlet(name = "SessionListServlet", urlPatterns = {"/sessions"})
public class SessionListServlet extends HttpServlet {   

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
//       if(request.getSession().getAttribute("username") == null){
//           response.sendRedirect("login");
//           return;
//       }
       
       request.setAttribute("numberOfSessions", SessionRegistry.getNumberOfSessions());
       request.setAttribute("sessionList", SessionRegistry.getAllSessions());
       request.getRequestDispatcher("/WEB-INF/jsp/view/sessions.jsp").forward(request, response);
       
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
