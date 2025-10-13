package com.onixspa.dao;

import com.onixspa.model.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    // INSERTAR
    public boolean agregarReserva(Reserva r) {
        String sql = "INSERT INTO reservas (nombreCliente, servicio, fecha, hora) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, r.getNombreCliente());
            ps.setString(2, r.getServicio());
            ps.setString(3, r.getFecha());
            ps.setString(4, r.getHora());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar reserva: " + e.getMessage());
            return false;
        }
    }

    // LISTAR
    public List<Reserva> listarReservas() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reservas";
        try (Connection con = Conexion.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Reserva r = new Reserva();
                r.setId(rs.getInt("id"));
                r.setNombreCliente(rs.getString("nombreCliente"));
                r.setServicio(rs.getString("servicio"));
                r.setFecha(rs.getString("fecha"));
                r.setHora(rs.getString("hora"));
                lista.add(r);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar reservas: " + e.getMessage());
        }
        return lista;
    }

    // ACTUALIZAR
    public boolean actualizarReserva(Reserva r) {
        String sql = "UPDATE reservas SET nombreCliente=?, servicio=?, fecha=?, hora=? WHERE id=?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, r.getNombreCliente());
            ps.setString(2, r.getServicio());
            ps.setString(3, r.getFecha());
            ps.setString(4, r.getHora());
            ps.setInt(5, r.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar reserva: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminarReserva(int id) {
        String sql = "DELETE FROM reservas WHERE id=?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar reserva: " + e.getMessage());
            return false;
        }
    }
}

