import java.util.Scanner;
import java.sql.*;
public class App {
    static int totalHarga=0;
    static int totalHargaminum=0;
    static int totalHargamakan=0;
    static int totalHargalain=0;
    static int banyakminum=0;
    static int banyaklain=0;
    static int banyakmakan=0;
    static int totalbarang=0;
    
    public static void menu() {
        System.out.println("-Kasir Sembako-");
        System.out.println("======================================");
        System.out.println("0. Menu Utama");
        System.out.println("1. Makanan/Bahan");
        System.out.println("2. Minuman");
        System.out.println("3. lainnya");
        System.out.println("4. Exit");
        System.out.println("--------------------------------------");
        
    }
    /**
     * 
     */
    public static void lain() {
        try {
            Class.forName("org.sqlite.JDBC"); 
            String url = "jdbc:sqlite:D:/sqlite/dataBarang.db"; 
            Connection koneksi = DriverManager.getConnection(url);
            Statement stat = koneksi.createStatement();
            ResultSet set = stat.executeQuery("select Kode,Nama,Harga,stok,tgl_exp from sembako where Kode like 'C%';");
            Scanner inputlain = new Scanner(System.in);
            String pilihlain,pilihkode;
            
            
            System.out.println("-Bahan lain-");
            System.out.println("-------------------------------------------------------------");
            System.out.println("Kode\tNama\t\tHarga\t\tStok\ttgl exp");
            System.out.println("-------------------------------------------------------------");
            while (set.next()) {
                String code = set.getString("Kode");
                System.out.print(code);
                String nama = set.getString("Nama");
                System.out.print("\t"+nama);
                int harga = set.getInt("Harga");
                System.out.print("\t\t"+harga);
                int stok = set.getInt("stok");
                System.out.print("\t\t"+stok);
                String exp = set.getString("tgl_exp");
                System.out.print("\t"+exp);
                System.out.println();
                
            }
            System.out.println("-------------------------------------------------------------");
            System.out.print("Ada yang ingin di input ? [y/n] : "); pilihlain = inputlain.nextLine();
            if ((pilihlain.equalsIgnoreCase("y")) || (pilihlain.equalsIgnoreCase("Y"))) {
                System.out.print("Masukan Kode yang ingin di Beli : "); String pilihlainkode = inputlain.nextLine();
                switch (pilihlainkode) {
                    case "c1","C1":
                        ResultSet hasilc1 = stat.executeQuery("select Harga from sembako where Kode='C1';");
                        while (hasilc1.next()) {
                                int hargalain=set.getInt("Harga");
                                System.out.print("Berapa banyak? : "); banyaklain = inputlain.nextInt();
                                totalbarang+=banyaklain;
                                totalHargalain=banyaklain*hargalain;
                                totalHarga+=totalHargalain;
                                stat.executeQuery("update sembako set stok=(stok-"+banyaklain+") where Kode='C1';");
                            
                        }
                        break;
                    case "c2","C2":
                        ResultSet hasilc2 = stat.executeQuery("select Harga from sembako where Kode='C2';");
                            while (hasilc2.next()) {
                                int hargalain=set.getInt("Harga");
                                System.out.print("Berapa banyak? : "); banyaklain = inputlain.nextInt();
                                totalbarang+=banyaklain;
                                totalHargalain=banyaklain*hargalain;
                                totalHarga+=totalHargalain;
                                stat.executeQuery("update sembako set stok=(stok-"+banyaklain+") where Kode='C2';");
                        }
                        
                        break;
                }
            } else {
                menu();
            } 
        } catch (Exception e) {
            System.err.println("error : "+e.getMessage());
        }
    }
    public static void minuman() {
        try {
            Class.forName("org.sqlite.JDBC"); 
            String pilihlain,pilihkode;
            Scanner inputlain = new Scanner(System.in);
            String url = "jdbc:sqlite:D:/sqlite/dataBarang.db"; 
            Connection koneksi = DriverManager.getConnection(url);
            Statement stat = koneksi.createStatement();
            ResultSet set = stat.executeQuery("select Kode,Nama,Harga,stok,tgl_exp from sembako where Kode like 'B%';");
            System.out.println("-Bahan Minuman-");
            System.out.println("-------------------------------------------------------------");
            System.out.println("Kode\tNama\t\tHarga\t\tStok\ttgl exp");
            System.out.println("-------------------------------------------------------------");
            while (set.next()) {
                String code = set.getString("Kode");
                System.out.print(code);
                String nama = set.getString("Nama");
                System.out.print("\t"+nama);
                int harga = set.getInt("Harga");
                System.out.print("\t\t"+harga);
                int stok = set.getInt("stok");
                System.out.print("\t\t"+stok);
                String exp = set.getString("tgl_exp");
                System.out.print("\t"+exp);
                System.out.println();
                
            }
            System.out.println("-------------------------------------------------------------");
            System.out.print("Ada yang ingin di input ? [y/n] : "); pilihlain = inputlain.nextLine();
            if ((pilihlain.equalsIgnoreCase("y")) || (pilihlain.equalsIgnoreCase("Y"))) {
                System.out.print("Masukan Kode yang ingin di Beli : "); String pilihlainkode = inputlain.nextLine();
                switch (pilihlainkode) {
                    case "b1","B1":
                        ResultSet hasilb1 = stat.executeQuery("select Harga from sembako where Kode='B1';");
                        while (hasilb1.next()) {
                                int hargalain=set.getInt("Harga");
                                System.out.print("Berapa banyak? : "); banyakminum = inputlain.nextInt();
                                totalbarang+=banyakminum;
                                totalHargaminum=banyakminum*hargalain;
                                totalHarga+=totalHargaminum;
                                stat.executeQuery("update sembako set stok=(stok-"+banyakminum+") where Kode='B1';");
                            
                        }
                        break;
                    case "b2","B2":
                    ResultSet hasilb2 = stat.executeQuery("select Harga from sembako where Kode='B2';");
                    while (hasilb2.next()) {
                        int hargalain=set.getInt("Harga");
                        System.out.print("Berapa banyak? : "); banyakminum = inputlain.nextInt();
                        totalbarang+=banyakminum;
                        totalHargaminum=banyakminum*hargalain;
                        totalHarga+=totalHargaminum;
                        stat.executeQuery("update sembako set stok=(stok-"+banyakminum+") where Kode='B2';");
                    }
                    
                    break;
                    
                }
            } else {
                menu();
            } 
        } catch (Exception e) {
            System.err.println("error : "+e.getMessage());
        }
        System.out.println("-------------------------------------------------------------");
    }
    public static void makanan() {
        try {
            String pilihlain,pilihkode;
            Scanner inputlain = new Scanner(System.in);
            Class.forName("org.sqlite.JDBC"); 
            String url = "jdbc:sqlite:D:/sqlite/dataBarang.db"; 
            Connection koneksi = DriverManager.getConnection(url);
            Statement stat = koneksi.createStatement();
        ResultSet set = stat.executeQuery("select Kode,Nama,Harga,stok,tgl_exp from sembako where Kode like 'A%';");
        System.out.println("-Bahan Makanan-");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Kode\tNama\t\tHarga\t\tStok\ttgl exp");
        System.out.println("-------------------------------------------------------------");
        while (set.next()) {
            String code = set.getString("Kode");
            System.out.print(code);
            String nama = set.getString("Nama");
            System.out.print("\t"+nama);
            int harga = set.getInt("Harga");
            System.out.print("\t\t"+harga);
            int stok = set.getInt("stok");
            System.out.print("\t\t"+stok);
            String exp = set.getString("tgl_exp");
            System.out.print("\t"+exp);
            System.out.println();
            
        }
        System.out.println("-------------------------------------------------------------");
        System.out.print("Ada yang ingin di input ? [y/n] : "); pilihlain = inputlain.nextLine();
            if ((pilihlain.equalsIgnoreCase("y")) || (pilihlain.equalsIgnoreCase("Y"))) {
                System.out.print("Masukan Kode yang ingin di Beli : "); String pilihlainkode = inputlain.nextLine();
                switch (pilihlainkode) {
                    case "A1","a1":
                        ResultSet hasilA1 = stat.executeQuery("select Harga from sembako where Kode='A1';");
                        while (hasilA1.next()) {
                                int hargalain=set.getInt("Harga");
                                System.out.print("Berapa banyak? : "); banyakmakan = inputlain.nextInt();
                                totalbarang+=banyakmakan;
                                totalHargalain=banyakmakan*hargalain;
                                totalHarga+=totalHargalain;
                                stat.executeQuery("update sembako set stok=(stok-"+banyakmakan+") where Kode='A1';");
                            
                        }
                        break;
                    case "A2","a2":
                        ResultSet hasilA2 = stat.executeQuery("select Harga from sembako where Kode='A2';");
                            while (hasilA2.next()) {
                                int hargalain=set.getInt("Harga");
                                System.out.print("Berapa banyak? : "); banyakmakan = inputlain.nextInt();
                                totalbarang+=banyakmakan;
                                totalHargalain=banyakmakan*hargalain;
                                totalHarga+=totalHargalain;
                                stat.executeQuery("update sembako set stok=(stok-"+banyakmakan+") where Kode='A2';");
                        }
                        
                        break;
                        case "A3","a3":
                        ResultSet hasilA3 = stat.executeQuery("select Harga from sembako where Kode='A3';");
                        while (hasilA3.next()) {
                                int hargalain=set.getInt("Harga");
                                System.out.print("Berapa banyak? : "); banyakmakan = inputlain.nextInt();
                                totalbarang+=banyakmakan;
                                totalHargalain=banyakmakan*hargalain;
                                totalHarga+=totalHargalain;
                                stat.executeQuery("update sembako set stok=(stok-"+banyakmakan+") where Kode='A3';");
                            
                        }
                        break;
                    case "A4","a4":
                        ResultSet hasilA4 = stat.executeQuery("select Harga from sembako where Kode='A4';");
                            while (hasilA4.next()) {
                                int hargalain=set.getInt("Harga");
                                System.out.print("Berapa banyak? : "); banyakmakan = inputlain.nextInt();
                                totalbarang+=banyakmakan;
                                totalHargalain=banyakmakan*hargalain;
                                totalHarga+=totalHargalain;
                                stat.executeQuery("update sembako set stok=(stok-"+banyakmakan+") where Kode='A4';");
                        }
                        
                        break;
                    case "A5","a5":
                        ResultSet hasilA5 = stat.executeQuery("select Harga from sembako where Kode='A5';");
                            while (hasilA5.next()) {
                                int hargalain=set.getInt("Harga");
                                System.out.print("Berapa banyak? : "); banyakmakan = inputlain.nextInt();
                                totalbarang+=banyakmakan;
                                totalHargalain=banyakmakan*hargalain;
                                totalHarga+=totalHargalain;
                                stat.executeQuery("update sembako set stok=(stok-"+banyakmakan+") where Kode='A5';");
                        }
                        
                        break;
                }
            } else {
                menu();
            } 
    } catch (Exception e) {
        System.err.println("error : "+e.getMessage());
    }
    

}
public static void main(String[] args) {
    try {
        Scanner input = new Scanner(System.in);
            menu();
            int pilih;
            do {
                
                System.out.print("Masukan Pilihan : ");  pilih = input.nextInt();
                switch (pilih) {
                    case 0:
                    menu();
                    break;
                    case 1:
                    makanan();
                    break;
                    case 2:
                    minuman();
                    break;
                    case 3:
                    lain();
                    break;
                    
                }
            
                
            } while (pilih<4);
            System.out.println("===================================================");
            System.out.println("Total Barang : "+totalbarang);
            System.out.println("Total Harga : "+totalHarga);
            System.out.println("===================================================");
            System.out.print("Uang diterima : "); pilih= input.nextInt(); System.out.println(pilih+" - "+totalHarga);
            System.out.println("===================================================");
            pilih-=totalHarga;
            System.out.println("Kembali : "+pilih);
        } catch (Exception e) {
            System.err.println("error : "+e.getMessage());
        }
    
    }   
}
