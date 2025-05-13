import java.util.*;

public class Encrypt {

    public static boolean asalMi(int sayi) {
        if (sayi < 2) return false;
        for (int i = 2; i <= Math.sqrt(sayi); i++) {
            if (sayi % i == 0) return false;
        }
        return true;
    }

    public static List<Integer> asalBul(int bas, int son) {
        List<Integer> liste = new ArrayList<>();
        for (int i = bas; i <= son; i++) {
            if (asalMi(i)) {
                liste.add(i);
            }
        }
        return liste;
    }

    public static List<Integer> sifrele(String metin, int anahtar) {
        List<Integer> sonuc = new ArrayList<>();
        for (char harf : metin.toCharArray()) {
            sonuc.add((int) harf + anahtar);
        }
        return sonuc;
    }

    public static void main(String[] args) {
        Scanner giris = new Scanner(System.in);
        int bas, son;

        try {
            System.out.print("Aralik baslangic degerini girin: ");
            bas = giris.nextInt();
            System.out.print("Aralik bitis degerini girin: ");
            son = giris.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Hata: Lutfen sayi giriniz.");
            return;
        }

        List<Integer> asalSayilar = asalBul(bas, son);
        if (asalSayilar.size() < 2) {
            System.out.println("Yeterli asal sayi yok.");
            return;
        }

        Random r = new Random();
        int asal1 = asalSayilar.get(r.nextInt(asalSayilar.size()));
        int asal2 = asalSayilar.get(r.nextInt(asalSayilar.size()));
        int anahtar = (asal1 * asal2) % 256;

        System.out.println("Secilen asal sayilar: " + asal1 + " ve " + asal2);
        System.out.println("Olusan anahtar: " + anahtar);

        giris.nextLine();
        System.out.print("Sifrelenecek metni girin: ");
        String metin = giris.nextLine();

        List<Integer> sifreliMetin = sifrele(metin, anahtar);
        System.out.print("Sifreli metin (ASCII sayilar): ");
        for (int sayi : sifreliMetin) {
            System.out.print(sayi + " ");
        }

        System.out.println("\n\nBu verileri 'Decrypt.java' programina girerek cozum yapabilirsiniz.");
        System.out.println("Anahtar: " + anahtar);
    }
}
