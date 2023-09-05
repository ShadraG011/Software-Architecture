package org.example.hw3;

import java.awt.*;

public class Program {

    /**
     * 1. Спроектировать абстрактный класс «Car» у которого должны
     *  быть свойства: марка, модель, цвет, тип кузова, число колёс, тип
     *  топлива, тип коробки передач, объём двигателя; методы:
     *  движение, обслуживание, переключение передач, включение
     *  фар, включение дворников.
     *
     * 2. Создать конкретный автомобиль путём наследования класса
     *  «Car».
     * 3. Расширить абстрактный класс «Car», добавить метод: подметать
     * улицу. Создать конкретный автомобиль путём наследования
     * класса «Car». Провести проверку принципа SRP.
     *
     * 4. Расширить абстрактный класс «Car», добавить метод:
     * включение противотуманных фар, перевозка груза. Провести
     * проверку принципа OCP.
     *
     * 5. Создать конкретный автомобиль путём наследования класса
     * «Car», определить число колёс = 3. Провести проверку принципа LSP.
     *
     * 6. Создать конкретный автомобиль путём наследования класса
     * «Car», определить метод «движение» - «полёт». Провести
     * проверку принципа LSP.
     *
     * 7. Создать интерфейс «Заправочная станция», создать метод:
     * заправка топливом.
     *
     *
     * 8. Имплементировать метод интерфейса «Заправочная станция» в
     * конкретный класс «Car».
     *
     * 9. Добавить в интерфейс «Заправочная станция» методы: протирка
     * лобового стекла, протирка фар, протирка зеркал.
     *
     * 10. Имплементировать все методы интерфейса «Заправочная
     * станция» в конкретный класс «Car». Провести проверку
     * принципа ISP. Создать дополнительный/е интерфейсы и
     * имплементировать их в конкретный класс «Car». Провести
     * проверку принципа ISP.
     *
     * 11. Создать путём наследования класса «Car» два
     * автомобиля: с бензиновым и дизельным двигателями,
     * имплементировать метод «Заправка топливом» интерфейса
     * «Заправочная станция». Реализовать заправку каждого
     * автомобиля подходящим топливом. Провести проверку принципа DIP.
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Инициализация заправок
         */
        RefuelingStation refuelingStation = new RefuelingStation();
        RefuelingStationV2 refuelingStationV2 = new RefuelingStationV2();

        /**
         * Инициализация автомоек
         */
        WashStation washStation = new WashStation();
        WashStationV2 washStationV2 = new WashStationV2();

        //region Car harvester type
        Harvester harvester = new Harvester("КамАЗ", "КДМ-316", Color.BLACK);

        harvester.setRefuelingStation(refuelingStation);

        harvester.fuel();

        System.out.print("Цена за смену колес: " + calculateMaintenance(harvester) + "\n");

        harvester.setWashingStation(washStationV2);

        harvester.washCar();

        harvester.washInterior();

        System.out.println();
        //endregion

        //region Car sport type
        SportCar sportCar = new SportCar("Porsche", "911", Color.RED);

        sportCar.setRefuelingStation(refuelingStationV2);

        sportCar.fuel();

        System.out.print("Цена за смену колес: " + calculateMaintenance(sportCar) + "\n");

        sportCar.setWashingStation(washStation);

        sportCar.washCar();

        sportCar.washInterior();

        System.out.println();
        //endregion

        //region Car fly type
        FlyCar flyCar = new FlyCar("Tesla", "Roadster", Color.RED);

        flyCar.setRefuelingStation(refuelingStation);

        flyCar.fuel();

        System.out.print("Цена за смену колес: " + calculateMaintenance(flyCar) + "\n");

        flyCar.setWashingStation(washStation);

        flyCar.washCar();

        flyCar.setWashingStation(washStationV2);

        flyCar.washInterior();
        //endregion

    }

    /**
     * Доработанный метод подсчета стоимости замены колес
     * @param car
     * @return
     */
    public static double calculateMaintenance(Car car){
        if (car.getWheelsCount() == 6){
            return 1500*6;
        }
        else {
            return 1000*car.getWheelsCount();
        }
    }

}
