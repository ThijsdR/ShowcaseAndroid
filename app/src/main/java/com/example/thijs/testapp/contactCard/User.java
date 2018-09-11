package com.example.thijs.testapp.contactCard;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class User implements Serializable
{
    @Expose
    private String gender;

    @Expose
    private Name name;

    @Expose
    private Location location;

    @Expose
    private String email;

    @Expose
    private String phone;

    @Expose
    private String cell;

    @Expose
    private Picture picture;

    public User(String gender, Name name, Location location, String email, String phone, String cell, Picture picture)
    {
        this.gender = gender;
        this.name = name;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.cell = cell;
        this.picture = picture;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public Name getName()
    {
        return name;
    }

    public void setName(Name name)
    {
        this.name = name;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getCell()
    {
        return cell;
    }

    public void setCell(String cell)
    {
        this.cell = cell;
    }

    public Picture getPicture()
    {
        return picture;
    }

    public void setPicture(Picture picture)
    {
        this.picture = picture;
    }

    public static class Name implements Serializable
    {
        @Expose
        String title;

        @Expose
        String first;

        @Expose
        String last;

        public Name(String title, String first, String last)
        {
            this.title = title;
            this.first = first;
            this.last = last;
        }

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public String getFirstName()
        {
            return first;
        }

        public void setFirstName(String first)
        {
            this.first = first;
        }

        public String getLastName()
        {
            return last;
        }

        public void setLastName(String last)
        {
            this.last = last;
        }
    }

    public static class Location implements Serializable
    {
        @Expose
        private String street;

        @Expose
        private String city;

        @Expose
        private String state;

        @Expose
        private String zip;

        @Expose
        private Timezone timezone;

        public Location(String street, String city, String state, String zip, Timezone timezone)
        {
            this.street = street;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.timezone = timezone;
        }

        public String getStreet()
        {
            return street;
        }

        public void setStreet(String street)
        {
            this.street = street;
        }

        public String getCity()
        {
            return city;
        }

        public void setCity(String city)
        {
            this.city = city;
        }

        public String getState()
        {
            return state;
        }

        public void setState(String state)
        {
            this.state = state;
        }

        public String getZip()
        {
            return zip;
        }

        public void setZip(String zip)
        {
            this.zip = zip;
        }

        public Timezone getTimezone()
        {
            return timezone;
        }

        public void setTimezone(Timezone timezone)
        {
            this.timezone = timezone;
        }
    }

    public static class Picture implements Serializable
    {
        @Expose
        private String large;

        @Expose
        private String medium;

        @Expose
        private String thumbnail;

        public Picture(String large, String medium, String thumbnail)
        {
            this.large = large;
            this.medium = medium;
            this.thumbnail = thumbnail;
        }

        public String getLarge()
        {
            return large;
        }

        public void setLarge(String large)
        {
            this.large = large;
        }

        public String getMedium()
        {
            return medium;
        }

        public void setMedium(String medium)
        {
            this.medium = medium;
        }

        public String getThumbnail()
        {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail)
        {
            this.thumbnail = thumbnail;
        }
    }

    public static class Timezone implements Serializable {
        @Expose
        private String offset;

        @Expose
        private String description;

        public Timezone(String offset, String description)
        {
            this.offset = offset;
            this.description = description;
        }

        public String getOffset()
        {
            return offset;
        }

        public void setOffset(String offset)
        {
            this.offset = offset;
        }

        public String getDescription()
        {
            return description;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }
    }
}
