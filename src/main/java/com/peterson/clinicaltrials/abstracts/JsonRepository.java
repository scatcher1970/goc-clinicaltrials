package com.peterson.clinicaltrials.abstracts;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public abstract class JsonRepository {

    private static final Integer CACHE_DURATION = 60;

    private LocalDateTime lastRetrievedTime;

    protected abstract void performFetch();

    public abstract ArrayList<?> getArray();

    protected void getObjects () {

        LocalDateTime now = LocalDateTime.now();

        if ((this.lastRetrievedTime == null) || (ChronoUnit.SECONDS.between(this.lastRetrievedTime, now) > CACHE_DURATION)) {
            this.lastRetrievedTime = now;
            performFetch();
            System.out.println("Web");
        } else {
            System.out.println("Cache");
        }
    }
}
