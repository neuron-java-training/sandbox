package hu.neuron.java.web.controllers.admin;

import hu.neuron.java.service.facade.UserFacadeLocal;
import hu.neuron.java.service.vo.UserVO;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyUserModel extends LazyDataModel<UserVO> {

	private static final long serialVersionUID = 1L;

	private UserFacadeLocal userService = null;
	private List<UserVO> visibleUserList;

	public LazyUserModel(UserFacadeLocal userService) {
		this.userService = userService;

	}

	@Override
	public UserVO getRowData(String rowkey) {
		if (visibleUserList != null || rowkey != null) {
			for (UserVO user : visibleUserList) {
				if (user.getId().toString().equals(rowkey)) {
					return user;
				}
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(UserVO user) {
		if (user == null) {
			return null;
		}
		return user.getId();
	}

	@Override
	public List<UserVO> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		String filter = "";
		String filterColumnName = "";
		if (filters.keySet().size() > 0) {
			filter = (String) filters.values().toArray()[0];
			filterColumnName = filters.keySet().iterator().next();
		}
		if (sortField == null) {
			sortField = "userName";
		}

		int dir = sortOrder.equals(SortOrder.ASCENDING) ? 1 : 2;
		visibleUserList = userService.getUserList(first / pageSize, pageSize,
				sortField, dir, filter, filterColumnName);
		int dataSize = userService.getRowNumber();
		this.setRowCount(dataSize);

		return visibleUserList;
	}

	public List<UserVO> getVisibleUserList() {
		return visibleUserList;
	}

	public void setVisibleUserList(List<UserVO> visibleUserList) {
		this.visibleUserList = visibleUserList;
	}

}
