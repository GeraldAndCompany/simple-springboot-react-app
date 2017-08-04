package org.gerald.and.company.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String surveyName;

    @OneToMany(mappedBy = "survey")
    private List<QuestionSet> questionSets;

    @OneToMany(mappedBy = "survey")
    private List<Response> responses;

    public Survey() {
    }
}
