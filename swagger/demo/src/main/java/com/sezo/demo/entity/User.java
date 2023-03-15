package com.sezo.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@ApiModel(description = "Details about the  User")
public class User {
	
	@ApiModelProperty(notes = "Unique id for user")
	private Long id;
	
	@ApiModelProperty(notes = "User name")
	private String name;
	
	@ApiModelProperty(notes = "User surname")
	private String surname;
}
