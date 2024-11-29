import java.util.Scanner;

public class Assignment {
    static String[][] student = new String[100][10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExists = false;
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                 Welcome to Student management System                       |");
        System.out.println("------------------------------------------------------------------------------");
        String[] questions = {
                "[1] Add New Student","\t\t\t\t\t\t\t\t",                 "[2] Add New Student With Marks","\n",
                "[3] Add Marks","\t\t\t\t\t\t\t\t\t",                    "[4] Update Student Details","\n",
                "[5] Update Marks","\t\t\t\t\t\t\t\t",                     "[6] Delete Student","\n",
                "[7] Print Student Details","\t\t\t\t\t\t",            "[8] Print Student Ranks","\n",
                "[9] Best in Programming Fundamentals","\t\t\t", "[10] Best in Database Management System","\n"
        };
        while (!isExists){
            for (String question : questions){
                System.out.print(question);
            }
            System.out.println();
            int userInput = scanner.nextInt();
            switch (userInput){
                case 1:
                    saveStudent();
                    break;
                case 2:
                    saveStudentWithMarks();
                    break;
                case 3:
                    addStudentMarks();
                    break;
                case 4:
                    updateStudentDetails();
                    break;
                case 5:
                    updateMarks();
                    break;
                case 6:
                    deleteStudent();
                    break;
                case 7:
                    printStudentDetails();
                    break;
                case 8:
                    printStudentsRanks();
                    break;
                case 9:
                    bestInProgrammingFundamentals();
                    break;
                case 10:
                    bestInDatabaseManagementSystem();
                    break;
                default:
                    return;
            }
        }
    }

    public static void saveStudent(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("|                      Add New Student                       |");
        System.out.println("--------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        String id,name;
        while (true){
            System.out.print("Enter Student Id: ");
            id = scanner.nextLine();
            studentForLoop:
            for (int i = 0;i<student.length;i++){
                if(student[i][0]!=null){
                    if (student[i][0].equals(id)){
                        System.out.println("Student Already Exists!");
                        break studentForLoop;
                    }
                }else {
                    System.out.print("Enter Student Name: ");
                    name = scanner.nextLine();

                    student[i][0] = id;
                    student[i][1] = name;

                    System.out.println("Student has been added successfully");
                    System.out.print("Do you want to add a new student (Y/N): ");
                    String option = scanner.nextLine();
                    switch (option){
                        case "Y":
                            break studentForLoop;
                        case "N":
                            return;
                        default:
                            return;

                    }
                }
            }
        }
    }
    public static void saveStudentWithMarks(){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("|                      Add New Student with Marks                      |");
        System.out.println("------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        String id,name;
        int programmingMarks=0;
        int dbmsMarks = 0;
        while (true){
            System.out.print("Enter Student Id: ");
            id = scanner.nextLine();
            studentForLoop:
            for (int i = 0;i<student.length;i++){
                if(student[i][0]!=null){
                    if (student[i][0].equals(id)){
                        System.out.println("Student Already Exists!");
                        break studentForLoop;
                    }
                }
                else {
                    System.out.print("Enter Student Name: ");
                    name = scanner.nextLine();

                    while (true) {
                        System.out.print("Programming Fundamentals Marks : ");
                        try {
                            programmingMarks = Integer.parseInt(scanner.nextLine());
                            if (programmingMarks >= 0 && programmingMarks <= 100) {
                                break;
                            }
                            System.out.println("Invalid marks. Please enter marks between 0 and 100.");
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                        }
                    }

                    while (true) {
                        System.out.print("Database Management System Marks: ");
                        try {
                            dbmsMarks = Integer.parseInt(scanner.nextLine());
                            if (dbmsMarks >= 0 && dbmsMarks <= 100) {
                                break;
                            }
                            System.out.println("Invalid marks. Please enter marks between 0 and 100.");
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                        }
                    }

                    student[i][0] = id;
                    student[i][1] = name;
                    student[i][2] = String.valueOf(programmingMarks);
                    student[i][3] = String.valueOf(dbmsMarks);

                    System.out.println("Student has been added successfully ");
                    System.out.print("Do you want to add a new student (Y/N): ");
                    String option = scanner.nextLine();
                    switch (option){
                        case "Y":
                            break studentForLoop;
                        case "N":
                            return;
                        default:
                            System.out.println("Invalid option. Please enter Y or N.");
                    }
                }
            }
        }
    }
    public static void addStudentMarks(){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("|                                Add Marks                             |");
        System.out.println("------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        int programmingMarks=0;
        int dbmsMarks = 0;
        String id;
        while (true){
            studentForLoop:
            for (int i=0;i<student.length;i++){
                while (true) {
                    System.out.print("Enter Student Id:");
                    id = scanner.nextLine();
                    int stdID = Integer.parseInt(id);
                    try {
                        if (stdID != 0) {
                            break;
                        }
                        System.out.println("Invalid Student Id");
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a number.");
                    }
                }
                if(student[i][0]!=null){
                    if(student[i][0].equals(id)){
                        System.out.println("Student Name: "+student[i][1]);
                        if(student[i][2]!= null){
                            System.out.println("This student's marks have been already added.");
                            System.out.print("If you want to update the marks, please use [4] Update Marks option.(Y/N): ");
                            String choice = scanner.nextLine();
                            switch (choice){
                                case "Y":
                                    return;
                                case "N":
                                    break studentForLoop;
                                default:
                                    System.out.println("Invalid option. Please enter Y or N.");
                            }
                        }
                        while (!false) {
                            System.out.print("Programming Fundamentals Marks: ");
                            try {
                                programmingMarks = Integer.parseInt(scanner.nextLine());
                                if (programmingMarks >= 0 && programmingMarks <= 100) {
                                    break;
                                }
                                System.out.println("Invalid marks. Please enter marks between 0 and 100.");
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a valid number.");
                            }
                        }

                        while (!false) {
                            System.out.print("Database Management System Marks : ");
                            try {
                                dbmsMarks = Integer.parseInt(scanner.nextLine());
                                if (dbmsMarks >= 0 && dbmsMarks <= 100) {
                                    break;
                                }
                                System.out.println("Invalid marks. Please enter marks between 0 and 100.");
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a valid number.");
                            }
                        }

                        student[i][2] = String.valueOf(programmingMarks);
                        student[i][3] = String.valueOf(dbmsMarks);

                        System.out.println("Student has been added successfully ");
                        System.out.print("Do you want to add a new student (Y/N): ");
                        String choice = scanner.nextLine();
                        switch (choice){
                            case "Y":
                                break studentForLoop;
                            case "N":
                                return;
                            default:
                                System.out.println("Invalid option. Please enter Y or N.");
                        }
                    }
                }
                else{
                    System.out.println("Student Not Found");
                }
            }
        }
    }
    public static void updateStudentDetails(){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("|                        UPDATE STUDENT DETAILS                        |");
        System.out.println("------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        String id,newName;
        while (true) {
            System.out.print("Enter Student ID : ");
            id = scanner.nextLine();
            int stdID = Integer.parseInt(id);
            try {
                if (stdID != 0) {
                    break;
                }
                System.out.println("Invalid Student Id");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }

        studentForLoop:
        for (int i = 0;i<student.length;i++) {
            if(student[i][0]!=null){
                if(student[i][0]!=null){
                    System.out.print("Enter the new student name: ");
                    newName = scanner.nextLine();

                    student[i][1] = newName;
                    System.out.println("Student Name has been updated successfully ");
                    System.out.print("Do you want to update another student details? (Y/N): ");
                    String option = scanner.nextLine();
                    switch (option){
                        case "Y":
                            break studentForLoop;
                        case "N":
                            return;
                        default:
                            System.out.println("Invalid option. Please enter Y or N.");
                    }
                }
            }
        }
    }
    public static void updateMarks() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("|                         UPDATE STUDENT MARKS                         |");
        System.out.println("------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String id;
            boolean studentFound = false;

            while (true) {
                System.out.print("Enter Student Id: ");
                id = scanner.nextLine();
                try {
                    int stdID = Integer.parseInt(id);
                    if (stdID > 0) {
                        break;  // Break from this while loop stdID > 0
                    }
                    System.out.println("Invalid Student Id");
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number.");
                }
            }

            for (int i = 0; i < student.length; i++) {
                if (student[i][0] != null && student[i][0].equals(id)) {
                    studentFound = true;
                    System.out.println("Student Name: " + student[i][1]);
                    System.out.println("Programming Fundamentals Marks: " + student[i][2]);
                    System.out.println("Database Management System Marks: " + student[i][3]);

                    int newProgrammingMarks;
                    while (true) {
                        System.out.print("Programming Fundamentals New Marks: ");
                        try {
                            newProgrammingMarks = Integer.parseInt(scanner.nextLine());
                            if (newProgrammingMarks >= 0 && newProgrammingMarks <= 100) {
                                break;  // Break from programming marks validation loop
                            }
                            System.out.println("Invalid marks. Please enter marks between 0 and 100.");
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                        }
                    }

                    int newDbmsMarks;
                    while (true) {
                        System.out.print("Database Management System New Marks: ");
                        try {
                            newDbmsMarks = Integer.parseInt(scanner.nextLine());
                            if (newDbmsMarks >= 0 && newDbmsMarks <= 100) {
                                break;  // Break from DBMS marks validation loop
                            }
                            System.out.println("Invalid marks. Please enter marks between 0 and 100.");
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                        }
                    }

                    student[i][2] = String.valueOf(newProgrammingMarks);
                    student[i][3] = String.valueOf(newDbmsMarks);
                    System.out.println("Marks have been updated successfully.");
                    break;  // Break from student search loop once found
                }
            }

            if (!studentFound) {
                System.out.println("Student Not Found");
            }

            // Ask if user wants to update another student
            while (true) {
                System.out.print("Do you want to update another student (Y/N): ");
                String choice = scanner.nextLine().toUpperCase();
                if (choice.equals("Y")) {
                    break;  // Break from choice loop to continue main loop
                } else if (choice.equals("N")) {
                    return;  // Exit the method
                } else {
                    System.out.println("Invalid option. Please enter Y or N.");
                }
            }
        }
    }
    public static void deleteStudent(){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("|                            DELETE STUDENT                            |");
        System.out.println("------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        String id;
        while (true) {  // Main loop for multiple updates
            boolean studentFound = false;

            // Get and validate student ID
            while (true) {
                System.out.print("Enter Student Id: ");
                id = scanner.nextLine();
                try {
                    int stdID = Integer.parseInt(id);
                    if (stdID > 0) {
                        break;  // Break from ID validation loop
                    }
                    System.out.println("Invalid Student Id");
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number.");
                }
            }

            // Search for student and delete details
            for (int i = 0; i < student.length; i++) {
                if (student[i][0] != null && student[i][0].equals(id)) {
                    studentFound = true;
                    student[i][0] = null;
                    student[i][1] = null;
                    student[i][2] = null;
                    student[i][3] = null;
                    System.out.println("Student has been delete successfully ");
                }
            }
            if (!studentFound) {
                System.out.println("Student Not Found");
            }

            // Ask if user wants to update another student
            while (true) {
                System.out.print("Do you want to update another student (Y/N): ");
                String choice = scanner.nextLine().toUpperCase();
                if (choice.equals("Y")) {
                    break;  // Break from choice loop to continue main loop
                } else if (choice.equals("N")) {
                    return;  // Exit the method
                } else {
                    System.out.println("Invalid option. Please enter Y or N.");
                }
            }
        }
    }
    public static void printStudentDetails(){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("|                         PRINT STUDENT Details                         |");
        System.out.println("------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        String id;
        while (true) {
            boolean studentFound = false;

            while (true) {
                System.out.print("Enter Student Id: ");
                id = scanner.nextLine();
                try {
                    int stdID = Integer.parseInt(id);
                    if (stdID > 0) {
                        break;  // Break from this while loop stdID > 0
                    }
                    System.out.println("Invalid Student Id");
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number.");
                }
            }

            for (int i = 0; i < student.length; i++) {
                if (student[i][0] != null && student[i][0].equals(id)) {
                    studentFound = true;
                    if(student[i][2] == null){
                        while (true) {
                            System.out.println("marks are yet to be added.");
                            System.out.print("Do you want to search another student? (Y/N): ");
                            String choice = scanner.nextLine().toUpperCase();
                            if (choice.equals("Y")) {
                                break;  // Break from choice loop to continue main loop
                            } else if (choice.equals("N")) {
                                return;  // Exit the method
                            } else {
                                System.out.println("Invalid option. Please enter Y or N.");
                            }
                        }
                    }
                    int pf = Integer.parseInt(student[i][2]);
                    int db = Integer.parseInt(student[i][3]);
                    int total = db + pf;
                    double avg = total/2;
                    System.out.println("----------------------------------+---------");
                    System.out.println("Programming Fundamentals Marks:\t\t"+pf);
                    System.out.println("Database Management System Marks: \t"+db);
                    System.out.println("Total Marks : "+"\t\t\t\t\t\t"+total);
                    System.out.println("Avg Marks : "+"\t\t\t\t\t\t"+avg);
                    System.out.println("Rank : "+"\t\t\t\t\t\t\t\t"+"1(First)");
                    System.out.println("----------------------------------+---------");
                }
            }

            if (!studentFound) {
                System.out.println("Student Not Found");
            }

            // Ask if user wants to update another student
            while (true) {
                System.out.print("Do you want to print another student (Y/N): ");
                String choice = scanner.nextLine().toUpperCase();
                if (choice.equals("Y")) {
                    break;  // Break from choice loop to continue main loop
                } else if (choice.equals("N")) {
                    return;  // Exit the method
                } else {
                    System.out.println("Invalid option. Please enter Y or N.");
                }
            }
        }
    }

    public static void printStudentsRanks() {
        String[][] students = new String[100][10];;
        boolean swapped;
        System.out.println("-------------------------------------------------------");
        System.out.println("|                 PRINT STUDENT Ranks                  |");
        System.out.println("-------------------------------------------------------");
        int validStudentCount = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i][0] != null) {
                int programmingMarks = Integer.parseInt(student[i][2]);
                int dbMarks = Integer.parseInt(student[i][3]);
                int total = programmingMarks + dbMarks;
                double avg = total / 2.0;
                students[i][0] = student[i][0];
                students[i][1] = student[i][1];
                students[i][2] = String.valueOf(avg);
                students[i][3] = String.valueOf(total);
                validStudentCount++;
            }
            if (validStudentCount == 0) {
                System.out.println("No students found. Marks need to be added first.");
                return;
            }
        }

        for (int i = 0; i < validStudentCount - 1; i++) {
            swapped = false;
            for (int j = 0; j < validStudentCount - i - 1; j++) {
                double avg1 = Double.parseDouble(students[j][2]);
                double avg2 = Double.parseDouble(students[j + 1][2]);

                if (avg1 < avg2) {
                    // Swap all data for the students
                    for (int k = 0; k < 4; k++) {
                        String temp = students[j][k];
                        students[j][k] = students[j + 1][k];
                        students[j + 1][k] = temp;
                    }
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        System.out.println("+-----+-------+----------------+-----------+----------+");
        System.out.println("|Rank |ID     |Name            |Total Marks|Avg Marks |");
        System.out.println("+-----+-------+----------------+-----------+----------+");

        for (int i = 0; i < validStudentCount; i++) {
            if (students[i][0] != null) {
                System.out.printf("|%-5d|%-7s|%-16s|%-11s|%-10s|\n",
                        (i + 1),
                        students[i][0],
                        students[i][1],
                        students[i][3],
                        students[i][2]);
            }
        }

        System.out.println("+-----+-------+----------------+-----------+----------+");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to go back to Main Menu? (Y/N): ");
            String option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "Y":
                    return;
                case "N":
                    printStudentsRanks();
                    return;
                default:
                    System.out.println("Invalid option. Please enter Y or N.");
            }
        }
    }
    public static void bestInProgrammingFundamentals(){
        String[][] students = new String[100][10];;
        boolean swapped;
        System.out.println("-------------------------------------------------------");
        System.out.println("|           Best in Programming Fundamentals          |");
        System.out.println("-------------------------------------------------------");

        int validStudentCount = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i][0] != null) {
                int programmingMarks = Integer.parseInt(student[i][2]);
                int dbMarks = Integer.parseInt(student[i][3]);
                students[i][0] = student[i][0];
                students[i][1] = student[i][1];
                students[i][2] = String.valueOf(programmingMarks);
                students[i][3] = String.valueOf(dbMarks);
                validStudentCount++;
            }
            if (validStudentCount == 0) {
                System.out.println("No students found. Marks need to be added first.");
                return;
            }
        }

        for (int i = 0; i < validStudentCount - 1; i++) {
            swapped = false;
            for (int j = 0; j < validStudentCount - i - 1; j++) {
                double programmingMarks1 = Double.parseDouble(students[j][2]);
                double programmingMarks2 = Double.parseDouble(students[j + 1][2]);

                if (programmingMarks1 < programmingMarks2) {
                    // Swap all data for the students
                    for (int k = 0; k < 4; k++) {
                        String temp = students[j][k];
                        students[j][k] = students[j + 1][k];
                        students[j + 1][k] = temp;
                    }
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        System.out.println("+--------+------------------+-----------+-------------+");
        System.out.println("|ID      |Name              |PF Marks   |DBMS Marks   |");
        System.out.println("+--------+------------------+-----------+-------------+");
        for (int i = 0; i < validStudentCount; i++) {
            if (students[i][0] != null) {
                System.out.printf("|%-8s|%-18s|%-11s|%-13s|\n",
                        students[i][0],
                        students[i][1],
                        students[i][3],
                        students[i][2]);
            }
        }
        System.out.println("+--------+------------------+-----------+-------------+");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to go back to Main Menu? (Y/N): ");
            String option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "Y":
                    return;
                case "N":
                    printStudentsRanks();
                    return;
                default:
                    System.out.println("Invalid option. Please enter Y or N.");
            }
        }
    }
    public static void bestInDatabaseManagementSystem(){
        String[][] students = new String[100][10];;
        boolean swapped;
        System.out.println("-------------------------------------------------------");
        System.out.println("|           Best in Programming Fundamentals          |");
        System.out.println("-------------------------------------------------------");

        int validStudentCount = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i][0] != null) {
                int programmingMarks = Integer.parseInt(student[i][2]);
                int dbMarks = Integer.parseInt(student[i][3]);
                students[i][0] = student[i][0];
                students[i][1] = student[i][1];
                students[i][2] = String.valueOf(programmingMarks);
                students[i][3] = String.valueOf(dbMarks);
                validStudentCount++;
            }
            if (validStudentCount == 0) {
                System.out.println("No students found. Marks need to be added first.");
                return;
            }
        }

        for (int i = 0; i < validStudentCount - 1; i++) {
            swapped = false;
            for (int j = 0; j < validStudentCount - i - 1; j++) {
                double dbmsMarks1 = Double.parseDouble(students[j][3]);
                double dbmsMarks2 = Double.parseDouble(students[j + 1][3]);

                if (dbmsMarks1 < dbmsMarks2) {
                    // Swap all data for the students
                    for (int k = 0; k < 4; k++) {
                        String temp = students[j][k];
                        students[j][k] = students[j + 1][k];
                        students[j + 1][k] = temp;
                    }
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        System.out.println("+--------+------------------+------------+-------------+");
        System.out.println("|ID      |Name              |DBMS Marks  |PF Marks     |");
        System.out.println("+--------+------------------+------------+-------------+");
        for (int i = 0; i < validStudentCount; i++) {
            if (students[i][0] != null) {
                System.out.printf("|%-8s|%-18s|%-12s|%-13s|\n",
                        students[i][0],
                        students[i][1],
                        students[i][2],
                        students[i][3]);
            }
        }
        System.out.println("+--------+------------------+------------+-------------+");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to go back to Main Menu? (Y/N): ");
            String option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "Y":
                    return;
                case "N":
                    printStudentsRanks();
                    return;
                default:
                    System.out.println("Invalid option. Please enter Y or N.");
            }
        }
    }
}
