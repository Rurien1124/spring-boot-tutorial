package com.gng.tutorial.practice.service;

import org.springframework.stereotype.Service;

import com.gng.tutorial.practice.model.PracticeEntity;
import com.gng.tutorial.practice.model.PracticeEntity.UpdatePracticeDto;
import com.gng.tutorial.practice.repository.PracticeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PracticeService {
	private final PracticeRepository practiceRepository;

	public PracticeEntity createClub(PracticeEntity practiceEntity) {
		return practiceRepository.save(practiceEntity);
	}

	public PracticeEntity findClub(String id) {
		return practiceRepository.findById(id).orElse(null);
	}

	public PracticeEntity updateClub(PracticeEntity practiceEntity, UpdatePracticeDto updatePracticeDto) {
		practiceEntity.setUpdatePracticeDto(updatePracticeDto);
		return practiceRepository.save(practiceEntity);
	}

	public void deleteClub(String id) {
		practiceRepository.deleteById(id);;
	}
	
}
