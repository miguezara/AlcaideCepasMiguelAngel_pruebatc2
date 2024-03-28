
package com.mycompany.turnoprueba.logica;


public class ValidaDni {
    
    public static boolean validarDNI(String dni) {
        try {
            // Verificar el formato del DNI
            if (!dni.matches("\\d{8}[A-HJ-NP-TV-Za-hj-np-tv-z]")) {
                throw new IllegalArgumentException("El formato del DNI es incorrecto");
            }
            
            // Extraer número y letra del DNI
            String numeroStr = dni.substring(0, 8);
            String letraProvided = dni.substring(8).toUpperCase();
            
            // Calcular la letra esperada
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            int numero = Integer.parseInt(numeroStr);
            char letraEsperada = letras.charAt(numero % 23);
            
            // Comparar la letra proporcionada con la letra esperada
            return letraProvided.charAt(0) == letraEsperada;
        } catch (Exception e) {
            // Manejar la excepción
            System.err.println("Error al validar el DNI: " + e.getMessage());
            return false; 
        }
    }
}



