package edu.msg.ro.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.PieChartModel;

import edu.msg.ro.business.bug.boundary.BugFacade;
import edu.msg.ro.business.bug.enums.BugSeverity;
import edu.msg.ro.business.bug.enums.StatusEnum;
import edu.msg.ro.business.user.boundary.UserFacade;
import edu.msg.ro.i18n.Translator;

@ManagedBean
@RequestScoped
public class ChartBean {

	@EJB
	private Translator translator;

	@EJB
	private UserFacade userFacade;

	@EJB
	private BugFacade bugFacade;

	public PieChartModel getUser1() {
		PieChartModel pieModel = new PieChartModel();

		pieModel.set(translator.translate("chart.user1.option1"), userFacade.getStatisticsUser1Option1());
		pieModel.set(translator.translate("chart.user1.option2"), userFacade.getStatisticsUser1Option2());

		pieModel.setTitle(translator.translate("chart.user1.title"));
		pieModel.setLegendPosition("w");

		return pieModel;
	}

	public PieChartModel getBug1() {
		PieChartModel pieModel = new PieChartModel();

		pieModel.set(translator.translate("bug.status.OPEN"), bugFacade.getStatisticsBug1Option(StatusEnum.OPEN));
		pieModel.set(translator.translate("bug.status.INPROGRESS"),
				bugFacade.getStatisticsBug1Option(StatusEnum.INPROGRESS));
		pieModel.set(translator.translate("bug.status.INFONEEDED"),
				bugFacade.getStatisticsBug1Option(StatusEnum.INFONEEDED));
		pieModel.set(translator.translate("bug.status.FIXED"), bugFacade.getStatisticsBug1Option(StatusEnum.FIXED));
		pieModel.set(translator.translate("bug.status.REJECTED"),
				bugFacade.getStatisticsBug1Option(StatusEnum.REJECTED));
		pieModel.set(translator.translate("bug.status.CLOSE"), bugFacade.getStatisticsBug1Option(StatusEnum.CLOSE));

		pieModel.setTitle(translator.translate("chart.bug1.title"));
		pieModel.setLegendPosition("w");

		return pieModel;
	}

	public PieChartModel getbug2() {
		PieChartModel pieModel = new PieChartModel();

		pieModel.set(translator.translate("bug.severity.CRITICAL"),
				bugFacade.getStatisticsBug2Option(BugSeverity.CRITICAL));
		pieModel.set(translator.translate("bug.severity.HIGH"), bugFacade.getStatisticsBug2Option(BugSeverity.HIGH));
		pieModel.set(translator.translate("bug.severity.MEDIUM"),
				bugFacade.getStatisticsBug2Option(BugSeverity.MEDIUM));
		pieModel.set(translator.translate("bug.severity.LOW"), bugFacade.getStatisticsBug2Option(BugSeverity.LOW));

		pieModel.setTitle(translator.translate("chart.bug2.title"));
		pieModel.setLegendPosition("w");

		return pieModel;
	}
}
