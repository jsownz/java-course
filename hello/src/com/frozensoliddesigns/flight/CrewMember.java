package com.frozensoliddesigns.flight;

public class CrewMember {

    private FlightCrewJob job;

    public CrewMember(FlightCrewJob job){
        this.job = job;
    }

    public void setJob(FlightCrewJob job) {
        this.job = job;
    }

    public FlightCrewJob getJob(){
        return this.job;
    }


}
