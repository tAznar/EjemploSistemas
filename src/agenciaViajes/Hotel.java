/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agenciaViajes;

import agenciaViajes.exceptions.SinPlazasException;

/**
 *
 * @author tomas
 */
public class Hotel {
    
    private String codHotel;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String telefono;
    private int plazasDisponibles;
    
    public Hotel(   String codHotel, String nombre, String direccion,
                    String ciudad, String telefono, int plazasDisponibles){
        
        this.codHotel= codHotel;
        this.nombre= nombre;
        this.direccion= direccion;
        this.ciudad= ciudad;
        this.telefono= telefono;
        this.plazasDisponibles= plazasDisponibles;
    }
    
    public Hotel(   String codHotel, int plazasDisponibles){
        this.codHotel= codHotel;
        this.plazasDisponibles= plazasDisponibles;
    }
    
    public void reservaHabitacionHotel(int numHabitaciones) throws SinPlazasException{
        if (plazasDisponibles >= numHabitaciones){
            plazasDisponibles -= numHabitaciones;
        }else{
            throw new SinPlazasException("No quedan habitaciones suficientes!!");
        }
    }
    
    @Override
    public String toString(){
        return(
                "Codigo: "+codHotel+"\n"+
                "Nombre: "+nombre+"\n"+
                "Direccion: "+direccion+", "+ciudad+"\n"+
                "Telefono: "+telefono+"\n");
    }

    /**
     * @return the codHotel
     */
    public String getCodHotel() {
        return codHotel;
    }

    /**
     * @param codHotel the codHotel to set
     */
    public void setCodHotel(String codHotel) {
        this.codHotel = codHotel;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the plazasDisponibles
     */
    public int getPlazasDisponibles() {
        return plazasDisponibles;
    }

    /**
     * @param plazasDisponibles the plazasDisponibles to set
     */
    public void setPlazasDisponibles(int plazasDisponibles) {
        this.plazasDisponibles = plazasDisponibles;
    }
    
}
