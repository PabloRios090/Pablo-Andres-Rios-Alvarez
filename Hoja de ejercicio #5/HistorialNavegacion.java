
package com.mycompany.historialnavegacion;
import java.util.ArrayList;

public class HistorialNavegacion {

    private ArrayList<String> historial;
    private static final int LIMITE_MAXIMO = 10;
    
    public HistorialNavegacion() {
        this.historial = new ArrayList<>();
    }

    public void visitarPagina(String url) {
        historial.add(url);
        System.out.println("Visitando: " + url);

        if (historial.size() > LIMITE_MAXIMO) {
            String eliminada = historial.remove(0);
            System.out.println("-> [Límite superado] Se eliminó del historial: " + eliminada);
        }
    }

    public void mostrarHistorial() {
        System.out.println("\n--- HISTORIAL DE NAVEGACIÓN (" + historial.size() + "/" + LIMITE_MAXIMO + ") ---");
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío.");
        } else {
            for (int i = 0; i < historial.size(); i++) {
                System.out.println((i + 1) + ". " + historial.get(i));
            }
        }
        System.out.println("----------------------------------------------\n");
    }

    public static void main(String[] args) {
        HistorialNavegacion miHistorial = new HistorialNavegacion();

        System.out.println("=== Agregando las primeras 10 páginas ===");
        miHistorial.visitarPagina("https://google.com");
        miHistorial.visitarPagina("https://youtube.com");
        miHistorial.visitarPagina("https://github.com");
        miHistorial.visitarPagina("https://wikipedia.org");
        miHistorial.visitarPagina("https://stackoverflow.com");
        miHistorial.visitarPagina("https://canvas.umg.edu.gt");
        miHistorial.visitarPagina("https://facebook.com");
        miHistorial.visitarPagina("https://twitter.com");
        miHistorial.visitarPagina("https://linkedin.com");
        miHistorial.visitarPagina("https://netflx.com");

        miHistorial.mostrarHistorial();

        System.out.println("=== Agregando 2 páginas extra para probar el borrado automático ===");
        miHistorial.visitarPagina("https://spotify.com"); 
        miHistorial.visitarPagina("https://amazon.com");  

        miHistorial.mostrarHistorial();
    }
}