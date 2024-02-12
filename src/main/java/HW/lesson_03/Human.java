package HW.lesson_03;


/**
 * Описывает все 6 параметров
 */
public class Human {
    static int idx = 0;
    String familyName;
    String name;
    String surname;
    String birthDate;
    int phoneNumber;
    String gender;

    public Human(String[] str) {
        this.familyName = str[idx];
        this.name = str[++idx];
        this.surname = str[++idx];
        this.birthDate = str[++idx];
        this.phoneNumber = Integer.parseInt(str[++idx]);
        this.gender = str[++idx];
    }

    public Human() {
    }


    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%s><%s><%s>",
                familyName,
                name,
                surname,
                birthDate,
                phoneNumber,
                gender);
    }
}
