package com.codoacodo.dto;

import java.sql.Timestamp;

/**
 *
 * @author Nicolas
 */
public class Orador extends Persona {
    
    //Definimos variables
    private String tema;
    private Timestamp fechaAlta;
    
    //Constructor
    
    public Orador(){}
    
    //orador con id y timestamp para visualizar registros
    public Orador(long i, String n, String a , String t, Timestamp ld) {
        super(i, n, a);
        this.tema = t;
        this.fechaAlta = ld;
    }
    
   public Orador(String n, String a, String m, String t){
       super(n,a);
       this.tema=t;
       this.mail=m;
   }
    
    public Orador(int i, String n, String a, String m, String t, Timestamp ts ) {
        super(i, n, a, m);
        this.tema = t;
        this.fechaAlta = ts;
    }
    
    //orador sin id para insertar en la db
    public Orador(String n, String a , String t) {
        super(n,a);
        this.tema = t;
    }
    
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Timestamp getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    //Métodos
    public void exponerCharla() {
        System.out.println("Hola soy Bill Gates y voy a hablar del nuevo orden mundial.");
    }

    public String saludar() {
        String uno = "Hola";
        int numero = 2;
        
        return String.valueOf(numero);
    }
    
    public void inscribirseEnLaConferencia() {
        System.out.println("Datos Ingresados y validados.");
    }

    @Override
    public String toString() {
        return super.toString() + "Orador{" + "tema=" + tema + " - Fecha de Alta=" + fechaAlta +'}';
    }

}
