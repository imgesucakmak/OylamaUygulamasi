import java.util.Scanner;

public class OylamaUygulamasi {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] konular = {"Siyasi Sorunlar", "Çevre Sorunları", "Ekonomik Sorunlar", "Güvenlik Sorunları", "Eğitim Sorunları"};
        int[][] oylar = new int[konular.length][10];
        int[] toplamPuan = new int[konular.length];
        int[] degerlendirmesayisi = new int[konular.length];
        
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Kullanıcı " + (i + 1) + " için puanlama:");
            for (int j = 0; j < konular.length; j++) {
                System.out.print(konular[j] + " için 1-10 arasında bir puan verin: ");
                int oylar1= scanner.nextInt();
                
                while (oylar1 < 1 || oylar1 > 10) {
                    System.out.print("Lütfen geçerli bir puan girin!!!: ");
                    oylar1 = scanner.nextInt();
                }
                
                oylar[j][oylar1 - 1]++;
                toplamPuan[j] += oylar1;
                degerlendirmesayisi[j]++;
            }
            System.out.println();
        }
       
        System.out.println("Puanlama Raporu:");
        for (int i = 0; i < konular.length; i++) {
            System.out.print(konular[i] + " için puanlar: ");
            for (int j = 0; j < 10; j++) {
                System.out.print((j + 1) + " puanı: " + oylar[i][j] + " ");
            }
            System.out.println();
        }

       
        System.out.println("\nOrtalama Puanlar:");
        for (int i = 0; i < konular.length; i++) {
            double ortalama = (double) toplamPuan[i] / degerlendirmesayisi[i];
            System.out.printf("%s: %.2f\n", konular[i], ortalama);
        }

        
        int maxScoreIndex = 0;
        int minScoreIndex = 0;
        for (int i = 1; i < konular.length; i++) {
            if (toplamPuan[i] > toplamPuan[maxScoreIndex]) {
                maxScoreIndex = i;
            }
            if (toplamPuan[i] < toplamPuan[minScoreIndex]) {
                minScoreIndex = i;
            }
        }
        
        System.out.println("\nEn yüksek puan alan konu: " + konular[maxScoreIndex] + " (Toplam Puan: " + toplamPuan[maxScoreIndex] + ")");
        System.out.println("En düşük puan alan konu: " + konular[minScoreIndex] + " (Toplam Puan: " + toplamPuan[minScoreIndex] + ")");
        
        scanner.close();
    }
}

