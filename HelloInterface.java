/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
import java.rmi.*;
import java.util.List;

/**
 *
 * @author pbilski
 */
public interface HelloInterface extends Remote {
    // The list of operations performed by the server
    public String say() throws RemoteException;
    public int addNumbers(int a, int b) throws RemoteException;
    public int calculateVolume(MyObject o) throws RemoteException;

    // User methods
    public void addUser(User user) throws RemoteException;
    public void deleteUser(int userId) throws RemoteException;
    public User getUser(int userId) throws RemoteException;
    public List<User> listUsers() throws RemoteException;
    public void updateUser(User updatedUser) throws RemoteException;


/////////////method for task 4:
    public void shutdown() throws RemoteException;
}

