package core.service.master;

import java.util.Map;

import share.AnkMobilDto;

public interface AnkMobilSvc {
	public abstract void save(AnkMobilDto ankMobilDto);
	public abstract Map<String, Object> loadList(Map<String, Object> mapInput, String search, int pageSequence, int size, String direction, String orderBy);


}
