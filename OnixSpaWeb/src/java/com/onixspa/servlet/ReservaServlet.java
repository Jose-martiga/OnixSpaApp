package com.onixspa.servlet;

import com.onixspa.dao.ReservaDAO;
import com.onixspa.model.Reserva;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ReservaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombreCliente");
        String servicio = request.getParameter("servicio");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");

        Reserva reserva = new Reserva(0, nombre, servicio, fecha, hora);
        ReservaDAO dao = new ReservaDAO();
        dao.agregarReserva(reserva);

        // Redirige a JSP con mensaje
        request.setAttribute("mensaje", "Reserva agregada con éxito");
        RequestDispatcher rd = request.getRequestDispatcher("reserva.jsp");
        rd.forward(request, response);
    }
}
