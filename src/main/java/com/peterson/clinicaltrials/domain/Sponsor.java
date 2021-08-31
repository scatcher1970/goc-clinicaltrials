package com.peterson.clinicaltrials.domain;

import com.peterson.clinicaltrials.abstracts.Retrievable;
import lombok.Data;

@Data
public class Sponsor extends Retrievable implements Comparable<Sponsor> {

    private String manufacturer_id;
    private String manufacturer_name;

    @Override
    public int compareTo(Sponsor sponsor) {
        return this.getManufacturer_name().compareTo(sponsor.getManufacturer_name());
    }
}
