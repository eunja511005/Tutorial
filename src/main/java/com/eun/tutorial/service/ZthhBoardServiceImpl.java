package com.eun.tutorial.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eun.tutorial.dto.ZthhBoardDTO;
import com.eun.tutorial.mapper.ZthhBoardMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class ZthhBoardServiceImpl implements ZthhBoardService {

	private final ZthhBoardMapper zthhBoardMapper;
	private static final Logger logger = LoggerFactory.getLogger(ZthhBoardServiceImpl.class);

    @Override
    public int save(ZthhBoardDTO zthhFileAttachDTO) {
    	UUID uuid = UUID.randomUUID();
        String boardId = "board_"+uuid;
        zthhFileAttachDTO.setBoardId(boardId);
        
        // 1. insert EMPTY_CLOB()
        zthhBoardMapper.save(zthhFileAttachDTO);
    	
    	
        // 2. update 실제 content
    	return zthhBoardMapper.save(zthhFileAttachDTO);
    }

    @Override
    public List<ZthhBoardDTO> findAll() {
        return zthhBoardMapper.findAll();
    }

	@Override
	public ZthhBoardDTO getOne(Map<String, Object> map) {
		return zthhBoardMapper.getOne(map);
	}
}