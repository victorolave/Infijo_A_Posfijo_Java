package Infijo_a_Posfijo;

public class Pila 
{
    //Atributos
    
    private Object VectorPila[];
    private int tope;
    private int max;
    
    //Constructor Parametrizado
    public Pila(int max)
    {
        this.max = max;
        this.tope = 0;
        this.VectorPila = new Object [max];        
    }
    
    //Revision si la pila esta vacia
    public boolean PilaVacia()
    {
        if(tope == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //Revision si la pila esta llena
    public boolean PilaLlena()
    {
        if(this.tope == this.max)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //Metodo para vaciar la pila
    public void VaciarPila()
    {
        this.tope = 0;
    }
    
    //Metodo de Apilar
    public boolean Apilar(Object dato)
    {
        if (this.PilaLlena())
        {
            System.out.println("---- PILA LLENA ----");
        }
        else
        {
            VectorPila[tope] = dato;
            tope++;
        }
        return true;
    }
    
    //Metodo de Desapilar
    public Object Desapilar()
    {
        Object dato = null;
        
        if (this.PilaVacia())
        {
            System.out.println("---- PILA VACIA ----");
        }
        else
        {
            dato = VectorPila[tope--];
        }
        return VectorPila [tope];
    }
  
    public Object elementoTope()
    {
        return VectorPila[tope-1];
    }
}
