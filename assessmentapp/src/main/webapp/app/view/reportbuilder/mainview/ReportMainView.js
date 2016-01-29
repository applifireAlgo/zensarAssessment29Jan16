Ext.define('Assessmentapp.view.reportbuilder.mainview.ReportMainView', {
	extend : 'Ext.panel.Panel',
    requires:[
             'Assessmentapp.view.reportbuilder.reportlist.ReportListPanelView',
             'Assessmentapp.view.reportbuilder.reportBuilder.ReportBuilderView',
             'Assessmentapp.view.reportbuilder.mainview.ReportMainController'
             ],
    xtype: 'apps-reportview',
    itemId:'mainReportBuilderView',
    controller: 'reportMainController',
    layout: {
        type: 'border'
    },
    items:[
           	{
           		xtype:'reports-left-panel',
           		region:'west',
    		},
    		{ 
    			region : 'center',
    			xtype:'tabpanel', 		//No Ext.define Page is created for this tabpanel
    			itemId:'reportsTabPanel',
    			// Add default tab with view
    			items:[
    			       {
    			    	   title:'New Report',
    			    	   closable:true,
    			    	   xtype :'report-builder-panel',
    			    	   iconCls:'newTabIcon',
    			    	   reportName:'New Report',
    			    	   synopsis:'',
    			    	   help:'',
    			    	   displayType:0,
    			    	   queryId:'',
    			    	   jpqlQuery:'',
    			    	   queryJson:''
    			    	   
    			       }
    			],
    			bodyStyle:'background-image:url("resources/square.gif");',
    		}
    	]
});
