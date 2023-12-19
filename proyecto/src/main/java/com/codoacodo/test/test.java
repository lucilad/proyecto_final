
package com.codoacodo.test;
import com.codoacodo.daos.OradorDAO;
import com.codoacodo.dto.*;

public class test {
    
 public static void main(String[] args) {
        // Datos de ejemplo para el nuevo orador
        String nombre = "Ada";
        String apellido = "Lovelace";
        String mail = "adalove@gmail.com";
        String tema = "Algoritmos";

        // Crear un objeto Orador con los datos de ejemplo
        Orador orador = new Orador(nombre, apellido, mail, tema);

        // Instanciar el DAO
        OradorDAO dao = new OradorDAO();

        // Llamar al método insertarOrador y obtener la cantidad de registros afectados
        int registrosInsertados = dao.insertarOrador(orador);

        // Verificar si se insertó al menos un registro en la base de datos
        if (registrosInsertados > 0) {
            System.out.println("Se insertó el orador correctamente.");
        } else {
            System.out.println("No se pudo insertar el orador.");
        }
    }
}
