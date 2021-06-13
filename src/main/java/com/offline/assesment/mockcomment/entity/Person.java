package com.offline.assesment.mockcomment.entity;

import java.time.LocalDateTime;

/** @author <a href  swati.gbpant@gmail.com</>**/
public class Person  {

    private String name;
    private Boolean loggedIn;
    private LocalDateTime lastLoggedInTime;
    private String role;

    public String getName() {
        return name;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public LocalDateTime getLastLoggedInTime() {
        return lastLoggedInTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void setLastLoggedInTime() {
        this.lastLoggedInTime = LocalDateTime.ofInstant(java.time.Instant.now(), java.time.ZoneOffset.UTC);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
