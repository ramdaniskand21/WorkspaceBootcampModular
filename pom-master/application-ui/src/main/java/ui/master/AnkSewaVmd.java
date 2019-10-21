package ui.master;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.Form;
import org.zkoss.bind.SimpleForm;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;

import share.AnkMobilDto;
import share.AnkSewaDto;
import share.AnkSupirDto;
import common.model.RestResponse;
import common.ui.BaseVmd;
import common.ui.UIConstants;
import common.util.CommonConstants;
import common.util.JsonUtil;

@Init(superclass = true)
public class AnkSewaVmd extends BaseVmd implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private final String INDEX_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/AnkSewa/_index.zul";
	private final String DETAIL_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/AnkSewa/_detail.zul";
	private final String WS_URI = "/AnkSewa";

	List<AnkSewaDto> ankSewaDtos = new ArrayList<AnkSewaDto>();
	
	
	private AnkSewaDto ankSewaDto = new AnkSewaDto();
	private AnkMobilDto ankMobilDto = new AnkMobilDto();
	private AnkSupirDto ankSupirDto = new AnkSupirDto();
	private AnkSewaDto ankSewaDtoSelected = new AnkSewaDto();
	private Form formMaster = new SimpleForm();
	
	

	public AnkMobilDto getAnkMobilDto() {
		return ankMobilDto;
	}
	public void setAnkMobilDto(AnkMobilDto ankMobilDto) {
		this.ankMobilDto = ankMobilDto;
	}
	public AnkSupirDto getAnkSupirDto() {
		return ankSupirDto;
	}
	public void setAnkSupirDto(AnkSupirDto ankSupirDto) {
		this.ankSupirDto = ankSupirDto;
	}
	public List<AnkSewaDto> getAnkSewaDtos() {
		return ankSewaDtos;
	}
	public void setAnkSewaDtos(List<AnkSewaDto> ankSewaDtos) {
		this.ankSewaDtos = ankSewaDtos;
	}

	
	public AnkSewaDto getAnkSewaDto() {
		return ankSewaDto;
	}
	public void setAnkSewaDto(AnkSewaDto ankSewaDto) {
		this.ankSewaDto = ankSewaDto;
	}
	public AnkSewaDto getAnkSewaDtoSelected() {
		return ankSewaDtoSelected;
	}
	public void setAnkSewaDtoSelected(AnkSewaDto ankSewaDtoSelected) {
		this.ankSewaDtoSelected = ankSewaDtoSelected;
	}

	
	@Override
	protected void loadList(){
		RestResponse rest = callWsWithPaging(WS_URI+"/all/paging", new HashMap<String, Object>(), HttpMethod.POST);
		try {
			ankSewaDtos = JsonUtil.mapJsonToListObject(rest.getContents(), AnkSewaDto.class);
			setTotalSize(rest.getTotalRecords());
			BindUtils.postNotifyChange(null, null, this, "ankSewaDtos");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GlobalCommand("ankMobilHandler")
	public void ankMobilHandler(
			@BindingParam("ankMobil") AnkMobilDto dto){
		formMaster.setField("mobilId", dto.getMobilId());
		BindUtils.postNotifyChange(null, null, formMaster, "mobilId");
	}
	
	@GlobalCommand("ankSupirHandler")
	public void ankSupirHandler(
			@BindingParam("ankSupir") AnkSupirDto dto){
		formMaster.setField("supirId", dto.getSupirId());
		BindUtils.postNotifyChange(null, null, formMaster, "supirId");
	}
			
	@Command("refresh")
	public void refresh() {
		navigate("");
		getPageInfo().setListMode(true);
		navigate(INDEX_PAGE_PATH);
	}
	
	@Command
	public void add(){
		getPageInfo().setAddMode(true);
		navigate(DETAIL_PAGE_PATH);
	}
	
	@Command
	public void edit(){
		if(ankSewaDtoSelected == null || ankSewaDtoSelected.getSewaId()==null){
			showSmartMsgBox("W001");
			return;
		}
		
		Executions.getCurrent().setAttribute("obj", ankSewaDtoSelected);
		getPageInfo().setEditMode(true);
		navigate(DETAIL_PAGE_PATH);
	}
	
	@Override
	public void onEdit(){
		ankSewaDto = (AnkSewaDto) Executions.getCurrent().getAttribute("obj");
		BindUtils.postNotifyChange(null, null, this, "ankSewaDto");
	}
	
	@Command
	public void view(){
		if(ankSewaDtoSelected == null || ankSewaDtoSelected.getSewaId()==null){
			showSmartMsgBox("W001");
			return;
		}
		Executions.getCurrent().setAttribute("obj", ankSewaDtoSelected);
		getPageInfo().setViewMode(true);
		navigate(DETAIL_PAGE_PATH);
	}
	
	@Override
	public void onView(){
		ankSewaDto = (AnkSewaDto) Executions.getCurrent().getAttribute("obj");
		onEdit();
	}
	
	@Command
	public void save(){
		System.out.println("Nama : " + ankSewaDto.getSewaNama());
		System.out.println("Alamat : " + ankSewaDto.getSewaAlamat());
			System.out.println("Tanggal Sewa : " + ankSewaDto.getTglSewa());
			System.out.println("Tanggal Akhir : " + ankSewaDto.getTglAkhir());
			System.out.println("Mobil Id : " + ankSewaDto.getMobilId());
		ankSewaDto.setCompanyCode(getCurrentUserSession().getCompanyCode());
		if(getPageInfo().isAddMode()){
			ankSewaDto.setCreatedBy(getCurrentUserSession().getUserId());
			ankSewaDto.setCreatedDate(new Date());
		}else{
			ankSewaDto.setUpdateBy(getCurrentUserSession().getUserId());
			ankSewaDto.setUpdataDate(new Date());
		}
		RestResponse rest = callCustomWs(WS_URI, ankSewaDto, HttpMethod.POST);
		
		if(rest.getStatus()==CommonConstants.OK_REST_STATUS){
			showSmartMsgBox(rest.getMessage());
			back();
		}else{
			showSmartMsgBox(rest.getMessage());
		}
		
	}
	
	@Command
	public void back(){
		getPageInfo().setListMode(true);
		navigate(INDEX_PAGE_PATH);
	}
	public Form getFormMaster() {
		return formMaster;
	}
	public void setFormMaster(Form formMaster) {
		this.formMaster = formMaster;
	}

}
