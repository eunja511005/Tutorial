package com.eun.tutorial.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZthhErrorDTO implements Serializable{
	private static final long serialVersionUID = -732467492044961075L;
	
	private Long id;
    private String errorMessage;
    private String createId;
    private String createTime;
    private String updateId;
    private String updateTime;
}
