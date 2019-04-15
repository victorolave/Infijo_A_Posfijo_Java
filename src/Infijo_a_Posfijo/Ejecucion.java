/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infijo_a_Posfijo;

import java.util.Scanner;

/**
 *
 * @author Victor Olave
 */
public class Ejecucion {
   
   public static String expresion = null;
   
    public static void main (String[] args)
    {
        int opcion = 0;
        Evaluador evaluador = new Evaluador ();
        Ejecucion ejecucion = new Ejecucion ();
        Pila pila = new Pila (100);
        Scanner lector = new Scanner (System.in);
        
          
        
        do
        {
            System.out.println("__________________________________________");
            System.out.println("__________________ MENU __________________");
            System.out.println("    1. Ingresar expresion                 ");         
            System.out.println("    2. Mostrar expresion en forma infija  ");
            System.out.println("    3. Mostrar expresion en forma posfija ");
            System.out.println("    4. Vaciar                             ");
            System.out.println("    5. Salir                              ");
            System.out.println("__________________________________________");
            System.out.println("    DIGITE UNA OPCION                     ");
            opcion = lector.nextInt();
            System.out.println("__________________________________________");
            
            switch (opcion)
            {
               case 1 :
                   
                    ejecucion.Ingresar();
                     
               break;
                  
                case 2 :
                    if(expresion != null)
                    {
                    System.out.println("La expresion en su forma infija es :");
                    System.out.println(""+expresion);
                    }
                    else
                    {
                        System.out.println("No has ingresado ninguna expresion!!");
                    }
                break;
                
                case 3 :
                    if(expresion != null)
                    {
                        evaluador.Evaluar(expresion); 
                    }
                    else
                    {
                        System.out.println("No has ingresado ninguna expresion!!");
                    }
                break;
                
                case 4 :
                    
                    try
                    {
                       pila.VaciarPila();
                       expresion = null;
                       System.out.println("DATOS EN CERO!");
                    }
                    catch (Exception e)
                    {
                        System.out.println("No se pudo vaciar la pila");
                    }
                    
                break;
                
            }
                    
        }
        while (opcion != 5);
    }
    
    //Metodo para ingrasar la expresion
    public void Ingresar()
    {
         Scanner lector = new Scanner (System.in);
         
         System.out.println("Ingrese Expresion");
         expresion = lector.nextLine();
         System.out.println("EXPRESION GUARDADA!");
         
    }
    
}
