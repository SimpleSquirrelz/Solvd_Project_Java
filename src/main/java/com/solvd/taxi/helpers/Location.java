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
        logger.info("Location created: " + this);
    }

    public Location(String country, String city, String region, String street, String buildingNumber) {
        this.country = country;
        this.city = city;
        this.region = region;
        this.street = street;
        this.buildingNumber = buildingNumber;
        logger.info("Location created: " + this);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        logger.info("Location country changed in" + this +
                "\nTo: " + country);
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        logger.info("Location city changed in" + this +
                "\nTo: " + city);
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        logger.info("Location region changed in" + this +
                "\nTo: " + region);
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        logger.info("Location street changed in" + this +
                "\nTo: " + street);
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        logger.info("Location building number changed in" + this +
                "\nTo: " + buildingNumber);
        this.buildingNumber = buildingNumber;
    }

    public void setLocation(Location location) {
        this.country = location.getCountry();
        this.city = location.getCity();
        this.street = location.getStreet();
        this.buildingNumber = location.getBuildingNumber();
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s", country, city, region, street, buildingNumber);
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
