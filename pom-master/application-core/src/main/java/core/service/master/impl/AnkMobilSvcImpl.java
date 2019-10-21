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
import share.AnkMobilDto;
import core.dao.master.AnkMobilDao;
import core.model.AnkMobil;
import core.service.NumberGeneratorSvc;
import core.service.master.AnkMobilSvc;


@Service
@Transactional
public class AnkMobilSvcImpl implements AnkMobilSvc{
	
	@Autowired
	AnkMobilDao ankMobilDao;
	
	@Autowired
	NumberGeneratorSvc numberGeneratorSvc;
	
	@Autowired
	MapperFacade mapperFacade;
	
	Paging page = new Paging();

	@Override
	public void save(AnkMobilDto ankMobilDto) {
		String mobilId = "";
		if(ankMobilDto.getMobilId()==null)
			mobilId = numberGeneratorSvc.getNextNumericNumber(ankMobilDto.getCompanyCode(), "GL02", ankMobilDto.getCreatedBy());
		else
			mobilId = ankMobilDto.getMobilId();
		
		AnkMobil ankMobil = mapperFacade.map(ankMobilDto, AnkMobil.class);
		ankMobil.setMobilId(mobilId);
		ankMobilDao.save(ankMobil);
}

	@Override
	public Map<String, Object> loadList(Map<String, Object> mapInput, String search, int pageSequence, int size, String direction, String orderBy) {
		// TODO Auto-generated method stub
		if(orderBy.isEmpty()){
			orderBy = "merk";
		}
		direction = "asc";
		Page<AnkMobil> datas = ankMobilDao.getDataLloadList(StringUtil.nevl("%"+search+"%", "%%"), page.getPageable(pageSequence, size, direction, orderBy));
		List<AnkMobilDto> dtos = new ArrayList<AnkMobilDto>();
		
		for(AnkMobil o : datas){
			dtos.add(mapperFacade.map(o, AnkMobilDto.class));
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", datas.getTotalElements());
		map.put("contentData", dtos);
		return map;
	}
}
