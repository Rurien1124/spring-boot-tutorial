package com.gng.tutorial.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gng.tutorial.practice.model.PracticeEntity;

@Repository
public interface PracticeRepository extends JpaRepository<PracticeEntity, String> {
}