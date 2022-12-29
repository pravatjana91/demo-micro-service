package com.td.departmentmicroservice.entity;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;


@Entity
@Data
@Table(name = "department")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(nullable = false)
	private Long departmentId;

	@Basic(optional = false)
	@Column(name = "department_name", nullable = false, length = 50)
	private String departmentName;

	@Basic(optional = false)
	@Column(name = "department_address", nullable = false, length = 50)
    private String departmentAddress;
	
	@Basic(optional = false)
	@Column(name = "department_code", nullable = false, length = 50)
    private String departmentCode;
}