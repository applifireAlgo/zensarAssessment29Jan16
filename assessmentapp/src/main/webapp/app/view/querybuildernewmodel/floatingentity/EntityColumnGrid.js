Ext.define('Assessmentapp.view.querybuildernewmodel.floatingentity.EntityColumnGrid', {
    extend: 'Ext.grid.Panel',
    requires:['Assessmentapp.view.querybuildernewmodel.floatingentity.EntityColumnGridController',
              'Assessmentapp.view.querybuildernewmodel.floatingentity.EntitySprite',
              'Ext.grid.*',
              'Ext.data.*', 'Ext.view.*',
              'Ext.dd.*','Ext.selection.CheckboxModel'],
    xtype:'entity-column-grid',
    controller:'entity-column-grid',
    border: 0,
  	width:200,
  	shrinkWrap:3,
  	shadowSprite:null,
  	title:'',
  	rowLines:false,
  	selModel:null,
    showHeaderCheckbox :true,
    columnHeaderCheckbox :true,
  	viewConfig: {
         listeners: {
        	 afterrender:'onRender',
        	 beforeDrop:'onBeforeDrop',
        	 drop:'onDrop'
        }
  	 }
 
});