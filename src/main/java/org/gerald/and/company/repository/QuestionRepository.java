package org.gerald.and.company.repository;

import org.gerald.and.company.entity.Question;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {
}
