package datos;

import com.sun.source.tree.TryTree;
import dominio.Contacto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactoDao {
    public List<Contacto> obtenerContactos() {
        List<Contacto> contactos = new ArrayList<>();
        String consulta = "SELECT * FROM contactos";
        try (
                Connection conexion = Conexion.obtenerConexion();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery(consulta);
        ) {
            while (rs.next()) {
                Contacto contacto = new Contacto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("email")
                );
                contactos.add(contacto);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener contactos: " + e.getMessage());
        }
        return contactos;
    }

    public void insertarContacto(Contacto contacto) {
        String sql = "INSERT INTO contactos(nombre, telefono, email) VALUES(?,?,?)";
        try (
                Connection conexion = Conexion.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sql);
        ) {
            ps.setString(1, contacto.getNombre());
            ps.setString(2, contacto.getTelefono());
            ps.setString(3, contacto.getEmail());
            ps.executeUpdate();
            System.out.println("Contacto agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Exception al insertar contacto: " + e.getMessage());
        }
    }

    public void actualzarContacto(Contacto contacto) {
        String sql = "UPDATE contactos SET nombre = ?, telefono = ?, email = ? WHERE id=?";
        try (
                Connection conexion = Conexion.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sql);
        ) {
            ps.setString(1, contacto.getNombre());
            ps.setString(2, contacto.getTelefono());
            ps.setString(3, contacto.getEmail());
            ps.setInt(4, contacto.getId());
            int registros = ps.executeUpdate();
            if (registros > 0) {
                System.out.println("Contacto actualizado correctamente");
            } else {
                System.out.println("No se encontro un contacto conn ese ID");
            }
        } catch (Exception e) {
            System.out.println("Exception al actualizar contacto: " + e.getMessage());
        }

    }

    public void eliminarContacto(Contacto contacto) {
        String sql = "DELETE FROM contactos WHERE id=?";
        try (
                Connection conexion = Conexion.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sql);
        ) {
            ps.setInt(1, contacto.getId());
            int registros = ps.executeUpdate();
            if (registros > 0) {
                System.out.println("Contacto eliminado correctamente");
            } else {
                System.out.println("No se encontro un contacto conn ese ID");
            }
        } catch (Exception e) {
            System.out.println("Exception al eliminado contacto: " + e.getMessage());
        }
    }
}
