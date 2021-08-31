package com.peterson.clinicaltrials.domain;

import com.peterson.clinicaltrials.abstracts.Retrievable;
import lombok.Data;

@Data
public class Protocol extends Retrievable implements Comparable<Protocol> {

    private String protocol_id;
    private String protocol_no;
    private String submission_no;
    private String status_id;
    private String start_date;
    private String end_date;
    private String nol_date;
    private String protocol_title;
    private MedicalCondition[] medConditionList;
    private StudyPopulation[] studyPopulationList;

    public int compareTo(Protocol protocol) {
        return this.getProtocol_title().compareTo(protocol.getProtocol_title());
    }
}
