package com.solvd.taxi.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Location {
    private String country;
    private String city;
    private String region;
    private String street;
    private String buildingNumber;

    private final Logger logger = LogManager.getLogger(Location.class);

    public Location() {
        this.country = "NoCountry";
        this.city = "NoCity";
        this.region = "NoRegion";
        this.street = "NoStreet";
        this.buildingNumber = "0-A";
        logger.info("Object created: " + this);
    }

    public Location(String country, String city, String region, String street, String buildingNumber) {
        this.country = country;
        this.city = city;
        this.region = region;
        this.street = street;
        this.buildingNumber = buildingNumber;
        logger.info("Object created: " + this);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    @Override
    public String toString() {
        return "Location {\n" +
                "country='" + country + "',\n" +
                "city='" + city + "',\n" +
                "region='" + region + "',\n" +
                "street='" + street + "',\n" +
                "buildingNumber='" + buildingNumber + "',\n" +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Location location = (Location) object;
        return country.equals(location.country) &&
                city.equals(location.city) &&
                region.equals(location.region) &&
                street.equals(location.street) &&
                buildingNumber.equals(location.buildingNumber);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((region == null) ? 0 : region.hashCode());
        result = prime * result + ((street == null) ? 0 : street.hashCode());
        result = prime * result + ((buildingNumber == null) ? 0 : buildingNumber.hashCode());

        return result;
    }
}
