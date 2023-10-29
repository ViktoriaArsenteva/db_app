package Directory;

public class Emploee implements EmploeeInterface {

    public String idNumber;
    public String phoneNumber;
    public String name;
    public String experience;



    public Emploee(String idNumber, String phoneNumber, String name, String experience) {
        this.idNumber = idNumber;
        this. phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
        
    }


    @Override
    public void sortByExperience() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sortByExperience'");
    }

    @Override 
    public String toString(){
        return "Работник (Табельный номер: " + idNumber + ", "
                + "Номер телефона: " + phoneNumber + ", "
                + "Имя: " + name + ", "
                + "Стаж работы: " + experience + ")";

    }
    
}
