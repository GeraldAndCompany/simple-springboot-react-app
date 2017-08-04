package org.gerald.and.company.repository;

import org.gerald.and.company.entity.QuestionAnswerPair;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuestionAnswerPairRepository extends PagingAndSortingRepository<QuestionAnswerPair, Long> {
}
