/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agenciaViajes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import agenciaViajes.exceptions.*;

/**
 *
 * @author tomas
 */
public class Sucursal {
    
    private String codSucursal;
    private String direccion;
    private String telefono;
    
    private ArrayList<Hotel> hoteles;
    private ArrayList<Vuelo> vuelos;
    private ArrayList<Reserva> reservas;
    
    public Sucursal(    String codSucursal, String direccion, String telefono){
        this.codSucursal= codSucursal;
        this.direccion= direccion;
        this.telefono= telefono;
        
        hoteles= new ArrayList<>();
        vuelos= new ArrayList<>();
        reservas= new ArrayList<>();
    }
    
    public Sucursal(    String codSucursal){
        this.codSucursal= codSucursal;
        
        hoteles= new ArrayList<>();
        vuelos= new ArrayList<>();
        reservas= new ArrayList<>();
    }
    
    //Metodos para gestionar los hoteles
    public void crearHotelBasico() throws YaExisteException{
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("INSERTAR HOTEL");
        System.out.println("==============");
        System.out.print("Codigo: "); 
        String cHo= entrada.next();
            for(int i=0; i<getHoteles().size(); i++){
                if(getHoteles().get(i).getCodHotel().equals(cHo)){
                    throw new YaExisteException("Ya existe un hotel con este mismo codigo!!");
                }
            }
        
        int pDi;
                
        try{
            System.out.print("Numero de habitaciones: ");
            pDi= entrada.nextInt();
        }catch(InputMismatchException e){
            throw new InputMismatchException("Error de E/S!!");
        }
        
        Hotel h= new Hotel(cHo, pDi);
        insertarHotel(h);
    }
    
    public void crearHotelCompleto() throws YaExisteException{
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("INSERTAR HOTEL");
        System.out.println("==============");
        System.out.print("Codigo: "); 
        String cHo= entrada.next();
            for(int i=0; i<getHoteles().size(); i++){
                if(getHoteles().get(i).getCodHotel().equals(cHo)){
                    throw new YaExisteException("Ya existe un hotel con este mismo codigo!!");
                }
            }
            
        System.out.print("Nombre:");
        String nom= entrada.nextLine();
        System.out.print("Direccion: ");
        String dir= entrada.nextLine();
        System.out.print("Ciudad: ");
        String ciu= entrada.nextLine();
        System.out.print("Telefono: ");
        String tel= entrada.next();
        
        int pDi;
                
        try{
            System.out.print("Numero de habitaciones: ");
            pDi= entrada.nextInt();
        }catch(InputMismatchException e){
            throw new InputMismatchException("Error de E/S!!");
        }
        
        Hotel h= new Hotel(cHo, nom, dir, ciu, tel, pDi);
        insertarHotel(h);
    }
    
    public void insertarHotel(Hotel h){
        getHoteles().add(h);
    }
    
    public void eliminarHotelPorCodigoHotel(String codHotel){
        for (int i=0; i<hoteles.size(); i++){
            if (hoteles.get(i).getCodHotel().equals(codHotel)){
                hoteles.remove(i);
                return;
            }
        }
    }
    
    public void eliminarHotel(){
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("ELIMINAR HOTEL");
        System.out.println("==============");
        
        for(int i=0; i<getHoteles().size(); i++){
            System.out.println("["+(i+1)+"]"+" "+getHoteles().get(i).getNombre()+", "+getHoteles().get(i).getCiudad());
        }
        
        System.out.println("");
        System.out.print("Cual quieres eliminar? ");
        
        int eleccion;
        
        try{
            eleccion= entrada.nextInt() -1;
            getHoteles().remove(eleccion);
            
        }catch(InputMismatchException e){
            throw new InputMismatchException("Error de E/S!!");
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Error en la eleccion de hotel!!");
        }
    }
    
    public void mostrarDatosHotel(){
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("MOSTRAR HOTEL");
        System.out.println("=============");
        
        for(int i=0; i<getHoteles().size(); i++){
            System.out.println("["+(i+1)+"]"+" "+getHoteles().get(i).getNombre()+", "+getHoteles().get(i).getCiudad());
        }
        
        System.out.println("");
        System.out.print("Cual quieres mostrar? ");
        
        int eleccion;
        
        try{
            eleccion= entrada.nextInt() -1;
            System.out.println("");
            System.out.println(getHoteles().get(eleccion));
            
        }catch(InputMismatchException e){
            throw new InputMismatchException("Error de E/S!!");
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Error en la eleccion de hotel!!");
        }
    }
    
    public void mostrarHoteles(){
        
        System.out.println("HOTELES DE LA SUCURSAL "+getCodSucursal());
        System.out.println("=============================");
        for(int i=0; i<getHoteles().size(); i++){
            System.out.println((i+1)+".- "+getHoteles().get(i).getNombre()+", "+getHoteles().get(i).getCiudad());
        }
    }
    
    
    //Metodos para gestionar los vuelos
    public void crearVueloBasico() throws YaExisteException{
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("INSERTAR VUELO");
        System.out.println("==============");
        System.out.print("Numero de vuelo: "); 
        String nVu= entrada.next();
            for(int i=0; i<getVuelos().size(); i++){
                if(getVuelos().get(i).getNumVuelo().equals(nVu)){
                    throw new YaExisteException("Ya existe un vuelo con este mismo numero!!");
                }
            }
        
        int pTu;
        int pTo;
                
        try{
            System.out.print("Numero de plazas totales: ");
            pTo= entrada.nextInt();
            System.out.print("Numero de plazas de clase turista: ");
            pTu= entrada.nextInt();
            if (pTu > pTo){
                pTu= pTo;
            }
            
        }catch(InputMismatchException e){
            throw new InputMismatchException("Error de E/S!!");
        }
        
        Vuelo v= new Vuelo(nVu, pTo, pTu);
        insertarVuelo(v);
    }
    
    public void crearVueloCompleto() throws YaExisteException{
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("INSERTAR VUELO");
        System.out.println("==============");
        System.out.print("Numero de vuelo: "); 
        String nVu= entrada.next();
            for(int i=0; i<getVuelos().size(); i++){
                if(getVuelos().get(i).getNumVuelo().equals(nVu)){
                    throw new YaExisteException("Ya existe un vuelo con este mismo numero!!");
                }
            }
            
        System.out.print("Fecha:");
        String fec= entrada.nextLine();
        System.out.print("Hora: ");
        String hor= entrada.nextLine();
        System.out.print("Origen: ");
        String ori= entrada.nextLine();
        System.out.print("Destino: ");
        String des= entrada.next();
        
        int pTu;
        int pTo;
                
        try{
            System.out.print("Numero de plazas totales: ");
            pTo= entrada.nextInt();
            System.out.print("Numero de plazas de clase turista: ");
            pTu= entrada.nextInt();
            if (pTu > pTo){
                pTu= pTo;
            }
            
        }catch(InputMismatchException e){
            throw new InputMismatchException("Error de E/S!!");
        }
        
        Vuelo v= new Vuelo(nVu, fec, hor, ori, des, pTo, pTu);
        insertarVuelo(v);
    }
    
    public void insertarVuelo(Vuelo v){
        getVuelos().add(v);
    }
    
    public void eliminarVueloPorNumeroVuelo(String numVuelo){
        for (int i=0; i<vuelos.size(); i++){
            if (vuelos.get(i).getNumVuelo().equals(numVuelo)){
                vuelos.remove(i);
                return;
            }
        }
    }
    
    public void eliminarVuelo(){
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("ELIMINAR VUELO");
        System.out.println("==============");
        
        for(int i=0; i<getVuelos().size(); i++){
            System.out.println("["+(i+1)+"]"+" "+getVuelos().get(i).getNumVuelo()+": "+getVuelos().get(i).getOrigen()+"/"+getVuelos().get(i).getDestino());
        }
        
        System.out.println("");
        System.out.print("Cual quieres eliminar? ");
        
        int eleccion;
        
        try{
            eleccion= entrada.nextInt() -1;
            getVuelos().remove(eleccion);
            
        }catch(InputMismatchException e){
            throw new InputMismatchException("Error de E/S!!");
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Error en la eleccion de vuelo!!");
        }
    }
    
    public void mostrarDatosVuelo(){
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("MOSTRAR VUELO");
        System.out.println("=============");
        
        for(int i=0; i<getVuelos().size(); i++){
            System.out.println("["+(i+1)+"]"+" "+getVuelos().get(i).getNumVuelo()+": "+getVuelos().get(i).getOrigen()+"/"+getVuelos().get(i).getDestino());
        }
        
        System.out.println("");
        System.out.print("Cual quieres mostrar? ");
        
        int eleccion;
        
        try{
            eleccion= entrada.nextInt() -1;
            System.out.println("");
            System.out.println(getVuelos().get(eleccion));
            
        }catch(InputMismatchException e){
            throw new InputMismatchException("Error de E/S!!");
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Error en la eleccion de vuelo!!");
        }
    }
    
    public void mostrarVuelos(){
        
        System.out.println("VUELOS DE LA SUCURSAL "+getCodSucursal());
        System.out.println("============================");
        for(int i=0; i<getHoteles().size(); i++){
            System.out.println((i+1)+".- "+getVuelos().get(i).getNumVuelo()+": "+getVuelos().get(i).getOrigen()+"/"+getVuelos().get(i).getDestino());
        }
    }
    
    
    //Metodos para insertar y eliminar reservas
    public void insertarReserva(Reserva r){
        reservas.add(r);
    }
    
    public void eliminarReserva(Reserva r){
        reservas.remove(r);
    }
    

    /**
     * @return the codSucursal
     */
    public String getCodSucursal() {
        return codSucursal;
    }

    /**
     * @param codSucursal the codSucursal to set
     */
    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
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
     * @return the hoteles
     */
    public ArrayList<Hotel> getHoteles() {
        return hoteles;
    }

    /**
     * @param hoteles the hoteles to set
     */
    public void setHoteles(ArrayList<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

    /**
     * @return the vuelos
     */
    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    /**
     * @param vuelos the vuelos to set
     */
    public void setVuelos(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
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
                "Codigo: "+codSucursal+"\n"+
                "Direccion: "+direccion+"\n"+
                "Telefono: "+telefono+"\n");
    }
}
