package Infijo_a_Posfijo;
 
public class Evaluador 
{

    //Este metodo establece el tipo de caracter
    public static String Operadore(String exp)
    {
        String datoSalida = "";
        
        for (int i = 0 ; i < exp.length() ; i++)
        {
            if(esOperador(exp.charAt(i)))
            {
                datoSalida += exp.charAt(i);
            }
        }
        return datoSalida;
    }
    
    //Metodo que resive la expresion y la pasa a el metodo de conversion
    public void Evaluar(String infija)
    {     
        String posfija = convertir(infija);
        posfija = posfija.replaceAll("[()]","");
        
        System.out.println("La expresion postfija es: ");
        System.out.println(" "+posfija+" ");      
    }
    
    //Metodo de conversion de infija a posfija
    public static String convertir(String infija)
    {
        String posfija = "";
        Pila pila = new Pila(100);
        
        //Evalua el recorrido del  string caracte por caracter
        for (int i = 0; i < infija.length() ; i++)
        {
            char letra = infija.charAt(i);
            // Si es un operador entonces lo apila
            if(esOperador (infija.charAt(i)))
            {
                if(pila.PilaVacia())
                {
                    pila.Apilar(letra);
                }
                else
                {
                    //Evalua su prioridad o jerarquia con la prioridad en la pila
                    int pe = prioridadEnExpresion(letra);
                    int pp = prioridadEnPila((char)pila.elementoTope());
                    
                    if (pe > pp)
                    {
                        pila.Apilar(letra);
                    }
                    else
                    {
                        posfija += pila.Desapilar();
                        pila.Apilar(letra);
                    }
                }
            }
            else
            {
                posfija += letra;
            }
        }
        //Vacia la pila para que no queden operadores
        while (!pila.PilaVacia())
        {
            posfija += pila.Desapilar();
        }
        return posfija;
    }
    
    //Metodo para evaluar la jerarquia de operaciones de la expresion
    private static int prioridadEnExpresion (char operador)
    {
         if (operador == '^') 
         {
             return 4;
         }
         if (operador == '*' || operador == '/') 
         {
             return 2;
         }
         if (operador == '+' || operador == '-') 
         {
             return 1;
         }
         if (operador == '(' ) 
         {
             return 5;
         }
         return 0;
    }
    
    //Metodo para evaluar la jerarquia de operaciones en la pila
    private static int prioridadEnPila (char operador)
    {
         if (operador == '^') 
         {
             return 3;
         }
         if (operador == '*' || operador == '/') 
         {
             return 1;
         }
         if (operador == '+' || operador == '-') 
         {
             return 2;
         }
         if (operador == '(' ) 
         {
             return 0;
         }
         return 0;
    }
      
    //Determina si el caracter es un operador o un entero
    //En caso tal de ser operador lo apila, y en caso de ser caracter lo envia a postfijo
    private static boolean esOperador (char letra)
    {
        if (letra =='^' || letra =='*' || letra =='/' || letra =='+'|| letra =='-' || letra =='(' || letra ==')')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
       
}
