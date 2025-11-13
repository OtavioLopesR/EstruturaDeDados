package linkedstackdao.dao;

import linkedstackdao.dao.repository.LinkedStack;
import linkedstackdao.dao.repository.Stackable;
import linkedstackdao.model.Car;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Otavio Lopes Rocha
 */
public class CarDAOLinkedStack implements CarDAO {

    private Stackable<Car> cars = new LinkedStack<>(20);

    // Operações básicas CRUD
    @Override
    public void addCar(Car car) {
        cars.push(car);
    }

    @Override
    public Car getCar(String plateLicense) {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Car carro = null;
        Car atual;

        while (!cars.isEmpty()) {
            atual = cars.pop();
            aux.push(atual);
            if (atual.getLicensePlate().equals(plateLicense)) {
                carro = atual;
                break;
            }
        }

        //re-empilha a pilha auxiliar na original
        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }

        return carro;
    }

    @Override
    public Car[] getAllCars() {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Car[] carros = new Car[20];

        int i = 0;
        Car atual;

        while (!cars.isEmpty()) {
            atual = cars.pop();
            aux.push(atual);
            carros[i] = atual;
            i++;
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }

        return carros;
    }

    @Override
    public void updateCar(Car newCar) {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Car atual;

        while (!cars.isEmpty()) {
            atual = cars.pop();
            if (atual.getLicensePlate().equals(newCar.getLicensePlate())) {
                cars.push(newCar);
                break;
            }
            aux.push(atual);
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }
    }

    @Override
    public Car deleteCar(String plateLicense) {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Car removido = null;
        Car atual;

        while (!cars.isEmpty()) {
            atual = cars.pop();
            if (atual.getLicensePlate().equals(plateLicense)) {
                removido = atual;
                break;
            }
            aux.push(atual);
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }

        return removido;
    }

    // Operações de consulta específicas para carros
    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Car carro = null;
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.pop();
            aux.push(atual);
            if (atual.getLicensePlate().equals(licensePlate)) {
                carro = atual;
                break;
            }
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }

        return carro;
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Car[] carros = new Car[20];

        int i = 0;
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.pop();
            aux.push(atual);
            if (atual.getMark().equals(mark)) {
                carros[i] = atual;
                i++;
            }
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }

        return carros;
    }

    @Override
    public Car[] getCarsByModel(String model) {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Car[] carros = new Car[20];

        int i = 0;
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.pop();
            aux.push(atual);
            if (atual.getModel().equals(model)) {
                carros[i] = atual;
                i++;
            }
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }

        return carros;
    }

    @Override
    public Car[] getCarsByColor(String color) {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Car[] carros = new Car[20];

        int i = 0;
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.pop();
            aux.push(atual);
            if (atual.getColor().equals(color)) {
                carros[i] = atual;
                i++;
            }
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }

        return carros;
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Car[] carros = new Car[20];

        int i = 0;
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.pop();
            aux.push(atual);
            if (atual.getOwnerName().equals(owner)) {
                carros[i] = atual;
                i++;
            }
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }

        return carros;
    }

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Car[] carros = new Car[20];

        int i = 0;
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.pop();
            aux.push(atual);
            //se esta entre o tempo especificado
            if (atual.getArrived().isAfter(initialMoment) || atual.getArrived().isBefore(finalMoment)) {
                carros[i] = atual;
                i++;
            }
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }

        return carros;
    }

    // Operações de análise e estatísticas
    @Override
    public Car getCarByNewestArrival() {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Car carro = null;

        //assume que o mais novo é o topo da pilha
        if (!cars.isEmpty()) {
            carro = cars.pop();
            aux.push(carro);
        }
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.pop();
            aux.push(atual);
            // se carro atual chegou depois do carro mais novo o atribui como mais novo
            if (atual.getArrived().isAfter(carro.getArrived())) {
                carro = atual;
            }
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }

        return carro;
    }

    @Override
    public Car getCarByOldestArrival() {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Car carro = null;

        //assume que o mais velho é o topo da pilha
        if (!cars.isEmpty()) {
            carro = cars.pop();
            aux.push(carro);
        }
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.pop();
            aux.push(atual);
            // se carro atual chegou depois do carro mais velho o atribui como mais velho
            if (atual.getArrived().isBefore(carro.getArrived())) {
                carro = atual;
            }
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }

        return carro;
    }

    // Operações de relatório e estatísticas
    @Override
    public String printCars() {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        String s = "";
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.pop();
            s += atual.toString();
            aux.push(atual);
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }

        return s;
    }

    @Override
    public int getTotalCars() {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        int total = 0;
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.pop();
            total++;
            aux.push(atual);
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }

        return total;
    }

    @Override
    public String getMostPopularMark() {
        if (cars.isEmpty()) {
            return null;
        }

        LinkedStack<Car> aux = new LinkedStack<>(20);
        Map<String, Integer> contador = new HashMap<>();
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.pop();
            aux.push(atual);

            String mark = atual.getMark();
            contador.put(mark, contador.getOrDefault(mark, 0) + 1);
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
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
            return null;
        }

        LinkedStack<Car> aux = new LinkedStack<>(20);
        Map<String, Integer> contador = new HashMap<>();

        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.pop();
            aux.push(atual);

            String model = atual.getModel();
            contador.put(model, contador.getOrDefault(model, 0) + 1);
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
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
            return null;
        }
        Car atual;
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Map<String, Integer> contador = new HashMap<>();

        while (!cars.isEmpty()) {
            atual = cars.pop();
            aux.push(atual);

            String color = atual.getColor();
            contador.put(color, contador.getOrDefault(color, 0) + 1);
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
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
        LinkedStack<Car> aux = new LinkedStack<>(20);
        boolean isIn = false;
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.pop();
            aux.push(atual);
            if (atual.getLicensePlate().equals(plateLicense)) {
                isIn = true;
                break;
            }
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }

        return isIn;
    }

    @Override
    public void clearAllCars() {
        while (!cars.isEmpty()) {
            cars.pop();
        }
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Car atual;
        while (!cars.isEmpty()) {
            // remove todos os carros da original
            atual = cars.pop();
            // adiciona carros mais novos que a data especificada na lista auxiliar
            if (atual.getArrived().isAfter(date)) {
                aux.push(atual);
            }
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Car[] carros = new Car[20];
        int i = 0;
        Car atual;
        int horaAtual = LocalDateTime.now().getHour();
        int horaChegada;
        while (!cars.isEmpty()) {
            atual = cars.pop();
            //se esta entre intervalo de tempo especifico
            horaChegada = atual.getArrived().getHour() - horaAtual;
            if (horaChegada >= minHours || horaChegada <= maxHours) {
                carros[i] = atual;
                i++;
            }
            aux.push(atual);
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
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
        LinkedStack<Car> aux = new LinkedStack<>(20);
        int espaco = 20;
        while (!cars.isEmpty()) {
            aux.push(cars.pop());
            espaco--;
        }
        while (!aux.isEmpty()) {
            cars.push(aux.pop());
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
        LinkedStack<Car> aux = new LinkedStack<>(20);
        int i = 0;
        while (!cars.isEmpty()) {
            aux.push(cars.pop());
            i++;
        }
        while (!aux.isEmpty()) {
            cars.push(aux.pop());
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
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Car atual;
        while (!cars.isEmpty()) {
            // remove todos os carros da original
            atual = cars.pop();
            // adiciona carros quais nomes de dono não são iguais ao dono especificado
            if (!atual.getOwnerName().equals(owner)) {
                aux.push(atual);
            }
        }

        while (!aux.isEmpty()) {
            cars.push(aux.pop());
        }
    }

    @Override
    public long getAverageArrivalTime() {
        if (cars.isEmpty()) {
            return 0;
        }
        LinkedStack<Car> aux = new LinkedStack<>(20);
        long soma = 0;
        int count = 0;
        Car atual;
        while (!cars.isEmpty()) {
            atual = cars.pop();
            aux.push(atual);
            count++;
            soma += atual.getArrived().toEpochSecond(ZoneOffset.UTC);
        }

        return (count == 0) ? 0 : soma / count;
    }

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        LinkedStack<Car> aux = new LinkedStack<>(20);
        Car[] carros = new Car[20];

        int i = 0;
        Car atual;
        long horas;
        while (!cars.isEmpty()) {
            atual = cars.pop();
            aux.push(atual);

            horas = java.time.Duration.between(atual.getArrived(), LocalDateTime.now()).toHours();
            if (horas >= thresholdHours) {
                carros[i] = atual;
                i++;
            }
        }
        return carros;
    }
}
