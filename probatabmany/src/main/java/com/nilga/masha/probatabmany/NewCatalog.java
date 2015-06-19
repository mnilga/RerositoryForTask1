package com.nilga.masha.probatabmany;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masha on 19.06.2015.
 */
public class NewCatalog  implements Catalog {


    private List<Request> newRequests = new ArrayList<Request>();
    private List<Request> allRequests;

    NewCatalog(List<Request> allRequests) {
        this.allRequests = allRequests;
        setRequests();
        for(Request r: allRequests){
            r.registerCatalog(this);
        }
    }

    @Override
    public List<Request> getListRequests() {
        return newRequests;
    }

    @Override
    public void update() {
        setRequests();
    }

    // Choose from all requests only requests with status NEW.
    @Override
    public void setRequests() {
        for(Request r: allRequests){
            if (r.getState() == Request.NEW_STATE) {
                newRequests.add(r);
            }
        }
    }


}
