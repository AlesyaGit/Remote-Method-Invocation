/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.rmi.Naming;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pbils
 */
public class HelloClient {


//////variables for the 4th task:

    private static final int MAX_RETRIES = 3;
    private static final int RETRY_DELAY_MS = 2000;

    public static void main(String[] argv) {


        Scanner keyb = new Scanner(System.in);
        int x, y;
        // The object that will be passed as the parameter
        MyObject mo = new MyObject();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        HelloInterface hi = null;
        int attempt = 0;

        // Retry connection to the server up to MAX_RETRIES
        while (attempt < MAX_RETRIES) {
            try {
                // Attempt to retrieve the interface provided by the server
                hi = (HelloInterface) Naming.lookup("//192.168.0.221:5001/Hello");
                System.out.println("Connected to server.");
                break;
            } catch (Exception e) {
                attempt++;
                System.out.println("Connection attempt " + attempt + " failed. Retrying in " + (RETRY_DELAY_MS / 1000) + " seconds...");
                if (attempt >= MAX_RETRIES) {
                    System.out.println("Unable to connect to the server after " + MAX_RETRIES + " attempts. Exiting.");
                    e.printStackTrace();
                    return;
                }
                try {
                    Thread.sleep(RETRY_DELAY_MS);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }

        try {
            // ... and print the message
            System.out.println(hi.say());

            // This is the part where we pass two numbers for additions
            System.out.println("Please enter the first argument");
            x = keyb.nextInt();
            System.out.println("Please enter the second argument");
            y = keyb.nextInt();
            System.out.println("Result: " + hi.addNumbers(x, y));

            // Here we perform operation on the object passed as the argument
            System.out.println("Volume: " + hi.calculateVolume(mo));

/////////////////// User functionality:
            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Add user");
                System.out.println("2. Delete user");
                System.out.println("3. Retrieve user details");
                System.out.println("4. Print list of users");
                System.out.println("5. Modify user details");
                System.out.println("6. Exit");

                int choice = keyb.nextInt();
                keyb.nextLine();


                ///////CRUD operations:
                switch (choice) {
                    case 1:
                        // Add user
                        System.out.print("Enter user ID: ");
                        int id = keyb.nextInt();
                        keyb.nextLine();

                        System.out.print("Enter first name: ");
                        String firstname = keyb.nextLine();

                        System.out.print("Enter last name: ");
                        String lastname = keyb.nextLine();

                        System.out.print("Enter birthdate (yyyy-MM-dd): ");
                        Date birthdate = dateFormat.parse(keyb.nextLine());

                        System.out.print("Enter salary: ");
                        double salary = keyb.nextDouble();
                        keyb.nextLine();

                        System.out.print("Enter gender (MALE/FEMALE/OTHER): ");
                        Gender gender = Gender.valueOf(keyb.nextLine().toUpperCase());

                        System.out.print("Enter division: ");
                        String division = keyb.nextLine();

                        System.out.print("Enter work position: ");
                        String workPosition = keyb.nextLine();

                        System.out.print("Enter email: ");
                        String email = keyb.nextLine();

                        hi.addUser(new User(id, firstname, lastname, birthdate, salary, gender, division, workPosition, email));
                        break;

                    case 2:
                        // Delete user
                        System.out.print("Enter user ID to delete: ");
                        int deleteId = keyb.nextInt();
                        hi.deleteUser(deleteId);
                        break;

                    case 3:
                        // Retrieve user details
                        System.out.print("Enter user ID to retrieve: ");
                        int retrieveId = keyb.nextInt();
                        User user = hi.getUser(retrieveId);
                        System.out.println("User details: " + user);
                        break;

                    case 4:
                        // Print list of users
                        List<User> users = hi.listUsers();
                        System.out.println("List of users:");
                        for (User u : users) {
                            System.out.println(u);
                        }
                        break;

                    case 5:
                        // Modify user details
                        System.out.print("Enter user ID to modify: ");
                        int modifyId = keyb.nextInt();
                        keyb.nextLine();

                        System.out.print("Enter new first name: ");
                        String newFirstname = keyb.nextLine();

                        System.out.print("Enter new last name: ");
                        String newLastname = keyb.nextLine();

                        System.out.print("Enter new birthdate (yyyy-MM-dd): ");
                        Date newBirthdate = dateFormat.parse(keyb.nextLine());

                        System.out.print("Enter new salary: ");
                        double newSalary = keyb.nextDouble();
                        keyb.nextLine();

                        System.out.print("Enter new gender (MALE/FEMALE/OTHER): ");
                        Gender newGender = Gender.valueOf(keyb.nextLine().toUpperCase());

                        System.out.print("Enter new division: ");
                        String newDivision = keyb.nextLine();

                        System.out.print("Enter new work position: ");
                        String newWorkPosition = keyb.nextLine();

                        System.out.print("Enter new email: ");
                        String newEmail = keyb.nextLine();

                        hi.updateUser(new User(modifyId, newFirstname, newLastname, newBirthdate, newSalary, newGender, newDivision, newWorkPosition, newEmail));
                        break;

                    case 6:
                        // Exit
                        System.out.println("Exiting.");
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
