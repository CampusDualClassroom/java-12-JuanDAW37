package com.campusdual.classroom;

public class Exercise12 {
    public static void main(String[] args) {
        System.out.println("******Instanciamos un vehículo******");
        Car coche = new Car("Toyota", "Auris", "Diésel");

        System.out.println("******Encender el coche comprobando el valor correcto del tacómetro (investigar cuál es el valor correcto)******");
        coche.start();

        System.out.println("******Apagar el coche comprobando que el valor del tacómetro es correcto******");
        coche.speedometer = 0;
        coche.tachometer = 0;
        coche.stop();

        System.out.println("******Apagar el coche mientras todavía está en movimiento (y comprobar que no se puede)******");
        coche.start();
        coche.gear ="D";
        coche.tachometer = 1000;
        coche.speedometer = 30;
        coche.stop();

        System.out.println("******Acelerar el coche******");
        coche.start();
        coche.speedometer += 30;
        coche.gear = "D";
        coche.accelerate();

        System.out.println("******Acelerar hasta intentar superar la velocidad máxima (y comprobar que no se puede)******");
        coche.speedometer += 60;
        coche.accelerate();

        System.out.println("******Frenar la velocidad******");
        coche.speedometer -= 20;
        coche.brake();

        System.out.println("******Frenar hasta un valor negativo (y comprobar que no se puede)******");
        coche.speedometer = -5;
        coche.tachometer = 0;
        coche.brake();

        System.out.println("******Girar el volante 20 grados******");
        coche.turnAngleOfWheels(20);

        System.out.println("******Girar el volante más de 45 grados ó -45 grados (y comprobar que no se puede)******");
        coche.turnAngleOfWheels(60);
        coche.turnAngleOfWheels(-50);

        System.out.println("******Detener el coche y poner marcha atrás******");
        coche.speedometer = 0;
        coche.brake();
        coche.gear ="N";
        coche.setReverse(true);

        System.out.println("******Poner marcha atrás mientras el coche está en movimiento marcha adelante (y comprobar que no se puede)******");
        coche.start();
        coche.speedometer = 30;
        coche.gear ="N";
        coche.tachometer = 1000;
        coche.accelerate();
        coche.setReverse(true);
    }
}