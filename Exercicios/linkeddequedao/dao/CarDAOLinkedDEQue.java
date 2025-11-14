package linkeddequedao.dao;

import linkeddequedao.dao.repository.LinkedDEQue;
import linkeddequedao.dao.repository.DEQueable;
import linkeddequedao.model.Car;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementação do DAO (Data Access Object) para gerenciamento de carros
 * utilizando uma estrutura de dados do tipo fila com dupla terminação (DEQue).
 *
 * Esta classe implementa todas as operações CRUD (Create, Read, Update, Delete)
 * e operações de consulta específicas para carros, mantendo os dados em uma
 * estrutura de fila que preserva a ordem FIFO (First In, First Out).
 *
 * @author Cláudio Rodolfo Sousa de Oliveira
 * @version 1.0
 * @since 2025-10-20
 * @see CarDAO
 * @see Car
 * @see DEQueable
 * @see LinkedDEQue
 */
public class CarDAOLinkedDEQue implements CarDAO {
    
    private DEQueable<Car> cars = new LinkedDEQue<>(20);

    // Operações básicas CRUD
    @Override
    public void addCar(Car car) {
        cars.enqueue(car);
    }
    
    @Override
    public Car getCar(String plateLicense) {
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car carro = null;
        Car atual;
        
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            aux.enqueue(atual);
            if (atual.getLicensePlate().equals(plateLicense)) {
                carro = atual;
            }
        }
        
        while (!aux.isEmpty()) {            
            cars.enqueue(aux.dequeue());
        }
        
        return carro;
    }
    
    @Override
    public Car[] getAllCars() {
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car[] carros = new Car[20];
        Car atual;
        int i = 0;
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            aux.enqueue(atual);
            carros[i] = atual;
        }
        
        while (!aux.isEmpty()) {            
            cars.enqueue(aux.dequeue());
        }
        
        return carros;
    }
    
    @Override
    public void updateCar(Car newCar) {
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car atual;
        
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            if (atual.getLicensePlate().equals(newCar.getLicensePlate())) {
                aux.enqueue(newCar);
            } else {
                aux.enqueue(atual);
            }
        }
        
        while (!aux.isEmpty()) {            
            cars.enqueue(aux.dequeue());
        }
    }
    
    @Override
    public Car deleteCar(String plateLicense) {
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car atual = null;
        
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            if (!atual.getLicensePlate().equals(plateLicense)) {
                aux.enqueue(atual);
            }
        }
        
        while (!aux.isEmpty()) {
            cars.enqueue(aux.dequeue());
        }
        return atual;
    }

    // Operações de consulta específicas para carros
    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        return getCar(licensePlate);
    }
    
    @Override
    public Car[] getCarsByMark(String mark) {
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car[] carros = new Car[20];
        Car atual;
        int i = 0;
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            aux.enqueue(atual);
            if (atual.getMark().equals(mark)) {
                carros[i] = atual;
            }
        }
        
        while (!aux.isEmpty()) {            
            cars.enqueue(aux.dequeue());
        }
        
        return carros;
    }
    
    @Override
    public Car[] getCarsByModel(String model) {
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car[] carros = new Car[20];
        Car atual;
        int i = 0;
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            aux.enqueue(atual);
            if (atual.getModel().equals(model)) {
                carros[i] = atual;
            }
        }
        
        while (!aux.isEmpty()) {            
            cars.enqueue(aux.dequeue());
        }
        
        return carros;
    }
    
    @Override
    public Car[] getCarsByColor(String color) {
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car[] carros = new Car[20];
        Car atual;
        int i = 0;
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            aux.enqueue(atual);
            if (atual.getColor().equals(color)) {
                carros[i] = atual;
            }
        }
        
        while (!aux.isEmpty()) {            
            cars.enqueue(aux.dequeue());
        }
        
        return carros;
    }
    
    @Override
    public Car[] getCarsByOwner(String owner) {
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car[] carros = new Car[20];
        Car atual;
        int i = 0;
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            aux.enqueue(atual);
            if (atual.getOwnerName().equals(owner)) {
                carros[i] = atual;
            }
        }
        
        while (!aux.isEmpty()) {            
            cars.enqueue(aux.dequeue());
        }
        
        return carros;
    }
    
    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car[] carros = new Car[20];
        
        int i = 0;
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            aux.enqueue(atual);
            //se esta entre o tempo especificado
            if (atual.getArrived().isAfter(initialMoment) || atual.getArrived().isBefore(finalMoment)) {
                carros[i] = atual;
                i++;
            }
        }
        
        while (!aux.isEmpty()) {
            cars.enqueue(aux.dequeue());
        }
        
        return carros;
    }

    // Operações de análise e estatísticas
    @Override
    public Car getCarByNewestArrival() {
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car carro = null;

        //assume que o mais novo é o começo da fila
        if (!cars.isEmpty()) {
            carro = cars.dequeue();
            aux.enqueue(carro);
        }
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            aux.enqueue(atual);
            if (atual.getArrived().isAfter(carro.getArrived())) {
                carro = atual;
            }
        }
        
        while (!aux.isEmpty()) {
            cars.enqueue(aux.dequeue());
        }
        
        return carro;
    }
    
    @Override
    public Car getCarByOldestArrival() {
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car carro = null;

        //assume que o mais velho é o começo da fila
        if (!cars.isEmpty()) {
            carro = cars.dequeue();
            aux.enqueue(carro);
        }
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            aux.enqueue(atual);
            if (atual.getArrived().isBefore(carro.getArrived())) {
                carro = atual;
            }
        }
        
        while (!aux.isEmpty()) {
            cars.enqueue(aux.dequeue());
        }
        
        return carro;
    }

    // Operações de relatório e estatísticas
    @Override
    public String printCars() {
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car atual;
        String s = "";
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            aux.enqueue(atual);
            s += atual.toString();
        }
        
        while (!aux.isEmpty()) {
            cars.enqueue(aux.dequeue());
        }
        
        return s;
    }
    
    @Override
    public int getTotalCars() {
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car atual;
        int i = 0;
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            aux.enqueue(atual);
            i++;
        }
        
        while (!aux.isEmpty()) {
            cars.enqueue(aux.dequeue());
        }
        
        return i;
    }
    
    @Override
    public String getMostPopularMark() {
        if (cars.isEmpty()) {
            return " ";
        }
        
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Map<String, Integer> contador = new HashMap<>();
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            aux.enqueue(atual);
            
            String mark = atual.getMark();
            contador.put(mark, contador.getOrDefault(mark, 0) + 1);
        }
        
        while (!aux.isEmpty()) {
            cars.enqueue(aux.dequeue());
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

        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Map<String, Integer> contador = new HashMap<>();
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            aux.enqueue(atual);

            String model = atual.getModel();
            contador.put(model, contador.getOrDefault(model, 0) + 1);
        }

        while (!aux.isEmpty()) {
            cars.enqueue(aux.dequeue());
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
        
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Map<String, Integer> contador = new HashMap<>();
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            aux.enqueue(atual);
            
            String cor = atual.getColor();
            contador.put(cor, contador.getOrDefault(cor, 0) + 1);
        }
        
        while (!aux.isEmpty()) {
            cars.enqueue(aux.dequeue());
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
        return getCar(plateLicense)!= null;
    }
    
    @Override
    public void clearAllCars() {
        while (!cars.isEmpty()) {            
            cars.dequeue();
        }
    }
    
    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car atual;
        while (!cars.isEmpty()) {
            
            atual = cars.dequeue();

            if (atual.getArrived().isBefore(date)) {
                aux.enqueue(atual);
            }
        }

        while (!aux.isEmpty()) {
            cars.enqueue(aux.dequeue());
        }
    }
    
    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car[] carros = new Car[20];
        int i = 0;
        Car atual;
        int horaAtual = LocalDateTime.now().getHour();
        int horaChegada;
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            //se esta entre intervalo de tempo especifico
            horaChegada = atual.getArrived().getHour() - horaAtual;
            if (horaChegada >= minHours || horaChegada <= maxHours) {
                carros[i] = atual;
                i++;
            }
            aux.enqueue(atual);
        }

        while (!aux.isEmpty()) {
            cars.enqueue(aux.dequeue());
        }

        return carros;
    }
    
    @Override
    public int getAvailableSpaces() {
        if (cars.isEmpty()) {
            return 20;
        }
        if (cars.isFull()) {
            return 0;
        }
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        int espaco = 20;
        while (!cars.isEmpty()) {
            aux.enqueue(cars.dequeue());
            espaco--;
        }
        while (!aux.isEmpty()) {
            cars.enqueue(aux.dequeue());
        }
        return espaco;
    }
    
    @Override
    public boolean isParkingEmpty() {
        return cars.isEmpty();
    }
    
    @Override
    public int getMaxCapacity() {
        return 20;
    }
    
    @Override
    public int getOccupancyRate() {
        if (cars.isFull()) {
            return 100;
        }
        if (cars.isEmpty()) {
            return 0;
        }
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        int i = 0;
        while (!cars.isEmpty()) {
            aux.enqueue(cars.dequeue());
            i++;
        }
        while (!aux.isEmpty()) {
            cars.enqueue(aux.dequeue());
        }
        return (i / 20) * 100;
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
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            if (!atual.getOwnerName().equals(owner)) {
                aux.enqueue(atual);
            }
        }

        while (!aux.isEmpty()) {
            cars.enqueue(aux.dequeue());
        }
    }
    
    @Override
    public long getAverageArrivalTime() {
        if (cars.isEmpty()) {
            return 0;
        }
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        long soma = 0;
        int count = 0;
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            aux.enqueue(atual);
            count++;
            soma += atual.getArrived().toEpochSecond(ZoneOffset.UTC);
        }
        while (!aux.isEmpty()) {
            cars.enqueue(aux.dequeue());
        }
        return (count == 0) ? 0 : soma / count;
    }
    
    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        LinkedDEQue<Car> aux = new LinkedDEQue<>(20);
        Car[] carros = new Car[20];

        int i = 0;
        Car atual;
        long horas;
        while (!cars.isEmpty()) {
            atual = cars.dequeue();
            aux.enqueue(atual);

            horas = java.time.Duration.between(atual.getArrived(), LocalDateTime.now()).toHours();
            if (horas >= thresholdHours) {
                carros[i] = atual;
                i++;
            }
        }
        while (!aux.isEmpty()) {            
            cars.enqueue(aux.dequeue());
        }
        return carros;
    }
}
