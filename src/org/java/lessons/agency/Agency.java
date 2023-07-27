package org.java.lessons.agency;

/*
Aggiungere una classe Agenzia con metodo main, dove chiediamo all’operatore se vuole inserire una nuova vacanza o uscire.
Se vuole proseguire con l’inserimento va chiesta la destinazione, il giorno, mese e anno di partenza e il giorno, mese anno di ritorno.
Con questi dati va generata una nuova vacanza e in console verrà stampato un messaggio del tipo:
“Hai prenotato una vacanza di [numero di giorni] giorni a [destinazione] dal [data inizio formattata] al [data fine formattata]“.
Se la creazione della vacanza genera un errore, il programma non deve interrompersi ma va gestito con dei messaggi di errore
che permettono all’utente di capire cosa è andato storto e di ripetere l’inserimento.
 */

import java.time.LocalDate;
import java.util.Scanner;

public class Agency {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Holiday userHoliday = null;

        while (userHoliday == null){
            System.out.println("*** WELCOME TO JAVA TRAVEL AGENCY ***");

            System.out.print("Enter holiday destination: ");
            String destination = null;
            try {
                destination = scan.nextLine();
            } catch (RuntimeException exception){
                System.out.println("Invalid destination.");
            }

            System.out.print("Enter start date: ");
            LocalDate startDate = null;
            try{
                startDate = LocalDate.parse(scan.nextLine());
            } catch (RuntimeException exception){
                System.out.println("Invalid start date.");
            }

            System.out.print("Enter end date: ");

            LocalDate endDate = null;
            try{
                endDate = LocalDate.parse(scan.nextLine());
            } catch (RuntimeException exception){
                System.out.println("Invalid holiday parameters. Try again!");
            }

            try{
                userHoliday = new Holiday(destination, startDate,endDate);
            } catch (RuntimeException exception){
                System.out.println("Invalid input.");
            }
        }
        System.out.println("You booked a holiday" + " of " + userHoliday.getTotalDays() + " days to " + userHoliday.getDestination()
                + ", from " +  userHoliday.getStartDate() + " to " + userHoliday.getEndDate() + ".");
        scan.close();
    }
}
