/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author diegobarrera
 */
public class inicio {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int opcion = 0;
        
        do {
            System.out.println("---------------------------");
            System.out.println(" Aplicacion de mensajes");
            System.out.println(" 1. Crear mensaje");
            System.out.println(" 2. Listar mensajes");
            System.out.println(" 3. Editar mensaje");
            System.out.println(" 4. Eliminar mensaje");
            System.out.println(" 5. Salir");
            // Leemos la opcion del usuario
            opcion = sc.nextInt();
            
            switch(opcion) {
                case 1:
                    mensajesService.crearMensaje();
                    break;
                case 2:
                    mensajesService.listarMensajes();
                    break;
                case 3:
                    mensajesService.borrarMensaje();
                    break;
                case 4:
                    mensajesService.editarMensaje();
                    break;
                default:
                    break;
            }
            
        } while(opcion != 5);
        
/*
        Conexion conexion = new Conexion();
        
        try(Connection cnx = conexion.get_connection()) {
        
        } catch(Exception e) {
            System.out.println(e);
        }
*/
    }
}
