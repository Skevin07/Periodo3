package com.laboratorio2p3.dao;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.laboratorio2p3.conexion.Conexion;
import com.laboratorio2p3.entidades.*;

public class MarcaDao {
	//CONEXION A LA BASE DE DATOS 
    Conexion cn = new Conexion();
    Connection con = cn.RetornarConexion();
    
    
    //CONSULTAS A LA BASE DE DATOS 
    public void agregarMarca(Marca marca) {
        try {
            CallableStatement statement = con.prepareCall("call SP_I_Marca(?)");
            statement.setString("MNombre", marca.getNombreMarca());

            statement.execute();
            con.close();
            
            System.out.println("Datos almacenados con éxito!");
        } catch (Exception e) {
        	System.out.println("Error al guardar los datos");

        }

    }

    public void actualizarMarca(Marca marca) {
        try {
            CallableStatement statement = con.prepareCall("call SP_U_Marca(?,?)");
            statement.setInt("MIdMarca", marca.getId());
            statement.setString("MNombre", marca.getNombreMarca());

            statement.execute();
            con.close();
            System.out.println("Datos actualizados con éxito!");
        } catch (Exception e) {
        	System.out.println("Error al actualizar los datos");

        }

    }

    public void eliminarMarca(Marca marca) {
        try {
            CallableStatement statement = con.prepareCall("call SP_D_Marca(?);");
            statement.setInt("MIdMarca", marca.getId());
            statement.execute();
            System.out.println("Datos eliminados correntamente");
            con.close();
        } catch (Exception e) {
        	System.out.println("Ocurrio un error al eliminar los Datos " + e);

        }
    }

    public ArrayList<Marca> MostrarMarcas() {
        var listado = new ArrayList<Marca>();
        try {
            CallableStatement statement = con.prepareCall("call SP_S_Marca;");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Marca marc = new Marca();
                marc.setId(res.getInt("idMarca"));
                marc.setNombreMarca(res.getString("Nombre"));

                listado.add(marc);
            }
        } catch (Exception e) {
        	System.out.println("No se cargaron los Datos " + e);
        }

        return listado;
    }
}
