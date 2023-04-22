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
import com.eun.tutorial.mapper.ZthhBoardMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class ZthhBoardServiceImpl implements ZthhBoardService {

	private final ZthhBoardMapper zthhBoardMapper;
	private static final Logger logger = LoggerFactory.getLogger(ZthhBoardServiceImpl.class);

    @Override
    public int save(ZthhBoardDTO zthhBoardDTO) {
    	if(StringUtils.isBlank(zthhBoardDTO.getBoardId())) {
    		UUID uuid = UUID.randomUUID();
    		String boardId = "board_"+uuid;
    		zthhBoardDTO.setBoardId(boardId);
    	}
        
        // 1. insert EMPTY_CLOB()
        zthhBoardMapper.save(zthhBoardDTO);
    	
    	
        // 2. update 실제 content
    	return zthhBoardMapper.save(zthhBoardDTO);
    }

    @Override
    public List<ZthhBoardDTO> findAll() {
        return zthhBoardMapper.findAll();
    }

	@Override
	public ZthhBoardDTO getOne(Map<String, Object> map) {
		return zthhBoardMapper.getOne(map);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return zthhBoardMapper.delete(id);
	}
}