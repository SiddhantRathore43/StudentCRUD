package com.crud.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.work.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	
//	Repository:
//
//		Repository : marker interface 
//
//			CrudRepository: CRUD
//			PaginationAndSortingRepository : CRUD + pagination + sorting + searching
//			JpaRepository : CRUD + pagination + sorting + searching + batches…
//			Mongo : MongoRepository.
//			Redis : KeyValueRepository.
//			ElasticSearch : ElasticSearchRepository .
}
