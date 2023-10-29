package Directory;

import java.awt.*;
import java.util.Scanner;

public class Menu {
    Scanner in = new Scanner(System.in);
    EmploeeDir dir =  new EmploeeDir();
    
    public void start(){
        System.out.println("Приветствую в справочнике сотрудников!\nВыберите действие:\n");
        System.out.println("1. Вывести список сотрудников");
        System.out.println("2. Добавить сотрудника");
        System.out.println("3. Поиск сотрудника(ов)");
        System.out.print(": ");
        
        int num = in.nextInt();
        in.nextLine();
        if (num == 1){
            dir.allEmploees();

            comeBack();
        }else if (num == 2){
            System.out.println("Для добавления нового сотрудника введите данные");
            System.out.print("Табельный номер: ");
            String id1 = in.nextLine();
            System.out.print("Номер телефона: ");
            String number = in.nextLine();
            System.out.print("Имя: ");
            String name = in.nextLine();
            System.out.print("Стаж работы: ");
            String experience = in.nextLine();

            dir.NewEmploee(id1, number, name, experience);

            comeBack();
        }else if (num == 3){
            findEmploee();
            comeBack();
        }

    }

    public void comeBack(){
        System.out.println("1. Вернуться в меню");
        System.out.println("2. Закрыть программу ");
        System.out.print(": ");
        int num = in.nextInt();
        in.nextLine();
        if (num == 1) {
            start();
        }else if (num == 2){
            System.exit(0);
        }

    }

    public void findEmploee(){
        System.out.println("1. Найти по табельному номеру");
        System.out.println("2. Найти по номеру телефона");
        System.out.println("3. Найти по имени");
        System.out.println("4. Найти по стажу");
        System.out.print(": ");

        int num = in.nextInt();
        in.nextLine();

        if (num == 1){
            System.out.print("Введите табельный номер: ");
            String id = in.nextLine();
            dir.findByIdNumber(id);
        }else if (num == 2){
            System.out.print("Введите номер телефона: ");
            String number = in.nextLine();
            dir.findByPhoneNumber(number);
        }else if (num == 3){
            System.out.print("Введите имя: ");
            String name = in.nextLine();
            dir.findByName(name);
        }else if (num == 4){
            System.out.print("Введите стаж работы: ");
            String experience = in.nextLine();
            dir.findByExperience(experience);
        }

    }
}
