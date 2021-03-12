public class Lesson_5 {
    public static void main(String[] args) {

        Employee[] employeeArr = new Employee[5];
        employeeArr[0] = new Employee("Arbuzov V.M.", "CEO", "avm@mail.com", "8-453-243-56-23", 500000, 55);
        employeeArr[1] = new Employee("Baranov G.T.", "Lawyer", "bgt@mail.com", "8-783-923-35-43", 150000, 36);
        employeeArr[2] = new Employee("Vaganov I.D.", "Engineer", "vid@mail.com", "8-945-975-23-76", 125000, 43);
        employeeArr[3] = new Employee("Gazaev N.P.", "Driver", "gnp@mail.com", "8-908-435-96-54", 55000, 33);
        employeeArr[4] = new Employee("Dulin A.R.", "Assistant", "dar@mail.com", "8-678-245-76-22", 40000, 25);

        over40(employeeArr);

    }

    public static void over40(Employee[] arr) {
        System.out.println("Employees over 40 ears:\n");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getAge() > 40) {
                arr[i].employeeInfo();
            }
        }
    }
}
