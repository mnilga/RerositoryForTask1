package com.nilga.masha.probatabmany;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masha on 19.06.2015.
 */
public class Request {

    private int number;
    private String login;
    private String name;
    private int state;

    static final int NEW_STATE = 1;
    static final int CURRENT_STATE = 2;
    static final int DONE_STATE = 3;


    private List<Catalog> catalogs;

    Request(int number, String login, int state){
        this.number = number;
        this.login = login;
        this.state = state;
        catalogs = new ArrayList<Catalog>();
    }

    public void registerCatalog(Catalog catalog){
        catalogs.add(catalog);
    }

    public void removeCatalog(Catalog catalog){
        int i = catalogs.indexOf(catalog);
        if (i>=0) {
            catalogs.remove(i);
        }
    }

    public void notifyCatalog(){
        for(Catalog c: catalogs){
            c.update();
        }
    }

    public int getNumber() {
        return number;
    }

    public int getState() {
        return state;
    }

    void changeState(int state){
        this.state = state;
        notifyCatalog();
    }



}
