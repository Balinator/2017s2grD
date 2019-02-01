package edu.msg.ro.bean;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.msg.ro.business.bug.boundary.HistoryFacade;
import edu.msg.ro.business.bug.dto.HistoryDTO;

@ManagedBean
@ViewScoped
public class HistoryBean {

	private static final int LENGTH = 35;

	@EJB
	private HistoryFacade historyFacade;

	private HistoryDTO history = new HistoryDTO();

	private List<HistoryDTO> allHistoryFiltered;

	private List<HistoryDTO> allHistory;

	@PostConstruct
	public void init() {
		allHistory = historyFacade.getAllHistory();
		allHistoryFiltered = allHistory;
	}

	public List<HistoryDTO> getAllHistory() {
		return allHistory;
	}

	public String getValue(String value) {
		return value.length() > LENGTH ? value.substring(0, LENGTH) + "..." : value;
	}

	public void setSelected(HistoryDTO history) {
		this.setHistory(history);
	}

	public HistoryDTO getHistory() {
		return history;
	}

	public void setHistory(HistoryDTO history) {
		this.history = history;
	}

	public List<HistoryDTO> getAllHistoryFiltered() {
		return allHistoryFiltered;
	}

	public void setAllHistoryFiltered(List<HistoryDTO> allHistoryFiltered) {
		this.allHistoryFiltered = allHistoryFiltered;
	}

	public boolean dateFilter(Object value, Object filter, Locale locale) {
		if (filter == null) {
			return true;
		}
		if (value == null) {
			return false;
		}

		Date d1 = (Date) filter;
		Date d2 = (Date) value;

		return d1.getYear() == d2.getYear() && d1.getMonth() == d2.getMonth() && d1.getDay() == d2.getDay();
	}

}
