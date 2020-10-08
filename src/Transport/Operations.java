
package Transport;
import java.util.ArrayList;
import Autotransport.Autotransport;
import Menu.Menu;
import Transport.Bus;
import Transport.Truck;

public class Operations {
    //Создаем список элелементов для классов
    public static ArrayList<Autotransport> list = new ArrayList<Autotransport>();
    
    public Operations(ArrayList<Autotransport> list){
        this.list = list;
    }
    
    //Добавляем объект в список
    public void AddtoList(){
        Autotransport p1 = AddObjData();
        list.add(p1);
    }
    
    //Вводим данные об объектах
    public Autotransport AddObjData(){
        System.out.println("Введите марку: ");
        String name = Menu.vvod();
        System.out.println("Введите мощность: ");
        int enginepower = Integer.parseInt(Menu.vvod());
        System.out.println("Введите 1, если хотите добавить грузовик, и 2, если автобус: ");
        int choice = Integer.parseInt(Menu.vvod());
        if (choice == 1){
            System.out.println("\nГрузоподъемность (кг): ");
            int capacity = Integer.parseInt(Menu.vvod());
            return new Truck(enginepower, name, capacity);

        } else {
            System.out.println("\nПассажировместимость (чел): ");
            int passcount = Integer.parseInt(Menu.vvod());
            int massofpass = 75 * passcount;
            return new Bus(enginepower, name, passcount, massofpass);
        }
    }
    
    //Выводим данные
    public void OutputData(){
        int i = 0;
        for (Autotransport trans: list) {
            i++;
            System.out.println(i + ") "+ trans.info() + " ");
        }
    }
    
    //Изменение объекта
    public void ChangeObj(){
        int id = Search();
        Autotransport changeobj = AddObjData();
        list.set(id, changeobj);
    }
    
    //Поиск объекта по номеру
    public int Search(){
        if (list.isEmpty())
            System.out.println("Список пуст.");
        
        System.out.println("\nВведите номер объекта в списке: ");
        int id = Integer.parseInt(Menu.vvod());
        if (id > list.size()) {
            System.out.println("\nОбъекта с таким номером нет в списке. Повторите ввод! ");
            id = Integer.parseInt(Menu.vvod());
        }
        System.out.println("Объект найден: " + list.get(id-1).info());

        return id-1;
    }
    
    //Выдача запроса
    public static Autotransport RequestOutput(String mark){
        Autotransport transp = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMark().equals(mark)) {
                transp = list.get(i);
                break;
            }
        }
        if (transp == null)
            System.out.println("\nСовпадений не найдено. ");
        return transp;
    }
}
