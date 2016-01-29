Ext.define('Assessmentapp.view.resource.AppMenuTreePanel', {
	extend : 'Ext.tree.Panel',
    xtype: 'appMenuTreePanel',
    
    requires: ['Assessmentapp.view.resource.AppMenuTreePanelController'],    
    controller: 'appMenuTreePanelController',
    
    rootVisible:false,
    useArrows:true,
    lines  : false,
//    autoScroll:true,
    
	listeners: {
         itemclick : function( currentObject, record, item, index, e, eOpts){
        	 this.getController().renderFormPanel(currentObject, record, item, index, e, eOpts);
         }
   	}     
    	
});
