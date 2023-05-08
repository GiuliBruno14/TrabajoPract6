
package Entidades;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class DirectorioTelefonico {
    private Map<Long,Cliente> clientes;

    public DirectorioTelefonico() {
        clientes = new HashMap<>();
    }
    
    public boolean agregarCliente(Cliente c, Long telefono){
        boolean resultado = false;
        if (!clientes.containsKey(telefono)){
            clientes.put(telefono, c);
            resultado =true;
        }
        return resultado;
    }
    
    public Cliente buscarCliente(Long telefono){
        Cliente c;
        if(clientes.containsKey(telefono)){
            c = clientes.get(telefono);
        } else {
            c = null;
        }
        return c;
    }
    
    public void buscarTelefono(String apellido){
        for(Map.Entry<Long, Cliente> pareja:clientes.entrySet()){
            if(pareja.getValue().getApellido().equals(apellido)){
                System.out.println(pareja.getValue());
                System.out.println("Numero de telefono asociado:"+pareja.getKey());
                System.out.println("");
            }
        }
    }
    
    public void buscarClientes(String ciudad){
        Collection valores = clientes.values();
        Iterator it = valores.iterator();
        while(it.hasNext()){
            Cliente c =(Cliente)it.next();
            if (c.getCiudad().equals(ciudad)){
                System.out.println(c);
            }
        }   
    }
    
    public void borrarCliente(Long telefono){
        if (clientes.containsKey(telefono)){
            clientes.remove(telefono);
            System.out.println("Cliente eliminado");
        } else {
            System.out.println("No se encontro al ciente que desea eliminar");
        }
    } 
    
    public void mostrarClientes(){ //Primera forma de recorrer el mapa por valores
        Collection valores = clientes.values();
        Iterator it = valores.iterator();
        while(it.hasNext()){
            Cliente c = (Cliente)it.next();
            System.out.println("El paciente es:"+c);
        }
    }
}
