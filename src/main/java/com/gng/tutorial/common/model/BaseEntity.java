package com.gng.tutorial.common.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@Getter
public class BaseEntity {
	@CreatedDate
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}
