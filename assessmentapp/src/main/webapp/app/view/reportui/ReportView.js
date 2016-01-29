Ext.define('Assessmentapp.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Assessmentapp.view.reportui.querycriteria.QueryCriteriaView',
			'Assessmentapp.view.reportui.datachart.DataChartViewTab',
			'Assessmentapp.view.reportui.datachart.DataChartViewPanel',
			'Assessmentapp.view.reportui.ReportViewController' ,
			'Assessmentapp.view.fw.MainDataPointPanel',
			'Assessmentapp.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
