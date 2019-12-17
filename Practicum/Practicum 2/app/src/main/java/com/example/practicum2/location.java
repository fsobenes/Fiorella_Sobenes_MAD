package com.example.practicum2;

public class location {
    private String place;
    private String placeURL;

    private void placeInfo(Integer placeChosen){
        switch (placeChosen){
            case 0: //hill
                place="The Hill";
                placeURL="https://www.illegalpetes.com/";
                break;
            case 1: //chipotle
                place="Chipotle";
                placeURL="https://www.chipotle.com";
                break;
            case 2:
                place="Bar Taco";
                placeURL="https://www.bartaco.com";
            default:
                place="Bar Taco";
                placeURL="https://www.bartaco.com";
        }
    }

    public String getPlace() {return place; }

    public String getPlaceURL() {return placeURL;}

    public void setPlace(Integer placeChosen){placeInfo(placeChosen);}

    public void setPlaceURL(Integer placeChosen){placeInfo(placeChosen);}
}
