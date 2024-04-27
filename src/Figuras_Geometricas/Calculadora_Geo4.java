package Figuras_Geometricas;

import java.util.Scanner;

// Interfaz para las figuras geométricas
interface FiguraGeometrica {
    double calcularArea();
}

// Clase para representar un círculo
class Circulo implements FiguraGeometrica {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

// Clase para representar un cuadrado
class Cuadrado implements FiguraGeometrica {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}

// Clase para representar un triángulo
class Triangulo implements FiguraGeometrica {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }
}

// Clase para manejar el menú y la lógica principal del programa
public class Calculadora_Geo4 {
    private Scanner scanner;

    public Calculadora_Geo4() {
        scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        while (true) {
            mostrarMenu();
            int opcion = obtenerOpcion();

            if (opcion == 0) {
                break;
            }

            FiguraGeometrica figura = crearFigura(opcion);
            if (figura != null) {
                double resultado = figura.calcularArea();
                System.out.println("El área es: " + resultado);
            }
        }

        scanner.close();
    }

    // Mostrar el menú de opciones
    private void mostrarMenu() {
        System.out.println("Elija una figura Geometrica:");
        System.out.println("1. Círculo");
        System.out.println("2. Figuras_Geometricas.Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("0. Salir");
    }

    // Obtener la opción del usuario
    private int obtenerOpcion() {
        System.out.print("Ingrese Numero: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Ingrese un número.");
            System.out.print("Ingrese Numero ");
            scanner.next(); // Limpia
        }
        return scanner.nextInt();
    }

    // Crear la figura según la opción
    private FiguraGeometrica crearFigura(int opcion) {
        switch (opcion) {
            case 1:
                return crearCirculo();
            case 2:
                return crearCuadrado();
            case 3:
                return crearTriangulo();
            default:
                System.out.println("Número Invalido");
                return null;
        }
    }

    // Funciones para crear cada figura geométrica
    private Circulo crearCirculo() {
        System.out.println("Ingrese el radio del círculo:");
        double radio = scanner.nextDouble();
        return new Circulo(radio);
    }

    private Cuadrado crearCuadrado() {
        System.out.println("Ingrese el lado del cuadrado:");
        double lado = scanner.nextDouble();
        return new Cuadrado(lado);
    }

    private Triangulo crearTriangulo() {
        System.out.println("Ingrese la base del triángulo:");
        double base = scanner.nextDouble();
        System.out.println("Ingrese la altura del triángulo:");
        double altura = scanner.nextDouble();
        return new Triangulo(base, altura);
    }

    public static void main(String[] args) {
        Calculadora_Geo4 calculadora = new Calculadora_Geo4();
        calculadora.ejecutar();
    }
}
