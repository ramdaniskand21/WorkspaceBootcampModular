package core.service.master;

import java.util.Map;

import share.AnkSupirDto;

public interface AnkSupirSvc {
	public abstract void save(AnkSupirDto ankSupirDto);
	public abstract Map<String, Object> loadList(Map<String, Object> mapInput, String search, int pageSequence, int size, String direction, String orderBy);

}
