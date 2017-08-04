package org.gerald.and.company.repository;

import org.gerald.and.company.entity.Response;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ResponseRepository extends PagingAndSortingRepository<Response, Long> {
}
