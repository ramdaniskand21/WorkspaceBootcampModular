<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %><%@ taglib uri="http://www.zkoss.org/dsp/zk/core" prefix="z" %><%@ taglib uri="http://www.zkoss.org/dsp/web/theme" prefix="t" %>.z-listbox{border:0;overflow:hidden;zoom:1}.z-listbox-header{width:100%;<c:if test="${zk.ie != 8}">background:#fff;</c:if>position:relative;overflow:hidden}.z-listbox-header table{border-spacing:0}.z-listbox-header table th,.z-listbox-header table td{background-clip:padding-box;padding:0}.z-listbox-header table th{text-align:inherit}.z-listbox-header-border{border-bottom:3px solid #d00000;margin-top:-1px;position:relative}.z-listbox-body{position:relative;overflow:hidden}.z-listbox-body table{border-spacing:0}.z-listbox-body table th,.z-listbox-body table td{background-clip:padding-box;padding:0}.z-listbox-body table th{text-align:inherit}.z-listbox-emptybody td{font-family:'Open Sans';font-size:12px;font-weight:normal;font-style:normal;color:#aaa;font-style:italic;text-align:center;height:1px}.z-listbox-footer{border-top:1px solid #cfcfcf;background:#fafafa;overflow:hidden}.z-listbox-footer table{border-spacing:0}.z-listbox-footer table th,.z-listbox-footer table td{background-clip:padding-box;padding:0}.z-listbox-footer table th{text-align:inherit}.z-listbox-odd.z-listitem{background:#f0f0f0}.z-listhead th:first-child{border-left:none}.z-listhead th:first-child.z-listhead-border{border-left:1px solid #cfcfcf}.z-listhead-bar{border-left:1px solid #cfcfcf;border-bottom:1px solid #cfcfcf}.z-listheader{border-left:1px solid #fff;border-bottom:1px solid #cfcfcf;padding:0;<c:if test="${zk.ie != 8}">background:#fff;</c:if>background-clip:padding-box;position:relative;overflow:hidden;white-space:nowrap}.z-listheader-hover{<c:if test="${zk.ie != 8}">background:#fff;</c:if>}.z-listheader-sort .z-listheader-content{cursor:pointer}.z-listheader-sort .z-listheader-sorticon{color:#636363;position:absolute;top:-7px;left:50%}.z-listheader-hover .z-listheader-button{display:block}.z-listheader-checkable{display:inline-block;width:16px;height:16px;border:1px solid #8e8f8f;background:#f8f8f8;vertical-align:text-top}.z-listheader-checkable .z-listheader-icon{display:none;cursor:default}.z-listheader-checkable.z-listheader-checked .z-listheader-icon{color:#2184ba;display:block;padding-left:1px;line-height:14px}.z-listheader-button{color:#636363;display:none;width:23px;height:32px;border-left:1px solid #abd8f9;line-height:32px;text-align:center;position:absolute;top:0;right:0;text-decoration:none;cursor:pointer;z-index:15;${t:boxShadow('inset 1px 0 #FFFFFF')}}.z-listheader-button:hover{<c:if test="${zk.ie != 8}">background:#fff;</c:if>}.z-listheader-sizing,.z-listheader-sizing .z-listheader-button,.z-listheader-sizing.z-listheader-sort .z-listheader-content{cursor:e-resize}.z-listitem{background:#fff}.z-listitem td:first-child{border-left:none}.z-listitem td:last-child{border-right:0}.z-listitem .z-listcell{border-left:none;overflow:hidden;cursor:pointer;vertical-align:top;border-right:1px solid #ddd}.z-listitem:hover>.z-listcell{border-color:#00b1ff;<c:if test="${zk.ie != 8}">background:#00b1ff;</c:if>background-clip:padding-box;position:relative}.z-listitem:hover>.z-listcell>.z-listcell-content{color:#fff}.z-listitem-checkable{display:inline-block;width:16px;height:16px;border:1px solid #8e8f8f;background:#f8f8f8;vertical-align:text-top}.z-listitem-checkable.z-listitem-radio{${t:borderRadius('8px')}}.z-listitem-checkable .z-listitem-icon{display:none;cursor:default}.z-listitem.z-listitem-selected>.z-listcell{border-color:#00b1ff;<c:if test="${zk.ie != 8}">background:#0095d7;</c:if>background-clip:padding-box;position:relative}.z-listitem.z-listitem-selected>.z-listcell>.z-listcell-content{color:#fff}.z-listitem.z-listitem-selected:hover>.z-listcell{border-color:#00b1ff;<c:if test="${zk.ie != 8}">background:#00b1ff;</c:if>position:relative}.z-listitem.z-listitem-selected:hover .z-listcell-content{color:#fff}.z-listitem-selected>.z-listcell>.z-listcell-content>.z-listitem-checkable .z-listitem-icon{color:#2184ba;display:block;padding-left:1px;line-height:14px;cursor:pointer}.z-listitem-selected>.z-listcell>.z-listcell-content>.z-listitem-checkable .z-listitem-icon.z-icon-radio{width:8px;height:8px;${t:borderRadius('4px')};margin:3px;padding:0;background:#2184ba}.z-listitem.z-listitem-disabled *{color:#aaa!important;cursor:default!important}.z-listitem.z-listitem-disabled:hover>.z-listcell{background:0;filter:progid:DXImageTransform.Microsoft.gradient(enabled=false);position:relative}.z-listitem.z-listitem-disabled a,.z-listitem.z-listitem-disabled a:visited,.z-listitem.z-listitem-disabled a:hover{text-decoration:none}.z-listitem a,.z-listitem a:visited,.z-listitem a:hover{text-decoration:none}.z-listgroup-inner{border:1px solid #cfcfcf;border-left:none;border-right:0;<c:if test="${zk.ie != 8}">${t:gradient('ver','#ffffff 0%; #e9f2fb 100%')};</c:if>position:relative;overflow:hidden}.z-listgroup-inner .z-listcell-content,.z-listgroup-inner .z-listgroup-content{padding:3px 5px}.z-listgroup-checkable{display:inline-block;width:16px;height:16px;border:1px solid #8e8f8f;margin-right:2px;background:#f8f8f8;vertical-align:text-top}.z-listgroup-checkable .z-listgroup-icon{display:none;cursor:default}.z-listgroup-selected .z-listgroup-checkable .z-listgroup-icon{font-size:12px;color:#2184ba;display:block;padding-right:2px;line-height:14px;cursor:pointer}.z-listgroup-selected .z-listgroup-checkable .z-listgroup-icon:hover{color:#2184ba}.z-listgroup-icon{font-size:14px;color:#636363;display:inline-block;width:16px;height:16px;line-height:16px;text-align:center;vertical-align:text-top;position:relative;cursor:pointer}.z-listgroup-icon:hover{color:#636363}.z-listgroupfoot-inner{<c:if test="${zk.ie != 8}">${t:gradient('ver','#e9f2fb 0%; #ffffff 100%')};</c:if>overflow:hidden}.z-listheader-content,.z-listcell-content,.z-listgroup-content,.z-listgroupfoot-content,.z-listfooter-content{font-family:'Open Sans';font-size:12px;font-weight:normal;font-style:normal;color:#636363;padding:2px 10px 2px 10px;line-height:24px;overflow:hidden}.z-listheader-content{font-family:'Open Sans';font-size:12px;font-weight:normal;font-style:normal;color:#d00000;font-weight:bold;padding:4px 5px 3px;position:relative;text-align:center}.z-listgroup-content .z-label,.z-listgroupfoot-content .z-label{font-weight:bold}.z-listbox-paging-top{border-bottom:1px solid #cfcfcf;overflow:hidden;width:100%}.z-listbox-paging-bottom{border-top:1px solid #cfcfcf;overflow:hidden;width:100%}.z-listbox-autopaging .z-listcell-content{height:32px;overflow:hidden}.z-listhead-menugrouping .z-menuitem-image{background-image:url(${c:encodeThemeURL('~./zul/img/grid/menu-group.png')})}.z-listhead-menuungrouping .z-menuitem-image{background-image:url(${c:encodeThemeURL('~./zul/img/grid/menu-ungroup.png')})}.z-listhead-menuascending .z-menuitem-image{background-image:url(${c:encodeThemeURL('~./zul/img/grid/menu-arrowup.png')})}.z-listhead-menudescending .z-menuitem-image{background-image:url(${c:encodeThemeURL('~./zul/img/grid/menu-arrowdown.png')})}.z-select{font-family:'Open Sans';font-size:12px}.ie8 .z-listbox-header{background:#f5f5f5}.ie8 .z-listheader{position:static;background:#f5f5f5}.ie8 .z-listheader-hover{background:#e5f7ff}.ie8 .z-listheader-button:hover{background:#d6f2ff}.ie8 .z-listitem:hover>.z-listcell{background:#e5f7ff}.ie8 .z-listitem.z-listitem-selected>.z-listcell{position:static;background:#e5f7ff}.ie8 .z-listitem.z-listitem-selected:hover>.z-listcell{position:static;background:#d9f2ff}.ie8 .z-listheader>.z-listcell>.z-listcell-content>.z-listheader-checkable,.ie8 .z-listheader>.z-listheader-content>.z-listheader-checkable{border-width:0;background:transparent}.ie8 .z-listheader>.z-listcell>.z-listcell-content>.z-listheader-checkable .z-listheader-icon,.ie8 .z-listheader>.z-listheader-content>.z-listheader-checkable .z-listheader-icon{display:block;width:13px;height:13px;background:url(${c:encodeThemeURL('~./zul/img/common/check-sprite.gif')}) no-repeat;position:relative;top:2px;left:2px}.ie8 .z-listheader>.z-listcell>.z-listcell-content>.z-listheader-checkable .z-icon-check,.ie8 .z-listheader>.z-listheader-content>.z-listheader-checkable .z-icon-check{background-position:0 0}.ie8 .z-listheader>.z-listcell>.z-listcell-content>.z-listheader-checkable .z-icon-check:before,.ie8 .z-listheader>.z-listheader-content>.z-listheader-checkable .z-icon-check:before{display:none}.ie8 .z-listgroup>.z-listcell>.z-listcell-content>.z-listgroup-checkable,.ie8 .z-listgroup>.z-listgroup-content>.z-listgroup-checkable{border-width:0;background:transparent}.ie8 .z-listgroup>.z-listcell>.z-listcell-content>.z-listgroup-checkable .z-listgroup-icon,.ie8 .z-listgroup>.z-listgroup-content>.z-listgroup-checkable .z-listgroup-icon{display:block;width:13px;height:13px;background:url(${c:encodeThemeURL('~./zul/img/common/check-sprite.gif')}) no-repeat;position:relative;top:2px;left:2px}.ie8 .z-listgroup>.z-listcell>.z-listcell-content>.z-listgroup-checkable .z-icon-check,.ie8 .z-listgroup>.z-listgroup-content>.z-listgroup-checkable .z-icon-check{background-position:0 0}.ie8 .z-listgroup>.z-listcell>.z-listcell-content>.z-listgroup-checkable .z-icon-check:before,.ie8 .z-listgroup>.z-listgroup-content>.z-listgroup-checkable .z-icon-check:before{display:none}.ie8 .z-listitem>.z-listcell>.z-listcell-content>.z-listitem-checkable,.ie8 .z-listitem>.z-listitem-content>.z-listitem-checkable{border-width:0;background:transparent}.ie8 .z-listitem>.z-listcell>.z-listcell-content>.z-listitem-checkable .z-listitem-icon,.ie8 .z-listitem>.z-listitem-content>.z-listitem-checkable .z-listitem-icon{display:block;width:13px;height:13px;background:url(${c:encodeThemeURL('~./zul/img/common/check-sprite.gif')}) no-repeat;position:relative;top:2px;left:2px}.ie8 .z-listitem>.z-listcell>.z-listcell-content>.z-listitem-checkable .z-icon-check,.ie8 .z-listitem>.z-listitem-content>.z-listitem-checkable .z-icon-check{background-position:0 0}.ie8 .z-listitem>.z-listcell>.z-listcell-content>.z-listitem-checkable .z-icon-check:before,.ie8 .z-listitem>.z-listitem-content>.z-listitem-checkable .z-icon-check:before{display:none}.ie8 .z-listheader>.z-listheader-content>.z-listheader-checkable.z-listheader-checked .z-icon-check,.ie8 .z-listgroup-selected>.z-listcell>.z-listcell-content>.z-listgroup-checkable .z-icon-check,.ie8 .z-listitem-selected>.z-listcell>.z-listcell-content>.z-listitem-checkable .z-icon-check{margin:0;background-position:-26px 0}.ie8 .z-listitem>.z-listcell>.z-listcell-content>.z-listitem-checkable .z-icon-radio{background-position:0 -13px}.ie8 .z-listitem-selected>.z-listcell>.z-listcell-content>.z-listitem-checkable .z-icon-radio{display:block;width:13px;height:13px;margin:0;background-position:-26px -13px}.ie8 .z-listgroup-inner{background:#edf6ff}.ie8 .z-listgroupfoot-inner{background:#f2f9ff}