package com.engineerhub.dataconsumeandexpose;

import org.springframework.data.repository.CrudRepository;

public interface SimpleRepository extends CrudRepository<SimpleEntity, Integer> {
}
