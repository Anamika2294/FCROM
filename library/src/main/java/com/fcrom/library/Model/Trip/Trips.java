package com.fcrom.library.Model.Trip;

import java.io.Serializable;
import java.util.List;

/**
 * Created by anamika.chavan on 01-02-2018.
 */

public class Trips implements Serializable {

    private List<TripList> TripList = null;

    public List<TripList> getTripList() {
        return TripList;
    }

    public void setTripList(List<TripList> TripList) {
        this.TripList = TripList;
    }

    @Override
    public String toString() {
        return "Trips{" +
                "TripList=" + TripList +
                '}';
    }

}
