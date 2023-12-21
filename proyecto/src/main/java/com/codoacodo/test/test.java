
package com.codoacodo.test;
import com.codoacodo.daos.OradorDAO;
import com.codoacodo.dto.Orador;

public class test {
    
 public static void main(String[] args) {
        
      /* Insertar orador
        String nombre = "Bill";
        String apellido = "Gates";
        String mail = "bgates@gmail.com";
        String tema = "Microsoft";
        // Crear un objeto Orador con los datos de ejemplo
        Orador orador = new Orador(nombre, apellido, mail, tema);
        // Instanciar el DAO
        OradorDAO dao = new OradorDAO();
        // Llamar al método insertarOrador y obtener la cantidad de registros 
        int registrosInsertados = dao.insertarOrador(orador);
        // Verificar si se insertó al menos un registro en la base de datos
        if (registrosInsertados > 0) {
            System.out.println("Se insertó el orador correctamente.");
        } else {
            System.out.println("No se pudo insertar el orador.");
        }*/
        
        //Test actualizar orador
        // Creamos un objeto OradorDAO
        OradorDAO oradorDAO = new OradorDAO();

        // Creamos un objeto Orador para usar en la prueba
        Orador orador = new Orador(Long.valueOf(55),"Jane", "Doe", "correo@ejemplo.com", "Tema");

        // Ejecutamos el método a probar
        int registros = oradorDAO.actualizarOrador(orador);

        // Verificamos el resultado
        if (registros > 0) {
            System.out.println("El orador se actualizó correctamente.");
        } else {
            System.out.println("No se pudo actualizar el orador.");
        }
    }

    }

