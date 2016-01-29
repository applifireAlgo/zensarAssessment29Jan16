Ext.define('Assessmentapp.view.mobileview.resource.AppMenuTreePanel', {
	extend : 'Ext.tree.Panel',
    xtype: 'appMenuTreePanel',
    itemId: 'appMenuTreePanel',
    
    requires: ['Assessmentapp.view.mobileview.resource.AppMenuTreePanelController'],
    
    controller: 'appMenuTreePanelController',
    rootVisible:false,
    autoScroll:true,
    useArrows:true,
    rowLines:true,//mbadd
    columnLines:false,//mbadd
   // width:'100%',//mbremove
   // autoScroll:true,
   // latout:'fit',//mbremove
	listeners: {
         itemclick : function( tree, record, item, index, e, eOpts){
        	 
        	 this.getController().renderFormPanel(tree, record, item, index, e, eOpts);
         }
   	}    
   
    	
});
