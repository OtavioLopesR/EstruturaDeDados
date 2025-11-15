package linkedlistdao.dao;

import linkedlistdao.dao.repository.LinkedList;
import linkedlistdao.dao.repository.Listable;
import linkedlistdao.model.Car;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

public class CarDAOLinkedList implements CarDAO {

    private Listable<Car> cars = new LinkedList<>(20);

    // Operações básicas CRUD
    @Override
    public void addCar(Car car) {
        cars.append(car);
    }

    @Override
    public Car getCar(String plateLicense) {
        for (int i = 0; i < cars.size(); i++) {
           if (cars.select(i).getLicensePlate().equals(plateLicense)){
               return cars.select(i);
           } 
        }
        return null;
    }

    @Override
    public Car[] getAllCars() {
        return cars.selectAll();
    }

    @Override
    public void updateCar(Car newCar) {
        for (int i = 0; i < cars.size(); i++) {
           if (cars.select(i).getLicensePlate().equals(newCar.getLicensePlate())){
               cars.update(i, newCar);
           } 
        }
    }

    @Override
    public Car deleteCar(String plateLicense) {
        for (int i = 0; i < cars.size(); i++) {
           if (cars.select(i).getLicensePlate().equals(plateLicense)){
               return cars.delete(i);
           } 
        }
        return null;
    }

    // Operações de consulta específicas para carros
    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        return getCar(licensePlate);
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        Car[] carros = new Car[20];
        for (int i = 0; i < cars.size(); i++) {
           if (cars.select(i).getMark().equals(mark)){
               carros[i] = cars.select(i);
           } 
        }
        return carros;
    }

    @Override
    public Car[] getCarsByModel(String model) {
        Car[] carros = new Car[20];
        for (int i = 0; i < cars.size(); i++) {
           if (cars.select(i).getModel().equals(model)){
               carros[i] = cars.select(i);
           } 
        }
        return carros;
    }

    @Override
    public Car[] getCarsByColor(String color) {
        Car[] carros = new Car[20];
        for (int i = 0; i < cars.size(); i++) {
           if (cars.select(i).getColor().equals(color)){
               carros[i] = cars.select(i);
           } 
        }
        return carros;
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        Car[] carros = new Car[20];
        for (int i = 0; i < cars.size(); i++) {
           if (cars.select(i).getOwnerName().equals(owner)){
               carros[i] = cars.select(i);
           } 
        }
        return carros;
    }

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        Car[] carros = new Car[20];
        Car carro;
        for (int i = 0; i < cars.size(); i++) {
            carro = cars.select(i);
            if ( carro.getArrived().isAfter(initialMoment) || carro.getArrived().isAfter(initialMoment)){
               carros[i] = cars.select(i);
            } 
        }
        return carros;
    }

    // Operações de análise e estatísticas
    @Override
    public Car getCarByNewestArrival() {
        if (cars.isEmpty()) return null;
        Car carro = cars.select(0);
        Car atual;
        for (int i = 0; i < cars.size(); i++) {
            atual = cars.select(i);
            if (atual.getArrived().isAfter(carro.getArrived())){
                carro = atual;
            }
        }
        return carro;
    }

    @Override
    public Car getCarByOldestArrival() {
        if (cars.isEmpty()) return null;
        Car carro = cars.select(0);
        Car atual;
        for (int i = 0; i < cars.size(); i++) {
            atual = cars.select(i);
            if (atual.getArrived().isBefore(carro.getArrived())){
                carro = atual;
            }
        }
        return carro;
    }

    // Operações de relatório e estatísticas
    @Override
    public String printCars() {
        String s = "";
        for (int i = 0; i < cars.size(); i++) {
            s += cars.select(i).toString();
        }
        return s;
    }

    @Override
    public int getTotalCars() {
        int j = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.select(i)!=null){
                j++;
            }
        }
        return j;
    }

    @Override
    public String getMostPopularMark() {
        if (cars.isEmpty()) {
            return " ";
        }
        
        LinkedList<Car> aux = new LinkedList<>(20);
        Map<String, Integer> contador = new HashMap<>();
        Car atual;
        String marca;
        for (int i = 0; i < cars.size(); i++){
            atual = cars.select(i);
            marca = atual.getMark();
            contador.put(marca, contador.getOrDefault(marca, 0) + 1);
        }
        
        String marcaPopular = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                marcaPopular = entry.getKey();
            }
        }
        
        return marcaPopular;
    }

    @Override
    public String getMostPopularModel() {
        if (cars.isEmpty()) {
            return " ";
        }
        
        LinkedList<Car> aux = new LinkedList<>(20);
        Map<String, Integer> contador = new HashMap<>();
        Car atual;
        String modelo;
        for (int i = 0; i < cars.size(); i++){
            atual = cars.select(i);
            modelo = atual.getModel();
            contador.put(modelo, contador.getOrDefault(modelo, 0) + 1);
        }
        
        String modeloPopular = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                modeloPopular = entry.getKey();
            }
        }
        
        return modeloPopular;
    }

    @Override
    public String getMostPopularColor() {
        if (cars.isEmpty()) {
            return " ";
        }
        
        LinkedList<Car> aux = new LinkedList<>(20);
        Map<String, Integer> contador = new HashMap<>();
        Car atual;
        String cor;
        for (int i = 0; i < cars.size(); i++){
            atual = cars.select(i);
            cor = atual.getColor();
            contador.put(cor, contador.getOrDefault(cor, 0) + 1);
        }
        
        String corPopular = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                corPopular = entry.getKey();
            }
        }
        
        return corPopular;
    }

    // Operações de gerenciamento
    @Override
    public boolean isCarInPlaced(String plateLicense) {
        return getCar(plateLicense) != null;
    }

    @Override
    public void clearAllCars() {
        cars.clear();
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.select(i).getArrived().isBefore(date)){
                cars.delete(i);
            }
        }
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
        int horaAtual = LocalDateTime.now().getHour();
        int horaChegada;
        Car[] carros = new Car[20];
        for (int i = 0; i < cars.size(); i++) {
            horaChegada = cars.select(i).getArrived().getHour() - horaAtual;
            if (horaChegada >= minHours || horaChegada <= maxHours) {
                carros[i] = cars.select(i);
            }
        }
        return null;
    }

    @Override
    public int getAvailableSpaces() {
        if (cars.isEmpty()) return cars.size();
        if (cars.isFull()) return 0;
        int espaco = cars.size();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.select(i)!=null){
                espaco--;
            }
        }
        return espaco;
    }

    @Override
    public boolean isParkingEmpty() {
        return cars.isEmpty();
    }

    @Override
    public int getMaxCapacity() {
       return cars.size();
    }

    @Override
    public int getOccupancyRate() {
        if (cars.isFull()) return 100;
        if (cars.isEmpty()) return 0;
        int j = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.select(i)!=null){
                j++;
            }
        }
        return (j / cars.size()) * 100;
    }

    @Override
    public boolean isParkingFull() {
        return cars.isFull();
    }

    @Override
    public long getParkingDuration(String plateLicense) {
        Car carro = getCar(plateLicense);
        long minutos = -1;
        if (carro != null) {
            minutos = java.time.Duration.between(carro.getArrived(), LocalDateTime.now()).toMinutes();
        }
        return minutos;
    }

    @Override
    public void removeCarsByOwner(String owner) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.select(i).getOwnerName().equals(owner)){
                cars.delete(i);
            }
        }
    }

    @Override
    public long getAverageArrivalTime() {
        if (cars.isEmpty()) {
            return 0;
        }
        long soma = 0;
        int count = 0;
        Car atual;
        for (int i = 0; i < cars.size();i++){
            atual=cars.select(i);
            count++;
            soma += atual.getArrived().toEpochSecond(ZoneOffset.UTC);
        }
        return (count == 0) ? 0 : soma / count;
    }

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        Car[] carros = new Car[cars.size()];

        Car atual;
        long horas;
        for (int i = 0; i < cars.size();i++){
            atual = cars.select(i);
            horas = java.time.Duration.between(atual.getArrived(), LocalDateTime.now()).toHours();
            if (horas >= thresholdHours) {
                carros[i] = atual;
            }
        }
        return carros;
    }
}