import java.util.*;

public class Decrypt {

    public static String coz(List<Integer> sayilar, int anahtar) {
        StringBuilder sonuc = new StringBuilder();
        for (int sayi : sayilar) {
            sonuc.append((char)(sayi - anahtar));
        }
        return sonuc.toString();
    }

    public static void main(String[] args) {
        Scanner giris = new Scanner(System.in);

        System.out.print("Anahtari girin: ");
        int anahtar = giris.nextInt();

        System.out.print("Sifreli metni girin (boslukla ayrilmis sayilar): ");
        giris.nextLine();
        String satir = giris.nextLine();

        String[] parcalar = satir.trim().split("\\s+");
        List<Integer> sayilar = new ArrayList<>();
        for (String parca : parcalar) {
            try {
                sayilar.add(Integer.parseInt(parca));
            } catch (NumberFormatException e) {
                System.out.println("Gecersiz sayi: " + parca);
                return;
            }
        }

        String cozulmus = coz(sayilar, anahtar);
        System.out.println("Cozulmus metin: " + cozulmus);
    }
}
