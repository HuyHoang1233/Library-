/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ADMIN
 */
public class FileUtils {

    // Ghi danh sách object xuống file
    public static <T> void writeToFile(String filename, List<T> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(list);
            System.out.println("Ghi file thanh cong: " + filename);
        } catch (IOException e) {
            System.err.println("Loi ghi file " + filename + ": " + e.getMessage());
        }
    }

    // Đọc danh sách object từ file
    @SuppressWarnings("unchecked")
    public static <T> List<T> readFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("FIle khong ton tai: " + filename + ". Tra ve danh sach rong.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(" Loi doc file " + filename + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }
}