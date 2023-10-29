package Directory;

// Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
// Табельный номер
// Номер телефона
// Имя
// Стаж
// Добавить метод, который ищет сотрудника по стажу (может быть список)
// Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
// Добавить метод, который ищет сотрудника по табельному номеру
// Добавить метод добавление нового сотрудника в справочник сотрудников

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        EmploeeDir directory = new EmploeeDir();
        Emploee e1 = new Emploee("1", "8765432", "Олег", "23");
        Emploee e2 = new Emploee("2", "345678", "Михаил", "8");
        Emploee e3 = new Emploee("3", "98765", "Татьяна", "4");
        Emploee e4 = new Emploee("4", "2345678", "Виктория", "30");
        Emploee e5 = new Emploee("5", "987654", "Ульяна", "23");
        Emploee e6 = new Emploee("6", "123456", "Артем", "4");
        Emploee e7 = new Emploee("7", "098765", "Марк", "8");
        Emploee e8 = new Emploee("8", "667839", "Полина", "13");
        Emploee e9 = new Emploee("9", "123346", "Анжелика", "1");

        directory.addtoEmploeesList(e1);
        directory.addtoEmploeesList(e2);
        directory.addtoEmploeesList(e3);
        directory.addtoEmploeesList(e4);
        directory.addtoEmploeesList(e5);
        directory.addtoEmploeesList(e6);
        directory.addtoEmploeesList(e7);
        directory.addtoEmploeesList(e8);
        directory.addtoEmploeesList(e9);

        menu.start();
        


        
    
    }

    
}