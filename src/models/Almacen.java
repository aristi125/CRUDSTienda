package models;
import java.util.ArrayList;

/**
 *
 * @author Games
 */
public class Almacen {
//------------------------------------------------ATRIBUTOS------------------------------------------------//
    private String nit = "97364467", nombre = "aiudaaaa";
    private int codigoTransaccion = 1;
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ArrayList<Producto> listaProductos = new ArrayList<>();
    private ArrayList<Transaccion> listaTransacciones = new ArrayList<>();
    
//------------------------------------------------CONSTRUCTORES------------------------------------------------//

    public Almacen(String nit, String nombre) {
        super();
        this.nit = nit;
        this.nombre = nombre;
    }

//------------------------------------------------CRUD CLIENTE------------------------------------------------//

    public Cliente crearCliente(String nit, String idTributaria, String nombre, String apellido,
            String identificacion, String direccion, String telefono, int tipoCliente,
            String correo, String fechaNacimiento){
        if(tipoCliente == 0){
            for(int i = 0; i<listaClientes.size(); i++){
                if(listaClientes.get(i).getIdentificacion().equals(identificacion)){
                    return null;
                }
            }
            listaClientes.add(new  ClienteNatural(correo, fechaNacimiento, nombre, apellido, identificacion, direccion, telefono, TipoCliente.NATURAL));
            return listaClientes.get(listaClientes.size()-1);
        }
        else{
            for(int i = 0; i<listaClientes.size(); i++){
                if(listaClientes.get(i).getIdentificacion().equals(identificacion)){
                    return null;
                }
            }
            listaClientes.add(new  ClienteJuridico(nit, idTributaria, nombre, apellido, identificacion, direccion, telefono, TipoCliente.JURIDICO));
            return listaClientes.get(listaClientes.size()-1);
        }
        
        
    }
    public Cliente leerCliente(String identificacion){
        for (int i=0; i<listaClientes.size(); i++){
            if(listaClientes.get(i).getIdentificacion().equals(identificacion)){
                    return listaClientes.get(i);
                }
        }
        return null;
    }
    public String actualizarCliente(String nit, String idTributaria, String nombre, String apellido,
            String identificacion, String direccion, String telefono, int tipoCliente,
            String correo, String fechaNacimiento){
         if(tipoCliente == 0){
            for(int i = 0; i<listaClientes.size(); i++){
                if(listaClientes.get(i).getIdentificacion().equals(identificacion)){
                     listaClientes.add(new  ClienteNatural(correo, fechaNacimiento, nombre, apellido, identificacion, direccion, telefono, TipoCliente.NATURAL));
            return "Se ha actualizado el cliente";
                }
            }
          
        }
        else{
            for(int i = 0; i<listaClientes.size(); i++){
                if(listaClientes.get(i).getIdentificacion().equals(identificacion)){
                    listaClientes.add(new  ClienteJuridico(nit, idTributaria, nombre, apellido, identificacion, direccion, telefono, TipoCliente.JURIDICO));
                    return "Se ha actualizado el cliente";
                }
            }
            
        }
         return "no se ha encontrado un cliente";
    }

    public String eliminarCliente(String identificacion){
        for (int i=0; i<listaClientes.size(); i++){
            if(listaClientes.get(i).getIdentificacion().equals(identificacion)){
                listaClientes.remove(i);
                    return "El cliente ha sido eliminado";
                }
        }
        return "No se ha encontrado un cliente";
    }
//------------------------------------------------CRUD PRODUCTO------------------------------------------------//
public String crearProducto(String codigo, String nombreProducto, String descripcion, Double valorUntirario,
        Integer cantExistencias, String refrigeracionRegistrada, String codigoAprobacion,
        String fechaVencimiento, Double pesoEnvase, String pais){
            for(int i = 0; i<listaProductos.size(); i++){
                if(listaProductos.get(i).getCodigo().equals(codigo)){
                    return "el producto ya ha sido registrado";
                }
            }
        listaProductos.add(new Producto( codigo,  nombreProducto,  descripcion,  fechaVencimiento,  codigoAprobacion,  refrigeracionRegistrada,  pais,  valorUntirario,  pesoEnvase,  cantExistencias));
        return "el producto ha sido registrado";
    }
    public Producto leerProducto(String codigo){
        for (int i=0; i<listaClientes.size(); i++){
            if(listaProductos.get(i).getCodigo().equals(codigo)){
                    return listaProductos.get(i);
                }
        }
        return null;
    }
    public Producto actualizarProducto(String codigo, String nombreProducto, String descripcion, Double valorUntirario,
        Integer cantExistencias, String refrigeracionRegistrada, String codigoAprobacion,
        String fechaVencimiento, Double pesoEnvase, String pais){
         for(int i = 0; i<listaProductos.size(); i++){
                if(listaProductos.get(i).getCodigo().equals(codigo)){
                    listaProductos.add(new Producto( codigo,  nombreProducto,  descripcion,  fechaVencimiento,  codigoAprobacion,  refrigeracionRegistrada,  pais,  valorUntirario,  pesoEnvase,  cantExistencias));
                    return null;
                }
            }
         return listaProductos.get(listaProductos.size()-1);
         
         /**
          * este metodo es la copia de su simil superior, con la diferencia de que este no retorna nada, esta apoya los procesos
          * de actualizacion de la lista de productos
          */
    }
    public void actualizarProductoAux(String codigo, String nombreProducto, String descripcion, Double valorUntirario,
        Integer cantExistencias, String refrigeracionRegistrada, String codigoAprobacion,
        String fechaVencimiento, Double pesoEnvase, String pais){
         for(int i = 0; i<listaProductos.size(); i++){
                if(listaProductos.get(i).getCodigo().equals(codigo)){
                    listaProductos.add(new Producto( codigo,  nombreProducto,  descripcion,  fechaVencimiento,  codigoAprobacion,  refrigeracionRegistrada,  pais,  valorUntirario,  pesoEnvase,  cantExistencias));
                }
            }
    }
    public Producto eliminarProducto(String codigo){
        for (int i=0; i<listaClientes.size(); i++){
            if(listaProductos.get(i).getCodigo().equals(codigo)){
            	Producto producto = listaProductos.get(i);
                listaProductos.remove(i);
                    return producto;
                }
        }
        return null;
    }
//------------------------------------------------FUNCIONES TRANSACCION------------------------------------------------//

    /**
     * este metodo permite eliinar una transaccion y actualizar la lista de productos con una funcion de apoyo
     * @param codigoTransaccion
     * @return 
     */
   public String eliminarTransaccion (String codigoTransaccion){
       for(int i=0; i<listaTransacciones.size(); i++){
           if(listaTransacciones.get(i).getCodigo().equals(codigoTransaccion)){
               ActualizarProductosSuma(listaTransacciones.get(i).getDetallesVenta());
               listaTransacciones.remove(i);
               return "la transaccion ha sido eliminada";
           }
       }
       return "la transaccion no se ha encontrado";
   }
   /**
    * este metodo genera la transaccion y permite actualizar la lista de productos con una funcion de apoyo
    * @param fecha
    * @param listaDetalles
    * @param comprador
    * @return 
    */
   public Transaccion generarTrasaccion (String fecha, ArrayList<Detalle> listaDetalles, Cliente comprador){
       listaTransacciones.add(new Transaccion(""+codigoTransaccion, fecha, comprador, listaDetalles));
       ActualizarProductosResta(listaDetalles);
       return listaTransacciones.get(listaTransacciones.size()-1);
   }
    /**
     * este metodo permite restar los productos que se hayan comprado en una transaccion en la lista de productos
     * @param listaDetalleAux 
     */
    
    public void ActualizarProductosResta(ArrayList<Detalle> listaDetalleAux){
        for(int i=0; i<listaDetalleAux.size(); i++){
            Producto productoAux = leerProducto(listaDetalleAux.get(i).getCodigoPorducto());
            int totalActual = productoAux.getCantExistencias() - listaDetalleAux.get(i).getCantProducto();
            actualizarProducto(productoAux.getCodigo(),  productoAux.getNombre(),  productoAux.getDescripcion(),  productoAux.getValorUntirario(),
                    productoAux.getCantExistencias(),  productoAux.getRefrigeracionRecomendada(),  productoAux.getPaisOrigen(),  productoAux.getFechaVencimiento(),
                    productoAux.getPesoEnvase(),  productoAux.getPaisOrigen());
        }
    }
    /**
     * este metodo permite sumar cantidades en productos ya existentes cuando se elimina una transaccion
     * @param listaDetalleAux 
     */
    public void ActualizarProductosSuma(ArrayList<Detalle> listaDetalleAux){
        for(int i=0; i<listaDetalleAux.size(); i++){
            Producto productoAux = leerProducto(listaDetalleAux.get(i).getCodigoPorducto());
            int totalActual = productoAux.getCantExistencias() + listaDetalleAux.get(i).getCantProducto();
            actualizarProducto(productoAux.getCodigo(),  productoAux.getNombre(),  productoAux.getDescripcion(),  productoAux.getValorUntirario(),
                    productoAux.getCantExistencias(),  productoAux.getRefrigeracionRecomendada(),  productoAux.getPaisOrigen(),  productoAux.getFechaVencimiento(),
                    productoAux.getPesoEnvase(),  productoAux.getPaisOrigen());
        }
    }
    /**
     * Esta funcion sirve para generar un detalle, esto sirve porque las transaccion recibe una lista de detalles
     * con lo cual esta funcion puede ayudar a generar la lista de detalles desde la interfaz
     * @param nombre
     * @param codigoProducto
     * @param cant
     * @param precioUnitario
     * @return 
     */
    public Detalle generarCompra (String nombre, String codigoProducto, int cant, double precioUnitario){
        Detalle detalleAux = new Detalle(nombre, codigoProducto, cant, precioUnitario);
        return detalleAux;
    }
    public ArrayList<Producto> getListaProductos (){
        return listaProductos;
    }
}

