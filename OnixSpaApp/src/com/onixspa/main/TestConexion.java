package com.onixspa.main;

import com.onixspa.dao.Conexion;
import java.sql.Connection;

public class TestConexion {
    public static void main(String[] args) {
        Connection con = Conexion.getConexion();
        if (con != null) {
            System.out.println("🚀 Conexión establecida correctamente.");
            Conexion.cerrarConexion();
        } else {
            System.out.println("❌ No se pudo establecer conexión.");
        }
    }
}
