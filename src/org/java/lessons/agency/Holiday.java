package org.java.lessons.agency;

/*
Consegna Nel progetto java-travel-agency, creare la classe Vacanza caratterizzata da:
- destinazione
- data inizio
- data fine
Quando viene creata una nuova Vacanza vanno effettuati dei controlli:
- destinazione, data inizio e data fine non possono essere null
- la data inizio non può essere già passata
- la data fine non può essere prima della data inizio
Se fallisce la validazione vanno sollevate opportune eccezioni
La classe Vacanza espone un metodo per calcolare la durata in giorni della vacanza.
 */

import java.time.LocalDate;
import java.time.Period;

public class Holiday {

    // FIELDS
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;


    // CONSTRUCTORS
    public Holiday(String destination, LocalDate startDate, LocalDate endDate) {

        // EXCEPTIONS
        if (destination == null){
            throw new RuntimeException("Destination can't be null.");
        }
        if (startDate == null || startDate.isBefore(LocalDate.now())){
            throw new RuntimeException("Date can't be null or in the past.");
        }

        if (endDate == null || endDate.isBefore(startDate)){
            throw new RuntimeException("Date can't be null or before start date.");
        }

        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    // GETTERS
    public String getDestination() {
        return destination;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    //SETTERS
    public void setDestination(String destination) {
        if (destination == null){
            throw new RuntimeException("Destination can't be null.");
        }
        this.destination = destination;
    }

    public void setStartDate(LocalDate startDate) {
        if (startDate == null || startDate.isBefore(LocalDate.now())){
            throw new RuntimeException("Date can't be null or in the past.");
        }
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        if (endDate == null || endDate.isBefore(startDate)){
            throw new RuntimeException("Date can't be null or before start date.");
        }
        this.endDate = endDate;
    }


    // METHODS
    public int getTotalDays(){
        Period days = Period.between(startDate,endDate);
        return days.getDays();
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "destination: '" + destination + '\'' +
                ", startDate: " + startDate +
                ", endDate: " + endDate +
                '}';
    }
}
