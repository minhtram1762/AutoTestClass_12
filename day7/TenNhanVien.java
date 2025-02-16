package day7;

import java.util.Scanner;

public class TenNhanVien {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhập số lượng nhân viên: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        
        String[] tenNhanVien = inputTenNhanVien(sc, n);
        
        displayTenNhanVien(tenNhanVien);
        
        sc.close();
    }
    
    public static String[] inputTenNhanVien(Scanner sc, int n) {
        String[] tenNhanVien = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập tên nhân viên thứ " + (i + 1) + ": ");
            tenNhanVien[i] = sc.nextLine();
        }
        return tenNhanVien;
    }
    
    public static void displayTenNhanVien(String[] tenNhanVien) {
        System.out.println("\nDanh sách nhân viên:");
        for (String nhanVien : tenNhanVien) {
            System.out.println(nhanVien);
        }
    }
}

