package com.eun.tutorial.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.tika.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eun.tutorial.dto.ZthhBoardDTO;
import com.eun.tutorial.dto.ZthmCommonCodeDTO;
import com.eun.tutorial.mapper.ZthhBoardMapper;
import com.eun.tutorial.mapper.ZthmCommonCodeMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class ZthmCommonCodeServiceImpl implements ZthmCommonCodeService {

	private final ZthmCommonCodeMapper zthmCommonCodeMapper;
	private static final Logger logger = LoggerFactory.getLogger(ZthmCommonCodeServiceImpl.class);
	
	@Override
	public int save(ZthmCommonCodeDTO zthmCommonCodeDTO) {
		return zthmCommonCodeMapper.save(zthmCommonCodeDTO);
	}
	@Override
	public List<ZthmCommonCodeDTO> findAll() {
		return zthmCommonCodeMapper.findAll();
	}
	@Override
	public ZthmCommonCodeDTO findOne(Map<String, Object> map) {
		return zthmCommonCodeMapper.findOne(map);
	}
	@Override
	public int delete(String id) {
		return zthmCommonCodeMapper.delete(id);
	}

}