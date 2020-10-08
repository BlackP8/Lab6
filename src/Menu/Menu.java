package Menu;

import Autotransport.Autotransport;
import Interface.Calculations;
import Transport.Truck;
import Transport.Bus;
import Transport.Operations;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Menu {
    //Создаем считыватель текста
    public static BufferedReader reader;
    //Чтобы ввод русских букв был корректным, зададим другуб кодировку для нашего потока
    static {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in, "CP1251"));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex);
        }
    }
    //Метод ввода 
    public static String vvod() {
        String str;
        try {
            str = reader.readLine();
            if (str.length()== 0) 
            {
                throw new NullPointerException();
            } 
        }
        catch (NullPointerException e) {
            System.out.println("Вы ничего не ввели! Повторите ввод!");
            str = vvod();
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода!");
            str = vvod();
        }
        return str;
    }
    
    public static void Menu() {
         //Первоначальные элементы списка
        ArrayList<Autotransport> list = new ArrayList<Autotransport>();
        Operations operations = new Operations (list);
        list.add(new Bus(150, "Zil", 5, 375));
        list.add(new Bus(110, "Big Rock", 8, 600));
        list.add(new Truck(420, "Huge bug", 10000));
        list.add(new Truck(350, "Hulk" , 7500));
        String choice;
        System.out.print("\nЛабораторная работа 6 \nВариант 24 \nКлассы и интерфейсы в Java"
                + "\nЗадание: \nРазработать все классы иерархии и консольное приложение для добавления "
                + "по 2 объектов каждого класса, изменения выбранного объекта, \n"
                + "просмотра всех объектов, выдачи запроса. "
                + "Базовый класс: автомобильный транспорт.\n" +
                  "Классы потомки: грузовик (грузоподъемность кг –  целое); \n" +
                   "автобус (пассажировместимость – короткое целое).\n" +
                   "Общие параметры: мощность двигателя – целое.\n" +
                   "Общие методы: отношение веса груза к единице мощности (действительное число). \n" +
                   "Вес пассажира считать равным 75 кг\n");
        do {
            System.out.println("\nВыберите действие \n"
                    + "1. Добавить объект\n"
                    + "2. Изменить данные\n"
                    + "3. Посмотреть все объекты\n"
                    + "4. Выполнить запрос\n"
                    + "5. Выйти");
            choice = vvod();
            switch (choice) {
                case "1": {
                    operations.AddtoList();
                    break;
                }
                case "2": {
                    operations.ChangeObj();
                    break;
                }
                case "3": {
                    operations.OutputData();
                    break;
                }
                case "4": {
                    System.out.println("\nВведите марку транспорта, которую хотите найти: ");
                    String request = vvod();
                    Autotransport transport = Operations.RequestOutput(request);
                    Calculations calc = (Calculations) transport;
                    System.out.println("\nУдельная мощность: " + calc.weighttopower());
                    break;
                }
                case "5": {
                    choice = "5";
                    System.out.println("Выход");
                    System.exit(0);
                }
                default: {
                    System.out.println("Ошибка!");
                    break;
                }
            }
        } while (choice != "5");
    }
}
