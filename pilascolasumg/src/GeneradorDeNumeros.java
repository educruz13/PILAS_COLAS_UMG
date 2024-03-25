import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class GeneradorDeNumeros {
    public static void main(String[] args) {
        generarYGuardarNumeros();
        ordenarYGuardarNumeros("numeros.txt", "numeros_ordenados.txt");
        procesarPilaOCola();
        System.out.println("Se han generado, ordenado y procesado los números.");
    }

    private static void generarYGuardarNumeros() {
        Random random = new Random();
        int min = -10000000;
        int max = 10000000;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("numeros.txt"))) {
            for (int i = 0; i < 20000000; i++) {
                int num = random.nextInt(max - min + 1) + min;
                writer.write(String.valueOf(num));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ordenarYGuardarNumeros(String archivoEntrada, String archivoSalida) {
        List<Integer> numeros = leerNumeros(archivoEntrada);
        Collections.sort(numeros);
        guardarNumeros(numeros, archivoSalida);
    }

    private static List<Integer> leerNumeros(String archivo) {
        List<Integer> numeros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                numeros.add(Integer.parseInt(linea));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numeros;
    }

    private static void guardarNumeros(List<Integer> numeros, String archivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            for (int num : numeros) {
                writer.println(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void procesarPilaOCola() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Ingrese 'cola' o 'pila' para seleccionar cómo procesar los números:");
            String opcion = reader.readLine();
            
            String nombreArchivo = opcion.equals("cola") ? "cola.txt" : opcion.equals("pila") ? "pila.txt" : "numeros.txt";
            if (opcion.equals("cola") || opcion.equals("pila")) {
                if (opcion.equals("cola")) {
                    procesarCola(nombreArchivo);
                } else {
                    procesarPila(nombreArchivo);
                }
            } else {
                System.out.println("Opción no válida. Se procesarán los números en el archivo 'numeros.txt'.");
                procesarPila("numeros.txt");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void procesarPila(String nombreArchivo) {
        Stack<Integer> pila = new Stack<>();
        List<Integer> numeros = leerNumeros("numeros.txt");
        for (Integer num : numeros) {
            pila.push(num);
        }
        guardarNumerosPila(pila, nombreArchivo);
    }

    private static void procesarCola(String nombreArchivo) {
        Queue<Integer> cola = new LinkedList<>();
        List<Integer> numeros = leerNumeros("numeros.txt");
        for (Integer num : numeros) {
            cola.offer(num);
        }
        guardarNumerosCola(cola, nombreArchivo);
    }

    private static void guardarNumerosPila(Stack<Integer> pila, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            writer.println("Números en la pila:");
            while (!pila.isEmpty()) {
                writer.println(pila.pop());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void guardarNumerosCola(Queue<Integer> cola, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            writer.println("Números en la cola:");
            while (!cola.isEmpty()) {
                writer.println(cola.poll());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

