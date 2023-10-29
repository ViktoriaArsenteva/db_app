package Directory;

import java.util.ArrayList;
import java.util.List;

public class EmploeeDir {

    static List<Emploee> emploees = new ArrayList<Emploee>();

    public void allEmploees(){
        for (Emploee e: emploees) {
            System.out.println(e);
            
        }
    }

    public List<Emploee> addtoEmploeesList(Emploee emp){
        emploees.add(emp);
        return emploees;
        
    }

    public void NewEmploee(String id, String number, String name, String exp){
        Emploee emp = new Emploee(id, number, name, exp);
        addtoEmploeesList(emp);
        
    }

    public void findByIdNumber(String id){
        int i = 0;
        for (Emploee e: emploees) {
            if (e.idNumber.equals(id)){
                System.out.println(e);
                i++;
            }
        }
        if (i == 0){
            System.out.println("Работник с таким табельным номером не найден");

        }
    }
    public void findByPhoneNumber(String number){
        int i = 0;
        for (Emploee e: emploees) {
            if (e.phoneNumber.equals(number)){
                System.out.println(e);
                i++;
            }
        }
        if (i == 0){
            System.out.println("Работник с таким номером телефона не найден");

        }
    }

    public void findByName(String name){
        int i = 0;
        for (Emploee e: emploees) {
            if (e.name.equals(name)){
                System.out.println(e);
                i++;
            }
        }
        if (i == 0){
            System.out.println("Работник с таким именем не найден");

        }
    }

    public void findByExperience(String experience){
        int i = 0;
        for (Emploee e: emploees) {
            if (e.experience.equals(experience)){
                System.out.println(e);
                i++;
            }
        }
        if (i == 0){
            System.out.println("Работник с таким стажем не найден");

        }
    }


}
