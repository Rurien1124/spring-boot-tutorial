package com.gng.tutorial.test.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gng.tutorial.test.model.TestEntity;
import com.gng.tutorial.test.repository.TestRepository;
import com.google.common.collect.Lists;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Test service
 * @author gchyoo
 *
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class TestService {
	private final TestRepository testRepository;
	
	public List<TestEntity> findAll() {
		log.debug("Find all testEntity");
		
		return testRepository.findAll().stream()
				.collect(Collectors.toList());
	}

	public List<TestEntity> findById(Long id) {
		log.debug("Find testEntity by id [{}]", id);
		
		List<TestEntity> testEntityList = Lists.newArrayList();
		
		testRepository.findById(id).ifPresent(testEntity -> {
			if(testEntity != null) {
				testEntityList.add(testEntity);
			}
		});
		
		return testEntityList;
	}

	public List<TestEntity> findByValue(String value) {
		log.debug("Find testEntity by value [{}]", value);
		
		return testRepository.findByValue(value);
	}

	public List<TestEntity> findByValueContaining(String value) {
		log.debug("Find testEntity by value like [%{}%]", value);
		
		return testRepository.findByValueContaining(value);
	}
}
