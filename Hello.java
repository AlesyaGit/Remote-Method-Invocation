/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pbilski
 */
public class Hello extends UnicastRemoteObject implements HelloInterface {

    private final List<User> userList;
    // Internal property of the object for storing the message
    private final String message;

    // Constructor
    public Hello(String msg) throws RemoteException {
        message = msg;
        userList = new ArrayList<>();
    }

    // Method for retrieving the property
    public String say() throws RemoteException {
        return message;
    }

    // Method that adds 2 numbers
    public int addNumbers(int a, int b) throws RemoteException {
        return a + b;
    }

    // Method operating on the object-type parameter
    public int calculateVolume(MyObject o) throws RemoteException {
        return o.getBreadth() * o.getHeight() * o.getLength();
    }

///////////method for 4th task:
    public void shutdown() throws RemoteException {
        System.out.println("Server is shutting down...");
        System.exit(0);
    }

///////Implementing the User methods from Use class:
    public void addUser(User user) throws RemoteException {
        userList.add(user);
        System.out.println("Added user: " + user);
    }

    public void deleteUser(int userId) throws RemoteException {
        userList.removeIf(user -> user.getId() == userId);
        System.out.println("Deleted user with ID: " + userId);
    }

    public User getUser(int userId) throws RemoteException {
        return userList.stream()
                .filter(user -> user.getId() == userId)
                .findFirst()
                .orElse(null);
    }

    public List<User> listUsers() throws RemoteException {
        return new ArrayList<>(userList);
    }

    public void updateUser(User updatedUser) throws RemoteException {
        for (User user : userList) {
            if (user.getId() == updatedUser.getId()) {
                user.setFirstname(updatedUser.getFirstname());
                user.setLastname(updatedUser.getLastname());
                user.setEmail(updatedUser.getEmail());
                user.setSalary(updatedUser.getSalary());
                user.setGender(updatedUser.getGender());
                user.setDivision(updatedUser.getDivision());
                user.setWorkPosition(updatedUser.getWorkPosition());

                System.out.println("Updated user: " + updatedUser);
                return;
            }
        }
    }
}
