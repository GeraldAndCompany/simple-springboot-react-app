package org.gerald.and.company.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@Data
@Entity
public class QuestionAnswerPair {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Response response;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Question question;
    @OneToMany(mappedBy = "answer")
    private List<Answer> answer;
}
