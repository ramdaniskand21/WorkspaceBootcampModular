package ui.lov;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpMethod;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.ListModelList;

import share.AnkMobilDto;
import share.AnkSupirDto;
import common.model.RestResponse;
import common.ui.BaseLovVmd;
import common.util.CommonConstants;
import common.util.JsonUtil;

public class SupirinLovVmd extends BaseLovVmd implements Serializable{
	private final String WS_URI = "/AnkSewa/lov/SupirinLov";
	private ListModelList<AnkSupirDto> ankSupirDtos = new ListModelList<>();
	private AnkSupirDto ankSupirDto;
	private Set<Integer> list = new HashSet<>();
	public ListModelList<AnkSupirDto> getAnkSupirDtos() {
		return ankSupirDtos;
	}
	public void setAnkSupirDtos(ListModelList<AnkSupirDto> ankSupirDtos) {
		this.ankSupirDtos = ankSupirDtos;
	}
	public AnkSupirDto getAnkSupirDto() {
		return ankSupirDto;
	}
	public void setAnkSupirDto(AnkSupirDto ankSupirDto) {
		this.ankSupirDto = ankSupirDto;
	}
	public Set<Integer> getList() {
		return list;
	}
	public void setList(Set<Integer> list) {
		this.list = list;
	}
	public Map<String, Object> getMapInput() {
		return mapInput;
	}
	public void setMapInput(Map<String, Object> mapInput) {
		this.mapInput = mapInput;
	}
	private Map<String, Object> mapInput = null;

	@Init(superclass=true)
	public void init(@ExecutionArgParam("listNotin") Set<Integer> listNotIn,
			@ExecutionArgParam("mapInput")HashMap<String, Object> mapInput){
		if(listNotIn==null){
			setList(new HashSet<Integer>());
		}else {
			setList(listNotIn);
		}
		if(mapInput!=null)
			setMapInput(mapInput);
		loadList();
	}
	
	@Override
	protected void loadList(){
		RestResponse restResponse = callWsWithPaging(WS_URI, new HashMap<String, Object>(), HttpMethod.POST);
		if(restResponse.getStatus()== CommonConstants.OK_REST_STATUS){
			ankSupirDtos.clear();
			setTotalSize(restResponse.getTotalRecords());
			if(restResponse.getContents()!=null){
				try{
					ankSupirDtos.addAll(JsonUtil.mapJsonToListObject(restResponse.getContents(), AnkSupirDto.class ));
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	@Command("choose")
	public void chooseDate(){
		Map<String, Object> args = new HashMap<>();
		args.put("ankSupir", ankSupirDto);
		returnValue(args);
	}
}