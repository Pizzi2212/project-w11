import java.util.Scanner;

public class Player {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];


        int totaleLuminosita = 0;
        int totaleDurata = 0;
        int totaleVolume = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Inserisci il tipo di elemento (1 = Immagine, 2 = Video, 3 = Audio):");
            int tipo = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Inserisci il titolo:");
            String titolo = scanner.nextLine();

            if (tipo == 1) {
                System.out.println("Inserisci la luminosità:");
                int luminosita = scanner.nextInt();
                totaleLuminosita += luminosita;
                elementi[i] = new Immagine(titolo, luminosita);
            } else if (tipo == 2) {
                System.out.println("Inserisci la durata, il volume e la luminosità:");
                int durata = scanner.nextInt();
                int volume = scanner.nextInt();
                int luminosita = scanner.nextInt();
                totaleDurata += durata;
                totaleVolume += volume;
                totaleLuminosita += luminosita;
                elementi[i] = new Video(titolo, durata, volume, luminosita);
            } else if (tipo == 3) {
                System.out.println("Inserisci la durata e il volume:");
                int durata = scanner.nextInt();
                int volume = scanner.nextInt();
                totaleDurata += durata;
                totaleVolume += volume;
                elementi[i] = new RegistrazioneAudio(titolo, durata, volume);
            } else {
                System.out.println("Tipo non valido!");
                i--;
            }
        }


        while (true) {
            System.out.println("Inserisci il numero dell'elemento da eseguire (1-5) o 0 per terminare:");
            int scelta = scanner.nextInt();

            if (scelta == 0) {
                break;
            } else if (scelta >= 1 && scelta <= 5) {
                elementi[scelta - 1].esegui();
            } else {
                System.out.println("Scelta non valida!");
            }
        }


        System.out.println("\n--- Resoconto Finale ---");
        System.out.println("Luminosità totale inserita: " + totaleLuminosita);
        System.out.println("Durata totale inserita: " + totaleDurata);
        System.out.println("Volume totale inserito: " + totaleVolume);

        scanner.close();
    }
}
