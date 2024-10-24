package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Practica {
    public void Ejercicio(){

        Scanner entrada = new Scanner(System.in);

        String ISBN;
        char Digitos;
        String DigitosString;
        int DigitoInt;
        int NumInterrogación = 0;
        char Ultimodigito;
        int Error = 0;
        int Reparar = 0;
        int UsaX = 0;
        int i;
        int Multiplicación;
        int Suma = 0;
        int num = 11;
        int Posicion = 0;

        while(true) {

            Error = 0;
            NumInterrogación = 0;
            Reparar = 0;
            UsaX = 0;

            System.out.println("Introduzca el ISBN:");

            ISBN = entrada.nextLine();

            int LongitudISBN = ISBN.length();

            if (LongitudISBN == 10) {

                for (i = 0; i<10; i++){

                    Digitos = ISBN.charAt(i);

                    DigitosString = Character.toString(Digitos);

                if (DigitosString.equals("?")){
                    NumInterrogación++;
                    Reparar = 1;
                    Posicion = i;

                }else if (i == 9 && DigitosString.equals("X")){
                    UsaX = 1;
                    break;

                }else {

                        try {
                            DigitoInt = Integer.parseInt(DigitosString);

                        }catch(NumberFormatException err) {
                            Error = 1;
                            break;
                        }
                }
                }

                if ((NumInterrogación == 0 || NumInterrogación == 1) && Error == 0) {
                    break;

                }else{
                    System.out.println("Error al introducir el ISBN. Vuelve a intentarlo...");
                }

            }else {
                System.out.println("Error al introducir el ISBN. Vuelve a intentarlo...");
            }

        }

        if (Reparar == 0 && UsaX == 0){

            for (i = 0; i<10; i++){

                Digitos = ISBN.charAt(i);
                DigitosString = Character.toString(Digitos);
                DigitoInt = Integer.parseInt(DigitosString);
                num--;
                Multiplicación = DigitoInt * num;
                Suma = Suma + Multiplicación;
            }

            if (Suma % 11 == 0){
                System.out.println("El ISBN es válido.");

            }else {
                System.out.println("El ISBN no es válido.");
            }

        }else if (UsaX == 1 && Reparar == 0 ){

            for (i = 0; i<9; i++){

                Digitos = ISBN.charAt(i);
                DigitosString = Character.toString(Digitos);
                DigitoInt = Integer.parseInt(DigitosString);
                num--;
                Multiplicación = DigitoInt * num;
                Suma = Suma + Multiplicación;
            }

            if ((Suma + 10) % 11 == 0){
                System.out.println("El ISBN es válido.");

            }else {
                System.out.println("El ISBN no es válido.");
            }

        }else if (UsaX == 0 && Reparar == 1 ){

        for (i = 0; i<Posicion; i++){

            Digitos = ISBN.charAt(i);
            DigitosString = Character.toString(Digitos);
            DigitoInt = Integer.parseInt(DigitosString);
            num--;
            Multiplicación = DigitoInt * num;
            Suma = Suma + Multiplicación;
        }

        Posicion++;
        num = 11;
        num = num - Posicion;

        for (i = Posicion++; i<10; i++){
            Digitos = ISBN.charAt(i);
            DigitosString = Character.toString(Digitos);
            DigitoInt = Integer.parseInt(DigitosString);
            num--;
            Multiplicación = DigitoInt * num;
            Suma = Suma + Multiplicación;
        }

        Posicion = Posicion - 2;
        for (i = 0; i<10; i++){
            if((i * (10 - Posicion) + Suma)% 11 == 0){
                System.out.println("El dígito que falta es " + i);
                break;
            }
        }

        }else if (UsaX == 1 && Reparar == 1 ){

        for (i = 0; i<Posicion; i++){

            Digitos = ISBN.charAt(i);
            DigitosString = Character.toString(Digitos);
            DigitoInt = Integer.parseInt(DigitosString);
            num--;
            Multiplicación = DigitoInt * num;
            Suma = Suma + Multiplicación;
        }

        Posicion++;
        num = 11;
        num = num - Posicion;

        for (i = Posicion++; i<9; i++){
            Digitos = ISBN.charAt(i);
            DigitosString = Character.toString(Digitos);
            DigitoInt = Integer.parseInt(DigitosString);
            num--;
            Multiplicación = DigitoInt * num;
            Suma = Suma + Multiplicación;
        }

        Posicion = Posicion - 2;
        for (i = 0; i<10; i++){
            if((i * (10 - Posicion) + Suma + 10)% 11 == 0){
                System.out.println("El dígito que falta es " + i);
                break;
            }
        }
    }
    }
}