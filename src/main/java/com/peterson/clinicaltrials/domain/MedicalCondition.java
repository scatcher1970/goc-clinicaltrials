package com.peterson.clinicaltrials.domain;

import com.peterson.clinicaltrials.abstracts.Retrievable;
import lombok.Data;

@Data
public class MedicalCondition extends Retrievable implements Comparable<MedicalCondition> {

    private String med_condition_id;
    private String med_condition;

    public int compareTo(MedicalCondition medicalCondition) {
        return this.getMed_condition().compareTo(medicalCondition.getMed_condition());
    }
}
