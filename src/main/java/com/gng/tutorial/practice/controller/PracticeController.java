package com.gng.tutorial.practice.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gng.tutorial.practice.model.PracticeEntity;
import com.gng.tutorial.practice.model.PracticeEntity.UpdatePracticeDto;
import com.gng.tutorial.practice.service.PracticeService;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/club")
@RequiredArgsConstructor
@RestController
public class PracticeController {
	private final PracticeService practiceService;

	private Gson gson = new Gson();
	
	@PostMapping
	public PracticeEntity createClub(
			@RequestBody PracticeEntity practiceEntity
			) {
		log.debug("Create club [{}]", gson.toJson(practiceEntity));
		
		return practiceService.createClub(practiceEntity);
	}
	
	@GetMapping("/{id}")
	public PracticeEntity findClub(
			@PathVariable(required = true) String id
			) {
		return practiceService.findClub(id);
	}
	
	@PostMapping("/{id}")
	public PracticeEntity updateClub(
			@PathVariable(required = true) String id,
			@RequestBody(required = true) UpdatePracticeDto updateDto
			) {
		PracticeEntity practiceEntity = practiceService.findClub(id);
		
		return practiceService.updateClub(practiceEntity, updateDto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteClub(
			@PathVariable(required = true) String id
			) {
		practiceService.deleteClub(id);
	}
}
