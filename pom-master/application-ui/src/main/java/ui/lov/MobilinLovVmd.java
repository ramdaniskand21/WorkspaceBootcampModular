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
import common.model.RestResponse;
import common.ui.BaseLovVmd;
import common.util.CommonConstants;
import common.util.JsonUtil;

public class MobilinLovVmd extends BaseLovVmd implements Serializable{
	private static final long serialVersionUID = 1L;
	private final String WS_URI = "/AnkSewa/lov/MobilinLov";
	private ListModelList<AnkMobilDto> ankMobilDtos = new ListModelList<>();
	private AnkMobilDto ankMobilDto;
	private Set<Integer> list = new HashSet<>();
	private Map<String, Object> mapInput = null;
	
	public ListModelList<AnkMobilDto> getAnkMobilDtos() {
		return ankMobilDtos;
	}
	public void setAnkMobilDtos(ListModelList<AnkMobilDto> ankMobilDtos) {
		this.ankMobilDtos = ankMobilDtos;
	}
	public AnkMobilDto getAnkMobilDto() {
		return ankMobilDto;
	}
	public void setAnkMobilDto(AnkMobilDto ankMobilDto) {
		this.ankMobilDto = ankMobilDto;
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
			ankMobilDtos.clear();
			setTotalSize(restResponse.getTotalRecords());
			if(restResponse.getContents()!=null){
				try{
					ankMobilDtos.addAll(JsonUtil.mapJsonToListObject(restResponse.getContents(), AnkMobilDto.class ));
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	@Command("choose")
	public void chooseDate(){
		Map<String, Object> args = new HashMap<>();
		args.put("ankMobil", ankMobilDto);
		returnValue(args);
	}


}
