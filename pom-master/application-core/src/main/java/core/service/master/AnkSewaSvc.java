package core.service.master;

import java.util.Map;

import share.AnkSewaDto;

public interface AnkSewaSvc {
	public abstract void save(AnkSewaDto ankSewaDto);
	public abstract Map<String, Object> loadList(Map<String, Object> mapInput, String search, int pageSequence, int size, String direction, String orderBy);

}
