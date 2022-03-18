package com.gng.tutorial.practice.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@DynamicUpdate
@Entity(name = "TRAVEL_CLUB")
@Table(name = "TRAVEL_CLUB")
public class PracticeEntity {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String id;
	
	
	@Column(name = "FOUNDATION_TIME")
	private Long foundationTime;
	
	@Column(name = "INTRO")
	private String intro;
	
	@Column(name = "NAME")
	private String name;
	
	public PracticeEntity(PracticeEntity practiceEntity) {
		BeanUtils.copyProperties(practiceEntity, this);
	}

	public void setUpdatePracticeDto(UpdatePracticeDto updatePracticeDto) {

		if(ObjectUtils.isEmpty(updatePracticeDto)) {
			throw new IllegalArgumentException("Requested parameter is NULL");
		}
		
		this.intro = updatePracticeDto.getIntro();
		this.foundationTime = updatePracticeDto.getFoundationTime();
		this.name = updatePracticeDto.getName();
	}
	
	@Getter
	@Setter
	@ToString
	@Embeddable
	@NoArgsConstructor
	@AllArgsConstructor
	public static class UpdatePracticeDto {
		private Long foundationTime;
		
		private String intro;
		
		private String name;
	}
}