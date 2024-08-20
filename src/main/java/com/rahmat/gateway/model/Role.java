package com.rahmat.gateway.model;



import com.rahmat.gateway.model.enumeration.ERole;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;
	private String access;
}
