import java.util.Scanner;

public class TicTacToe {
    private static char[][] papan = new char[3][3];
    private static char pemainSekarang = 'X';

    public static void main(String[] args) {
        inisialisasiPapan();
        cetakPapan();

        Scanner scanner = new Scanner(System.in);

        boolean permainanBerakhir = false;
        int jumlahLangkah = 0;

        while (!permainanBerakhir) {
            System.out.println("Pemain " + pemainSekarang + ", masukkan baris (0-2) dan kolom (0-2) dipisahkan spasi: ");
            int baris = scanner.nextInt();
            int kolom = scanner.nextInt();

            if (isValidLangkah(baris, kolom)) {
                papan[baris][kolom] = pemainSekarang;
                cetakPapan();
                jumlahLangkah++;

                if (cekMenang(baris, kolom)) {
                    System.out.println("Pemain " + pemainSekarang + " menang!");
                    permainanBerakhir = true;
                } else if (jumlahLangkah == 9) {
                    System.out.println("Permainan berakhir seri!");
                    permainanBerakhir = true;
                } else {
                    pemainSekarang = (pemainSekarang == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Langkah tidak valid. Coba lagi.");
            }
        }

        scanner.close();
    }

    private static void inisialisasiPapan() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                papan[i][j] = ' ';
            }
        }
    }

    private static void cetakPapan() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(papan[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static boolean isValidLangkah(int baris, int kolom) {
        return (baris >= 0 && baris < 3 && kolom >= 0 && kolom < 3 && papan[baris][kolom] == ' ');
    }

    private static boolean cekMenang(int baris, int kolom) {
        return (papan[baris][0] == pemainSekarang && papan[baris][1] == pemainSekarang && papan[baris][2] == pemainSekarang) ||
               (papan[0][kolom] == pemainSekarang && papan[1][kolom] == pemainSekarang && papan[2][kolom] == pemainSekarang) ||
               (baris == kolom && papan[0][0] == pemainSekarang && papan[1][1] == pemainSekarang && papan[2][2] == pemainSekarang) ||
               ((baris + kolom) == 2 && papan[0][2] == pemainSekarang && papan[1][1] == pemainSekarang && papan[2][0] == pemainSekarang);
    }
}
