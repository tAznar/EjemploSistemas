/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agenciaViajes;

import agenciaViajes.exceptions.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author tomas
 */
public class Agencia {
    
    private ArrayList<Sucursal> sucursales;
    private ArrayList<Turista> turistas;
    private ArrayList<Reserva> reservas;
    
    Agencia(){
        sucursales= new ArrayList<>();
        turistas= new ArrayList<>();
        reservas= new ArrayList<>();
    }
    
    //Metodos para gestionar los turistas
    public void crearTuristaBasico() throws YaExisteException{
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("INSERTAR TURISTA");
        System.out.println("================");
        System.out.print("Codigo de turista: ");
        String cTu= entrada.next();
            for(int i=0; i<turistas.size(); i++){
                if (turistas.get(i).getCodTurista().equals(cTu)){
                    throw new YaExisteException("Ya existe un turista con este mismo codigo!!");
                }
            }
        
        System.out.print("Nombre completo: ");
        String nCo= entrada.nextLine();
        
        Turista t= new Turista(cTu, nCo);
        insertarTurista(t);
    }
    
    public void crearTuristaCompleto() throws YaExisteException{
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("INSERTAR TURISTA");
        System.out.println("================");
        System.out.print("Codigo de turista: ");
        String cTu= entrada.next();
            for(int i=0; i<turistas.size(); i++){
                if (turistas.get(i).getCodTurista().equals(cTu)){
                    throw new YaExisteException("Ya existe un turista con este mismo codigo!!");
                }
            }
        
        System.out.print("Nombre completo: ");
        String nCo= entrada.nextLine();
        System.out.print("Direccion: ");
        String dir= entrada.nextLine();
        System.out.print("Telefono: ");
        String tel= entrada.next();
        
        Turista t= new Turista(cTu, nCo, dir, tel);
        insertarTurista(t);
    }
    
    public void insertarTurista(Turista t){
        turistas.add(t);
    }
    
    public void eliminarTuristaPorCodigoTurista(String codTurista){
        for (int i=0; i<turistas.size(); i++){
            if (turistas.get(i).getCodTurista().equals(codTurista)){
                turistas.remove(i);
                return;
            }
        }
    }
    
    public void eliminarTurista(){
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("ELIMINAR TURISTA");
        System.out.println("================");
        
        for(int i=0; i<getTuristas().size(); i++){
            System.out.println("["+(i+1)+"]"+" "+getTuristas().get(i).getCodTurista()+" ("+getTuristas().get(i).getNombreComp()+")");
        }
        
        System.out.println("");
        System.out.print("Cual quieres eliminar? ");
        
        int eleccion;
        
        try{
            eleccion= entrada.nextInt() -1;
            getTuristas().remove(eleccion);
            
        }catch(InputMismatchException e){
            throw new InputMismatchException("Error de E/S!!");
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Error en la eleccion de turista!!");
        }
    }
    
    public void mostrarDatosTurista(){
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("MOSTRAR TURISTA");
        System.out.println("===============");
        
        for(int i=0; i<getTuristas().size(); i++){
            System.out.println("["+(i+1)+"]"+" "+getTuristas().get(i).getCodTurista()+" ("+getTuristas().get(i).getNombreComp()+")");
        }
        
        System.out.println("");
        System.out.print("Cual quieres mostrar? ");
        
        int eleccion;
        
        try{
            eleccion= entrada.nextInt() -1;
            System.out.println("");
            System.out.println(getTuristas().get(eleccion));
            
        }catch(InputMismatchException e){
            throw new InputMismatchException("Error de E/S!!");
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Error en la eleccion de turista!!");
        }
    }
    
    public void mostrarTuristas(){
        
        System.out.println("TURISTAS");
        System.out.println("========");
        for(int i=0; i<getTuristas().size(); i++){
            System.out.println((i+1)+".- "+getTuristas().get(i).getCodTurista()+" ("+getTuristas().get(i).getNombreComp()+")");
        }
    }
    
    
    //Metodos para gestionar las sucursales
    public void crearSucursalBasico() throws YaExisteException{
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("INSERTAR SUCURSAL");
        System.out.println("=================");
        System.out.print("Codigo de sucursal: ");
        String cSu= entrada.next();
            for(int i=0; i<sucursales.size(); i++){
                if (sucursales.get(i).getCodSucursal().equals(cSu)){
                    throw new YaExisteException("Ya existe una sucursal con este mismo codigo!!");
                }
            }
        
        Sucursal s= new Sucursal(cSu);
        insertarSucursal(s);
    }
    
    public void crearSucursalCompleto() throws YaExisteException{
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("INSERTAR SUCURSAL");
        System.out.println("=================");
        System.out.print("Codigo de sucursal: ");
        String cSu= entrada.next();
            for(int i=0; i<sucursales.size(); i++){
                if (sucursales.get(i).getCodSucursal().equals(cSu)){
                    throw new YaExisteException("Ya existe una sucursal con este mismo codigo!!");
                }
            }
        
        System.out.print("Direccion: ");
        String dir= entrada.nextLine();
        System.out.print("Telefono: ");
        String tel= entrada.next();
        
        Sucursal s= new Sucursal(cSu, dir, tel);
        insertarSucursal(s);
    }
    
    public void insertarSucursal(Sucursal s){
        sucursales.add(s);
    }
    
    public void eliminarSucursalPorCodigoSucursal(String codSucursal){
        for (int i=0; i<sucursales.size(); i++){
            if (sucursales.get(i).getCodSucursal().equals(codSucursal)){
                sucursales.remove(i);
                return;
            }
        }
    }
    
    public void eliminarSucursal(){
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("ELIMINAR SUCURSAL");
        System.out.println("=================");
        
        for(int i=0; i<getSucursales().size(); i++){
            System.out.println("["+(i+1)+"]"+" "+getSucursales().get(i).getCodSucursal()+" ("+getSucursales().get(i).getDireccion()+")");
        }
        
        System.out.println("");
        System.out.print("Cual quieres eliminar? ");
        
        int eleccion;
        
        try{
            eleccion= entrada.nextInt() -1;
            getSucursales().remove(eleccion);
            
        }catch(InputMismatchException e){
            throw new InputMismatchException("Error de E/S!!");
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Error en la eleccion de sucursal!!");
        }
    }
    
    public void mostrarDatosSucursal(){
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("MOSTRAR SUCURSAL");
        System.out.println("================");
        
        for(int i=0; i<getSucursales().size(); i++){
            System.out.println("["+(i+1)+"]"+" "+getSucursales().get(i).getCodSucursal()+" ("+getSucursales().get(i).getDireccion()+")");
        }
        
        System.out.println("");
        System.out.print("Cual quieres mostrar? ");
        
        int eleccion;
        
        try{
            eleccion= entrada.nextInt() -1;
            System.out.println("");
            System.out.println(getSucursales().get(eleccion));
            
        }catch(InputMismatchException e){
            throw new InputMismatchException("Error de E/S!!");
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Error en la eleccion de sucursal!!");
        }
    }
    
    public void mostrarSucursales(){
        
        System.out.println("SUCURSALES");
        System.out.println("==========");
        for(int i=0; i<getSucursales().size(); i++){
            System.out.println((i+1)+".- "+getSucursales().get(i).getCodSucursal()+" ("+getSucursales().get(i).getDireccion()+")");
        }
    }
    
    
    //Metodos para gestionar las reservas
    public void crearReservaCompleto(String codTurista) throws YaExisteException, NoExisteException, SinPlazasException{
        Scanner entrada= new Scanner(System.in);
        
        //El siguiente codigo comprueba que el turista que esta haciendo la
        //reserva, exista. Compara el codigo de turista introducido con todos y
        //cada uno de los codigos de turista que tenemos dados de alta. 
        
        //En caso de que no coincida con ninguno, mostrará un mensaje de error y
        //saldrá del metodo.
        
        //Si coincide con alguno, se guardará el turista en una variable y se
        //continuara con la ejecucion del metodo
        Turista tur=null;
        for(int i=0; i<turistas.size(); i++){
            if (turistas.get(i).getCodTurista().equals(codTurista)){
                tur= turistas.get(i);
            }
        }
        if (tur == null){
            throw new NoExisteException("No existe ningun turista con este codigo!!");
        }
        
        
        System.out.println("");
        System.out.println("INSERTAR RESERVA");
        System.out.println("================");
        
        int eleccion;
        
        try{
            //Comprueba si hay sucursales en la que hacer la reserva
            if (sucursales.isEmpty()){
                throw new NoExisteException("No hay sucursales disponibles!!");
            }
            System.out.println("");
            for (int i=0; i<sucursales.size(); i++){
                System.out.println("["+(i+1)+"]"+" "+getSucursales().get(i).getCodSucursal()+" ("+getSucursales().get(i).getDireccion()+")");
            }
            System.out.print("Elija una sucursal: ");
            eleccion= entrada.nextInt() -1;
            Sucursal suc= sucursales.get(eleccion);
            
            
            //Comprueba si la sucursal seleccionada tiene hoteles disponibles
            //donde hospedarse
            if (suc.getHoteles().isEmpty()){
                throw new NoExisteException("Esta sucursal no tiene hoteles disponibles!!");
            }
            System.out.println("");
            for (int i=0; i<suc.getHoteles().size(); i++){
                System.out.println("["+(i+1)+"]"+" "+suc.getHoteles().get(i).getNombre()+", "+suc.getHoteles().get(i).getCiudad());
            }
            System.out.print("Elija un hotel donde hospedarse: ");
            eleccion= entrada.nextInt() -1;
            Hotel hot= suc.getHoteles().get(eleccion);
            
            //Indica las habitaciones que se quieren reservar
            System.out.print("\nCuantas habitaciones quiere reservar? ");
            eleccion= entrada.nextInt();
            hot.reservaHabitacionHotel(eleccion);
            
            //El regimen en el que se hospeda
            String regimen="";
            System.out.println("");
            System.out.println("[1] Media pension");
            System.out.println("[2] Pension completa");
            System.out.print("Que regimen quiere reservar? ");
            eleccion= entrada.nextInt();
            
            //Se asegura de que elige una de los tipos de regimen que se ofrecen
            if (eleccion != 1 && eleccion != 2){
                throw new NoExisteException("Error en la eleccion del regimen del hotel!!");
            }
            if (eleccion == 1){
                regimen="Media pension";
            }else{
                regimen="Pension completa";
            }
            
            
            //Comprueba si la sucursal seleccionada tiene vuelos disponibles
            if (suc.getVuelos().isEmpty()){
                throw new NoExisteException("Esta sucursal no tiene vuelos disponibles!!");
            }
            System.out.println("");
            for(int i=0; i<suc.getVuelos().size(); i++){
                System.out.println("["+(i+1)+"]"+" "+suc.getVuelos().get(i).getNumVuelo()+": "+suc.getVuelos().get(i).getOrigen()+"/"+suc.getVuelos().get(i).getDestino());
            }
            System.out.print("Elija un vuelo: ");
            eleccion= entrada.nextInt() -1;
            Vuelo vue= suc.getVuelos().get(eleccion);
            
            //Indica los billetes que se quieren sacar
            System.out.print("Cuantos billetes quiere sacar? ");
            int numeroBilletes= entrada.nextInt();
            
            //La clase en la que se viajara
            String clase="";
            System.out.println("");
            System.out.println("[1] Turista");
            System.out.println("[2] Primera");
            System.out.print("En que clase quiere viajar? ");
            eleccion= entrada.nextInt();
            
            //Se asegura de que elige una de los tipos de regimen que se ofrecen
            if (eleccion != 1 && eleccion != 2){
                throw new NoExisteException("Error en la eleccion de la clase del vuelo!!");
            }
            if (eleccion == 1){
                clase="Turista";
            }else{
                clase="Primera";
            }
            
            //Ahora, con el numero de billetes y la clase del vuelo, podemos
            //hacer la reserva del vuelo
            vue.reservaClaseVuelo(clase, numeroBilletes);
            
            entrada.nextLine(); //Limpiamos el buffer
            
            //Se indicaran las fechas de llegada y partida
            System.out.println("");
            System.out.print("Fecha de llegada: ");
            String fechaLlegada= entrada.nextLine();
            System.out.print("Fecha de partida: ");
            String fechaPartida= entrada.nextLine();
            
            //Genera un numero de reserva. Si no hay ninguna, empezara por el numero 1.
            //En caso de que ya existan reservas, hara una comprobacion sobre el
            //numero de reserva y le sumara uno al numero de reserva que resulte
            //ser el maximo para que no existan dos reservas con el mismo numero
            
            int numReserva;
            if (getReservas().isEmpty()){
                numReserva=1;
            }else{
                numReserva= getReservas().get(0).getNumReserva();
            }
            
            for (int i=0; i<getReservas().size(); i++){
                numReserva= Math.max(numReserva, getReservas().get(i).getNumReserva());
            }
            
            numReserva += 1;
            
            //Creamos la reserva con los datos que hemos ido cumplimentando
            Reserva r= new Reserva(numReserva,suc,tur,hot,regimen,vue,clase,fechaLlegada,fechaPartida);
            
            //Y la insertamos en los objetos donde corresponde
            insertarReserva(r);     //El arrayList de la clase Agencia, que tendra todas las reservas
            suc.insertarReserva(r); //El arrayList de la sucursal en la que estamos haciendo la reserva
            tur.insertarReserva(r); //El arrayList del turista que esta haciendo la reserva
            
            //Para poder sacar la informacion de los arrayList hemos creado
            //objetos para copiar ahi dicha informacion. Al modificar esas copias,
            //los cambios realizados en ellas no se hacen efectivas en el arrayList
            //de donde las sacamos, pues son objetos totalmente diferentes.
            
            //Si trabajamos con las direcciones de memoria de los arrayList nos
            //sale un codigo enorme. En vez de eso, lo que haremos sera borrar los
            //objetos desactualizados de los arrayList e introducirlos de nuevo,
            //ya actualizados
            
            suc.eliminarHotelPorCodigoHotel(hot.getCodHotel());
            suc.insertarHotel(hot);
            suc.eliminarVueloPorNumeroVuelo(vue.getNumVuelo());
            suc.insertarVuelo(vue);
            
            eliminarSucursalPorCodigoSucursal(suc.getCodSucursal());
            insertarSucursal(suc);
            
            eliminarTuristaPorCodigoTurista(tur.getCodTurista());
            insertarTurista(tur);
            
            
        }catch(InputMismatchException e){
            throw new InputMismatchException("Error de E/S!!");
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Error en la eleccion!!");
        }
            
    }
    
    public void insertarReserva(Reserva r){
        getReservas().add(r);
    }
    
    public void eliminarReservaPorNumeroReserva(int numReserva){
        for (int i=0; i<getReservas().size(); i++){
            if (getReservas().get(i).getNumReserva() == numReserva){
                getReservas().remove(i);
                return;
            }
        }
    }
    
    public void eliminarReserva(){
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("ELIMINAR RESERVA");
        System.out.println("================");
        for(int i=0; i<getReservas().size(); i++){
            System.out.println("["+(i+1)+"]"+" "+getReservas().get(i).getNumReserva()+", "+getReservas().get(i).getTurista().getCodTurista()+"  "+getReservas().get(i).getFechaLlegada()+"-"+getReservas().get(i).getFechaPartida());
        }
        
        System.out.println("");
        System.out.print("Cual quieres eliminar? ");
        
        int eleccion;
        
        try{
            eleccion= entrada.nextInt() -1;
            getReservas().remove(eleccion);
            
        }catch(InputMismatchException e){
            throw new InputMismatchException("Error de E/S!!");
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Error en la eleccion de la reserva!!");
        }
    }
    
    public void mostrarDatosReserva(){
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("");
        System.out.println("MOSTRAR RESERVA");
        System.out.println("===============");
        
        for(int i=0; i<getReservas().size(); i++){
            System.out.println("["+(i+1)+"]"+" "+getReservas().get(i).getNumReserva()+", "+getReservas().get(i).getTurista().getCodTurista()+"  "+getReservas().get(i).getFechaLlegada()+"-"+getReservas().get(i).getFechaPartida());
        }
        
        System.out.println("");
        System.out.print("Cual quieres mostrar? ");
        
        int eleccion;
        
        try{
            eleccion= entrada.nextInt() -1;
            System.out.println("");
            System.out.println(getReservas().get(eleccion));
            
        }catch(InputMismatchException e){
            throw new InputMismatchException("Error de E/S!!");
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Error en la eleccion de la reserva!!");
        }
    }
    
    public void mostrarReservas(){
        
        System.out.println("RESERVAS");
        System.out.println("========");
        for(int i=0; i<getReservas().size(); i++){
            System.out.println((i+1)+".- "+getReservas().get(i).getNumReserva()+", "+getReservas().get(i).getTurista().getCodTurista()+"  "+getReservas().get(i).getFechaLlegada()+"-"+getReservas().get(i).getFechaPartida());
        }
    }
    
    
    
    /**
     * @return the sucursales
     */
    public ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }

    /**
     * @param sucursales the sucursales to set
     */
    public void setSucursales(ArrayList<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    /**
     * @return the turistas
     */
    public ArrayList<Turista> getTuristas() {
        return turistas;
    }

    /**
     * @param turistas the turistas to set
     */
    public void setTuristas(ArrayList<Turista> turistas) {
        this.turistas = turistas;
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
}
