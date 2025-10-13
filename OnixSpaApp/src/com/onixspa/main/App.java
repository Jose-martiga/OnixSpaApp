package com.onixspa.main;

import com.onixspa.dao.ReservaDAO;
import com.onixspa.model.Reserva;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Instancia del DAO
        ReservaDAO dao = new ReservaDAO();

        // === INSERTAR ===
        Reserva nueva = new Reserva(0, "Carlos Pérez", "Masaje relajante", "2025-10-14", "10:00");
        dao.agregarReserva(nueva);

        // === LISTAR ===
        System.out.println("=== Reservas registradas ===");
        List<Reserva> reservas = dao.listarReservas();
        for (Reserva r : reservas) {
            System.out.println("ID: " + r.getId() +
                               ", Cliente: " + r.getNombreCliente() +
                               ", Servicio: " + r.getServicio() +
                               ", Fecha: " + r.getFecha() +
                               ", Hora: " + r.getHora());
        }
    }
}
