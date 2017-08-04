package org.gerald.and.company.repository;

import org.gerald.and.company.entity.Answer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AnswerRepository  extends PagingAndSortingRepository<Answer, Long> {
}
