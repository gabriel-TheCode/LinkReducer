/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecode.models;

import java.sql.Date;

/**
 *
 * @author gabrielthecode
 */
public class Link {

    public int id;
    public String url;
    public String code;
    public Date creationDate;
    public String username;
    public int visit;

    public Link() {

    }

    public Link(int id) {
        this.id = id;
    }

    public Link(int id, String url, String code, Date creationDate, String username, int visit) {
        this.id = id;
        this.url = url;
        this.code = code;
        this.creationDate = creationDate;
        this.username = username;
        this.visit = visit;
    }
    
    public Link(int id, String url, String code, Date creationDate, String username) {
        this.id = id;
        this.url = url;
        this.code = code;
        this.creationDate = creationDate;
        this.username = username;
    }


    public Link(String url, String code, Date creationDate, String username, int visit) {
        this.url = url;
        this.code = code;
        this.creationDate = creationDate;
        this.username = username;
        this.visit = visit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getVisit() {
        return visit;
    }

    public void setVisit(int visit) {
        this.visit = visit;
    }

}
