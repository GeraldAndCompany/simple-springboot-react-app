package org.gerald.and.company.repository;

import org.gerald.and.company.entity.Survey;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SurveyRepository extends PagingAndSortingRepository<Survey, Long> {
}
