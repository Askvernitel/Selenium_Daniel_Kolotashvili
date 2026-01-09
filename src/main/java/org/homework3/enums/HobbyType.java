package org.homework3.enums;

public enum HobbyType {
    SPORTS, READING, MUSIC;


    public String getValue(){
        return name().substring(0,1).toUpperCase() + name().substring(1).toLowerCase();
    }
}
