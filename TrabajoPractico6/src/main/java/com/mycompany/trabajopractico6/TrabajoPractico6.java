
package com.mycompany.trabajopractico6;

import Entidades.Cliente;
import Entidades.DirectorioTelefonico;
import java.util.Scanner;

public class TrabajoPractico6 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Scanner leer2 = new Scanner(System.in);
        DirectorioTelefonico t = new DirectorioTelefonico();
        int op =0;
        while(op!=7){
            System.out.println("Menu");
            System.out.println("1. Agregar cliente.");
            System.out.println("2. Buscar cliente por numero de telefono.");
            System.out.println("3. Buscar numero de telefono en base al apellido.");
            System.out.println("4. Buscar clientes pertenecientes a cierta ciudad");
            System.out.println("5. Borrar cliente");
            System.out.println("6. Mostrar lista de clientes");
            System.out.println("7. Salir");
            op = leer2.nextInt();
            switch(op){
                case 1:
                    Cliente c1 = new Cliente();
                    System.out.println("DNI:");
                    c1.setDni(leer2.nextInt());
                    System.out.println("Nombre:");
                    c1.setNombre(leer.nextLine());
                    System.out.println("Apellido:");
                    c1.setApellido(leer.nextLine());
                    System.out.println("Ciudad:");
                    c1.setCiudad(leer.nextLine());
                    System.out.println("Direccion: ");
                    c1.setDireccion(leer.nextLine());
                    System.out.println("Telefono: ");
                    long telefono = leer2.nextLong();
                    Long tel = Long.valueOf(telefono);
                    if (t.agregarCliente(c1, tel)){
                        System.out.println("Cliente agregado exitosamente");
                    } else {
                        System.out.println("Cliente duplicado");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el numero de telefono que desea buscar");
                    telefono = leer2.nextLong();
                    tel = Long.valueOf(telefono);
                    if (t.buscarCliente(tel) == null){
                        System.out.println("No se encontro al cliente");
                    }else {
                        System.out.println("El cliente es: "+t.buscarCliente(tel));
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el apellido:");
                    String apellido = leer.nextLine();
                    t.buscarTelefono(apellido);
                    break;
                case 4: 
                    System.out.println("Ingrese la ciudad");
                    String ciudad = leer.nextLine();
                    t.buscarClientes(ciudad);
                    break;
                case 5:
                    System.out.println("Ingrese el numero de telefono del cliente que desea borrar");
                    telefono = leer2.nextLong();
                    tel = Long.valueOf(telefono);
                    t.borrarCliente(telefono);
                    break;
                case 6:
                    t.mostrarClientes();
                    break;
                default:
                    break;
            }
        }
        
        
    }
}
