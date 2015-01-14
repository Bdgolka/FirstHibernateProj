package org.julia.javabrains.dto;

import javax.annotation.Generated;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GenerationType;

@Entity
public class TwoWheeler extends Vehicle {
	
	private String SteeringHandle;

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}

}
