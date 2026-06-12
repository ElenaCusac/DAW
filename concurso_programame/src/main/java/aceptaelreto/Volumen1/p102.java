package aceptaelreto.Volumen1;

import java.util.Scanner;

public class p102 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {

            String linea = sc.nextLine();

            char codigoP = linea.charAt(0);
            int desplazamiento = codigoP - 'p';

            StringBuilder descifrado = new StringBuilder();
            int vocales = 0;

            for (int i = 1; i < linea.length(); i++) {

                char c = linea.charAt(i);

                if (c >= 'a' && c <= 'z') {

                    int pos = c - 'a';
                    pos = (pos - desplazamiento + 26) % 26;
                    c = (char) ('a' + pos);

                } else if (c >= 'A' && c <= 'Z') {

                    int pos = c - 'A';
                    pos = (pos - desplazamiento + 26) % 26;
                    c = (char) ('A' + pos);
                }
                descifrado.append(c);

                if ("aeiouAEIOU".indexOf(c) != -1)
                    vocales++;
            }

            if (descifrado.toString().equals("FIN"))
                break;

            System.out.println(vocales);
        }

        sc.close();
    }
}