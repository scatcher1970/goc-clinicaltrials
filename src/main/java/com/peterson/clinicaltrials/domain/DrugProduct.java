package com.peterson.clinicaltrials.domain;

import com.peterson.clinicaltrials.abstracts.JsonRepository;
import com.peterson.clinicaltrials.abstracts.Retrievable;
import lombok.Data;

@Data
public class DrugProduct extends Retrievable implements Comparable<DrugProduct> {

    private String protocol_id;
    private String submission_no;
    private String brand_id;
    private String manufacturer_id;
    private String manufacturer_name;
    private String brand_name;

    @Override
    public int compareTo(DrugProduct drugProduct) {
        return this.getBrand_name().compareTo(drugProduct.getBrand_name());
    }
}
