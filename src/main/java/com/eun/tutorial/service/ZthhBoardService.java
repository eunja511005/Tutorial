package com.eun.tutorial.service;

import java.util.List;
import java.util.Map;

import com.eun.tutorial.dto.ZthhBoardDTO;
import com.eun.tutorial.dto.ZthhFileAttachDTO;

public interface ZthhBoardService {
	int save(ZthhBoardDTO zthhBoard);
	List<ZthhBoardDTO> findAll();
	ZthhBoardDTO getOne(Map<String, Object> map);
}