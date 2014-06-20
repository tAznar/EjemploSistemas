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
public class Vuelo {
    
    private String numVuelo;
    private String fecha;
    private String hora;
    private String origen;
    private String destino;
    private int plazasTotales;
    private int plazasTurLibres;
    
    public Vuelo(   String numVuelo, String fecha, String hora, String origen,
                    String destino, int plazasTotales, int plazasTurLibres){
        
        this.numVuelo= numVuelo;
        this.fecha= fecha;
        this.hora= hora;
        this.origen= origen;
        this.destino= destino;
        this.plazasTotales= plazasTotales;
        this.plazasTurLibres= plazasTurLibres;
    }
    
    public Vuelo(   String numVuelo, int plazasTotales, int plazasTurLibres){
        this.numVuelo= numVuelo;
        this.plazasTotales= plazasTotales;
        this.plazasTurLibres= plazasTurLibres;
    }
    
    public void reservaClaseVuelo(String clase, int numAsientos) throws SinPlazasException{
        if (clase.equals("Turista")){
            if (plazasTurLibres >= numAsientos){
                plazasTurLibres -= numAsientos;
            }else{
                throw new SinPlazasException("No quedan plazas suficientes en clase turista!!");
            }
        }else{
            if ((plazasTotales-plazasTurLibres) >= numAsientos){
                plazasTotales -= numAsientos;
            }else{
                throw new SinPlazasException("No quedan plazas suficientes de primera clase!!");
            }
        }
    }
    
    @Override
    public String toString(){
        return(
                "Numero de vuelo: "+numVuelo+"\n"+
                "Fecha y hora: "+fecha+", "+hora+"\n"+
                "Origen: "+origen+"\n"+
                "Destino: "+destino+"\n");
    }    

    /**
     * @return the numVuelo
     */
    public String getNumVuelo() {
        return numVuelo;
    }

    /**
     * @param numVuelo the numVuelo to set
     */
    public void setNumVuelo(String numVuelo) {
        this.numVuelo = numVuelo;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the plazasTotales
     */
    public int getPlazasTotales() {
        return plazasTotales;
    }

    /**
     * @param plazasTotales the plazasTotales to set
     */
    public void setPlazasTotales(int plazasTotales) {
        this.plazasTotales = plazasTotales;
    }

    /**
     * @return the plazasTurLibres
     */
    public int getPlazasTurLibres() {
        return plazasTurLibres;
    }

    /**
     * @param plazasTurLibres the plazasTurLibres to set
     */
    public void setPlazasTurLibres(int plazasTurLibres) {
        this.plazasTurLibres = plazasTurLibres;
    }
    
    
}
