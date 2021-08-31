package com.peterson.clinicaltrials.domain;

import com.peterson.clinicaltrials.abstracts.Retrievable;
import lombok.Data;

@Data
public class Status extends Retrievable implements Comparable<Status> {

    private String status_id;
    private String status;

    @Override
    public int compareTo(Status status) {
        return this.getStatus().compareTo(status.getStatus());
    }
}
