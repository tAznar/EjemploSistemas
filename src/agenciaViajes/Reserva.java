/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agenciaViajes;

/**
 *
 * @author tomas
 */
public class Reserva {
    
    private int numReserva;
    private Sucursal sucursal;
    private Turista turista;
    private Hotel hotel;
    private String regimen;
    private Vuelo vuelo;
    private String clase;
    private String fechaLlegada;
    private String fechaPartida;
    
    public Reserva( int numReserva, Sucursal sucursal, Turista turista, Hotel hotel, String pension, 
                    Vuelo vuelo, String clase, String fechaLlegada, String fechaPartida){
        
        this.numReserva= numReserva;
        this.sucursal= sucursal;
        this.turista= turista;
        this.hotel= hotel;
        this.regimen= pension;
        this.vuelo= vuelo;
        this.clase= clase;
        this.fechaLlegada= fechaLlegada;
        this.fechaPartida= fechaPartida;
    }

    /**
     * @return the sucursal
     */
    public Sucursal getSucursal() {
        return sucursal;
    }

    /**
     * @param sucursal the sucursal to set
     */
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * @return the turista
     */
    public Turista getTurista() {
        return turista;
    }

    /**
     * @param turista the turista to set
     */
    public void setTurista(Turista turista) {
        this.turista = turista;
    }

    /**
     * @return the hotel
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * @param hotel the hotel to set
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * @return the regimen
     */
    public String getRegimen() {
        return regimen;
    }

    /**
     * @param regimen the regimen to set
     */
    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    /**
     * @return the vuelo
     */
    public Vuelo getVuelo() {
        return vuelo;
    }

    /**
     * @param vuelo the vuelo to set
     */
    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
    }

    /**
     * @return the fechaLlegada
     */
    public String getFechaLlegada() {
        return fechaLlegada;
    }

    /**
     * @param fechaLlegada the fechaLlegada to set
     */
    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    /**
     * @return the fechaPartida
     */
    public String getFechaPartida() {
        return fechaPartida;
    }

    /**
     * @param fechaPartida the fechaPartida to set
     */
    public void setFechaPartida(String fechaPartida) {
        this.fechaPartida = fechaPartida;
    }

    /**
     * @return the numReserva
     */
    public int getNumReserva() {
        return numReserva;
    }

    /**
     * @param numReserva the numReserva to set
     */
    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }
    
    @Override
    public String toString(){
        return(
                "Numero de reserva: "+numReserva+"\n"+
                "Turista: "+turista.getCodTurista()+" ("+turista.getNombreComp()+") \n"+
                "Hotel: "+hotel.getCodHotel()+", Vuelo: "+vuelo.getNumVuelo()+"\n"+
                "Fecha de llegada: "+fechaLlegada+", Fecha de partida: "+fechaPartida+"\n");
    }
    
}
