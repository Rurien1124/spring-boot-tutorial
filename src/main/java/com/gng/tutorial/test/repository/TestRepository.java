package com.gng.tutorial.test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gng.tutorial.test.model.TestEntity;

/**
 * Test repository for JPA
 * @author gchyoo
 *
 */
@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {
	
	/**
	 * Find row by ID
	 */
	public Optional<TestEntity> findById(Long id);
	
	/**
	 * Find row by value 
	 */
	public List<TestEntity> findByValue(String value);
	
	/**
	 * Find row by value containing value
	 */
	public List<TestEntity> findByValueContaining(String value);
	
	
}
