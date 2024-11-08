import java.util.Scanner;

public class OylamaUygulamasi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] konular = {"Siyasi Sorunlar", "Çevre Sorunları", "Ekonomik Sorunlar", "Güvenlik Sorunları", "Eğitim Sorunları"};
        int[][] oylar = new int[konular.length][10];
        int[] toplamPuan = new int[konular.length];
        int[] degerlendirmeSayisi = new int[konular.length];

        int kullaniciSayisi = 0; 

        System.out.println("Anket Başladı ! Çıkmak için '0' yazınız.");

              while (true) {
            kullaniciSayisi++;
            System.out.println("Kullanıcı " + kullaniciSayisi + " için puanlama:");
            boolean cikis = false;

            for (int j = 0; j < konular.length; j++) {
                System.out.print(konular[j] + " için 1-10 arasında bir puan verin (0 ile çıkış): ");
                int puan = scanner.nextInt();

                if (puan == 0) { 
                    cikis = true;
                    break;
                }

              
                while (puan < 1 || puan > 10) {
                    System.out.print("Geçersiz puan! 1-10 arasında bir puan verin: ");
                    puan = scanner.nextInt();
                }

                oylar[j][puan - 1]++;
                toplamPuan[j] += puan;
                degerlendirmeSayisi[j]++;
            }

            if (cikis) { 
                break;
            }

            System.out.println();
        }

   
        System.out.printf("%-20s", "Konu");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%-8d", i);
        }
        System.out.printf("%-15s\n", "Ortalama");

   
        for (int i = 0; i < konular.length; i++) {
            System.out.printf("%-20s", konular[i]);

           
            for (int j = 0; j < 10; j++) {
                System.out.printf("%-8d", oylar[i][j]);
            }

         
            double ortalama = (double) toplamPuan[i] / degerlendirmeSayisi[i];
            System.out.printf("%-15.2f\n", ortalama);
        }

        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 1; i < konular.length; i++) {
            if (toplamPuan[i] > toplamPuan[maxIndex]) {
                maxIndex = i;
            }
            if (toplamPuan[i] < toplamPuan[minIndex]) {
                minIndex = i;
            }
        }

       
        System.out.println("\nEn yüksek puan alan konu: " + konular[maxIndex] + " (Toplam: " + toplamPuan[maxIndex] + ")");
        System.out.println("En düşük puan alan konu: " + konular[minIndex] + " (Toplam: " + toplamPuan[minIndex] + ")");

        scanner.close();
    }
}
        
      
