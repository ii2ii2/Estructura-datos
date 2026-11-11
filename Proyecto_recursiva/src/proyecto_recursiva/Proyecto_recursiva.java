package proyecto_recursiva;
public class Proyecto_recursiva {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        
        System.out.println(calculadora.resolver("7+10+2")); 
        System.out.println(calculadora.resolver("1+5*(7-1)+10")); 
        System.out.println(calculadora.resolver("5+7+(1+2*(8-9)+2)-10"));
        System.out.println(calculadora.resolver("9-2*(75-9+(6+3+(1+2)*1)+7)+9"));
    }
    
}
