package com.gng.tutorial.test.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gng.tutorial.test.model.TestEntity;
import com.gng.tutorial.test.service.TestService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Test controller
 * @author gchyoo
 *
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class TestController {
	private final TestService testService;
	
	@GetMapping("/api/hello")
	public String hello() {
		log.info("Hello called ...");
		return String.format("Hello Spring boot! %s", new Date());
	}
	
	@GetMapping("/api/all")
	public List<TestEntity> findAll() {
		return testService.findAll();
	}
	
	@GetMapping("/api/id/{id}")
	public List<TestEntity> findById(@PathVariable(required = true) Long id) {
		return testService.findById(id);
	}

	@GetMapping("/api/value")
	public List<TestEntity> findByValue(@RequestParam(required = true) String value) {
		return testService.findByValue(value);
	}

	@GetMapping("/api/valuecontaining")
	public List<TestEntity> findByValueContaining(@RequestParam(required = true) String value) {
		return testService.findByValueContaining(value);
	}
}
