package proyecto_recursiva;

public class Calculadora {
    
    public int resolver(String texto) {
    texto = texto.replace(" ", "");

    int inicio = texto.lastIndexOf('(');
    if (inicio != -1) {
        int fin = texto.indexOf(')', inicio);

        if (fin == -1) {
            throw new IllegalArgumentException("Paréntesis incompletos");
        }

        int valor = resolver(texto.substring(inicio + 1, fin));
        texto = texto.substring(0, inicio) + valor
                + texto.substring(fin + 1);

        return resolver(texto);
    }

    // Multiplicación
    for (int i = 1; i < texto.length(); i++) {
        if (texto.charAt(i) == '*') {
            int inicioA = i - 1;
            while (inicioA > 0
                    && Character.isDigit(texto.charAt(inicioA - 1))) {
                inicioA--;
            }

            int inicioB = i + 1;
            int finB = inicioB;

            if (finB < texto.length()
                    && (texto.charAt(finB) == '-' || texto.charAt(finB) == '+')) {
                finB++;
            }

            while (finB < texto.length()
                    && Character.isDigit(texto.charAt(finB))) {
                finB++;
            }

            int a = Integer.parseInt(texto.substring(inicioA, i));
            int b = Integer.parseInt(texto.substring(inicioB, finB));

            texto = texto.substring(0, inicioA) + (a * b)
                    + texto.substring(finB);

            return resolver(texto);
        }
    }

    // Suma y resta
    for (int i = 1; i < texto.length(); i++) {
        char operador = texto.charAt(i);

        if (operador == '+' || operador == '-') {
            int inicioA = i - 1;
            while (inicioA > 0
                    && Character.isDigit(texto.charAt(inicioA - 1))) {
                inicioA--;
            }

            int inicioB = i + 1;
            int finB = inicioB;

            if (finB < texto.length()
                    && (texto.charAt(finB) == '-' || texto.charAt(finB) == '+')) {
                finB++;
            }

            while (finB < texto.length()
                    && Character.isDigit(texto.charAt(finB))) {
                finB++;
            }

            int a = Integer.parseInt(texto.substring(inicioA, i));
            int b = Integer.parseInt(texto.substring(inicioB, finB));
            int resultado = operador == '+' ? a + b : a - b;

            texto = texto.substring(0, inicioA) + resultado
                    + texto.substring(finB);

            return resolver(texto);
        }
    }

    return Integer.parseInt(texto);
}
}