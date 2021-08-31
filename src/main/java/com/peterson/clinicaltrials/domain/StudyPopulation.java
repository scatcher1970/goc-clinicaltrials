package com.peterson.clinicaltrials.domain;

import com.peterson.clinicaltrials.abstracts.Retrievable;
import lombok.Data;

@Data
public class StudyPopulation extends Retrievable implements Comparable<StudyPopulation> {

    private String study_population_id;
    private String study_population;

    public int compareTo (StudyPopulation population) {
        return this.getStudy_population().compareTo(population.getStudy_population());
    }
}