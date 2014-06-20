/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agenciaViajes;

import java.util.ArrayList;

/**
 *
 * @author tomas
 */
public class Turista {
    
    private String codTurista;
    private String nombreComp;
    private String direccion;
    private String telefono;
    
    private ArrayList<Reserva> reservas;
    
    public Turista( String codTurista, String nombreComp, String direccion,
                    String telefono){
        
        this.codTurista= codTurista;
        this.nombreComp= nombreComp;
        this.direccion= direccion;
        this.telefono= telefono;
        
        reservas= new ArrayList<>();
    }
    
    public Turista( String codTurista, String nombreComp){
        this.codTurista= codTurista;
        this.nombreComp= nombreComp;
        
        reservas= new ArrayList<>();
    }
    
    
    //Metodos para insertar y eliminar reservas
    public void insertarReserva(Reserva r){
        reservas.add(r);
    }
    
    public void eliminarReserva(Reserva r){
        reservas.remove(r);
    }
    

    /**
     * @return the codTurista
     */
    public String getCodTurista() {
        return codTurista;
    }

    /**
     * @param codTurista the codTurista to set
     */
    public void setCodTurista(String codTurista) {
        this.codTurista = codTurista;
    }

    /**
     * @return the nombreComp
     */
    public String getNombreComp() {
        return nombreComp;
    }

    /**
     * @param nombreComp the nombreComp to set
     */
    public void setNombreComp(String nombreComp) {
        this.nombreComp = nombreComp;
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
     * @return the reservas
     */
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    /**
     * @param reservas the reservas to set
     */
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    @Override
    public String toString(){
        return(
                "Codigo: "+codTurista+"\n"+
                "Nombre: "+nombreComp+"\n"+
                "Direccion: "+direccion+"\n");
    }
    
}
