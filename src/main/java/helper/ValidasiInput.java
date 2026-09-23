/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class ValidasiInput {
    public static int inputInteger(Scanner scanner, String pesan){

        System.out.print(pesan);

        while (!scanner.hasNextInt()){
            System.out.println("Input harus berupa angka");
            scanner.nextLine();
            System.out.print(pesan);
        }
        int nilai = scanner.nextInt();
        scanner.nextLine();
        return nilai;
    }
}
