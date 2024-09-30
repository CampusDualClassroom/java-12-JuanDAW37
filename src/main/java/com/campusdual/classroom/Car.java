package com.campusdual.classroom;

public class Car {
    public String brand;
    public String model;
    public static final  int MAX_SPEED = 120;
    public String fuel;
    public int speedometer = 0;
    public int tachometer = 0;
    public String gear = "N";
    public boolean reverse = false;
    public int wheelsAngle = 0;
    public int initialSpeed;
    public int newSpeed;

    public Car(String brand, String model, String fuel){
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
    }

    public Car(){}

    // Un método booleano que verifique si el valor del tacómetro es cero
    public boolean isTachometerEqualToZero(){
        return this.tachometer == 0  ? true : false;
    }

    // Un método booleano que verifique si el valor del tacómetro es mayor de cero
    public boolean isTachometerGreaterThanZero(){
        return this.tachometer > 0  ? true : false;
    }

    public void start(){
        if (isTachometerEqualToZero()){
            this.tachometer = 1000;
            this.initialSpeed = 5;
            this.newSpeed = this.initialSpeed;
            showDetails("Vehículo encendido");
        }else{
            showDetails("O vehículo xa está encendido");
        }
    }

    public void stop(){
        if (this.speedometer == 0){
            this.gear = "N";
            this.tachometer = 0;
            showDetails("Vehículo apagado");
        }else{
            showDetails("Non se pode apagar o vehículo, ten que estar detido");
        }
    }

    public void accelerate(){
        if (this.speedometer >= MAX_SPEED && isTachometerGreaterThanZero()){
            showDetails("Non se pode acelerar, o vehículo xa vai a súa máxima velocidade " + this.speedometer);
        }else if (gear.equals("N") && isTachometerEqualToZero()){
            showDetails("Non se pode acelerar, o vehículo, está apagado ou parado");
        }else if(isTachometerGreaterThanZero()){
            this.speedometer += this.newSpeed;
            showDetails("Acelerouse o vehículo, e circula a " + this.speedometer);
        }
    }

    public void brake(){
        if (isTachometerGreaterThanZero()){
            this.tachometer = 1000;
            this.newSpeed = this.newSpeed - this.initialSpeed;
            if(this.newSpeed < 0) this.newSpeed = 0;
            this.speedometer = this.newSpeed;
            showDetails("O vehículo freouse.");
        }else if(this.newSpeed < 0 || speedometer < 0){
            this.tachometer = 1000;
            this.newSpeed = this.initialSpeed;
            this.speedometer = this.newSpeed;
            showDetails("O vehículo non pode frearse máis.");
        }
    }

    public void turnAngleOfWheels(int angle){
        if(angle > 0){
            if((angle + this.wheelsAngle >= 0) && (angle + this.wheelsAngle <= 45)){
                this.wheelsAngle += angle;
                showDetails(showSteeringWheelDetail(true, this.wheelsAngle));
            }else{
                this.wheelsAngle = 45;
                showDetails(showSteeringWheelDetail(false, angle));
            }
        }else{
            if((angle - this.wheelsAngle >= -45) && (angle - this.wheelsAngle <= 45)){
                this.wheelsAngle -= angle;
                showDetails(showSteeringWheelDetail(true, this.wheelsAngle));
            }else{
                this.wheelsAngle = -45;
                showDetails(showSteeringWheelDetail(false, angle));
            }
        }
        if (this.tachometer == 0 && this.gear.equals("N")) {
            System.out.println("Non se poden xirar as rodas co vehículo apagado.");
        }

    }

    public String showSteeringWheelDetail(Boolean tf, int angle){
        if(tf){
            return "As rodas foron xiradas " + angle + " grados";
        }else{
            return "As rodas non poden xirarse " + angle + " grados";
        }
    }

    public boolean isReverse(){
        return true;
    }

    public void setReverse(boolean reverse){
        if (this.speedometer > 0){
            this.reverse = false;
            showDetails("Non se pode poñer marcha atrás, o vehículo está en movemento");
        }else if(reverse && this.gear.equals("N")){
            this.reverse = isReverse();
            this.gear="R";
            showDetails("O vehículo ten a marcha atrás posta");
        }else{
            showDetails("Non se pode poñer outra vez a marcha atrás");
        }
    }

    public void showDetails(String detail){
        System.out.println(detail);
    }
}
