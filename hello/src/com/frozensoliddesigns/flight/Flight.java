package com.frozensoliddesigns.flight;


public class Flight {
    static final int MAX_FAA_SEATS = 550;
    private int passengers, flightNumber,
                totalCheckedBags, maxCarryOns = getSeats() * 2, totalCarryOns;
    private char flightClass;
    private boolean[] isSeatAvailable;
    public int getSeats() { return 150; }
    private int seats = getSeats();

    {
        isSeatAvailable = new boolean[getSeats()];

        for(int i = 0; i < getSeats(); i++){
            isSeatAvailable[i] = true;
        }
    }

    public Flight() { }

    public Flight(int seats, int passengers) {
        if (seats <= MAX_FAA_SEATS) {
            this.seats = seats;
        }
        this.passengers = passengers;
    }

    public Flight(int flightNumber){
        this.flightNumber = flightNumber;
    }

    public Flight(char flightClass) {
        this.flightClass = flightClass;
    }

    public void addPassenger() {
        if (hasSeating()) {
            this.passengers += 1;
        } else {
            handleTooMany();
        }
    }

    public void addPassenger(int bags){
        if (hasSeating()){
            addPassenger();
            totalCheckedBags += bags;
        }
    }

    public void addPassenger(int bags, int carryOns) {
        if (hasSeating() && hasCarryOnSpace(carryOns)){
            addPassenger(bags);
            totalCarryOns += carryOns;
        }
    }

    public void addPassenger(Passenger p) {
        addPassenger(p.getCheckedBags());
    }

    public void addPassenger(Passenger p, int carryOns) {
        addPassenger(p.getCheckedBags(), carryOns);
    }


    public void addPassengers(Passenger... list){
        if (hasSeating(list.length)) {
            this.passengers += list.length;
            for (Passenger passenger : list) {
                totalCheckedBags += passenger.getCheckedBags();
            }
        } else {
            handleTooMany();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o))
            return true;
        if (!(o instanceof Flight))
            return false;
        Flight other  = (Flight) o;
        return flightNumber == other.flightNumber && flightClass == other.flightClass;
    }


    public int getPassengers() {
        return this.passengers;
    }

    private void handleTooMany(){
        System.out.println("Too many passengers");
    }

    private boolean hasSeating(){
        return this.passengers < getSeats();
    }

    private boolean hasSeating(int count){
        return this.passengers + count <= getSeats();
    }

    private boolean hasCarryOnSpace(int carryOns){
        return totalCarryOns + carryOns <= maxCarryOns;
    }
}
