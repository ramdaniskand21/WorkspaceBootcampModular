package core.service.master.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.spring.Paging;
import common.util.StringUtil;
import share.AnkSupirDto;
import core.dao.master.AnkSupirDao;
import core.model.AnkSupir;
import core.service.NumberGeneratorSvc;
import core.service.master.AnkSupirSvc;

@Service
@Transactional
public class AnkSupirSvcImpl implements AnkSupirSvc{

	@Autowired
	AnkSupirDao ankSupirDao;
	
	@Autowired
	NumberGeneratorSvc numberGeneratorSvc;
	
	@Autowired
	MapperFacade mapperFacade;
	
	Paging page = new Paging();
	
	@Override
	public void save(AnkSupirDto ankSupirDto) {
		String supirId = "";
		if(ankSupirDto.getSupirId()==null)
			supirId = numberGeneratorSvc.getNextNumericNumber(ankSupirDto.getCompanyCode(), "GL02", ankSupirDto.getCreatedBy());
		else
			supirId = ankSupirDto.getSupirId();
		
		AnkSupir ankSupir = mapperFacade.map(ankSupirDto, AnkSupir.class);
		ankSupir.setSupirId(supirId);
		ankSupirDao.save(ankSupir);
	}

	@Override
	public Map<String, Object> loadList(Map<String, Object> mapInput, String search, int pageSequence, int size, String direction, String orderBy) {
		// TODO Auto-generated method stub
		if(orderBy.isEmpty()){
			orderBy = "supirNama";
		}
		direction = "asc";
		Page<AnkSupir> datas = ankSupirDao.getDataloadList(StringUtil.nevl("%"+search+"%", "%%"), page.getPageable(pageSequence, size, direction, orderBy));
		List<AnkSupirDto> dtos = new ArrayList<AnkSupirDto>();
		
		for(AnkSupir o : datas){
			dtos.add(mapperFacade.map(o, AnkSupirDto.class));
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", datas.getTotalElements());
		map.put("contentData", dtos);
		return map;
	}
}
