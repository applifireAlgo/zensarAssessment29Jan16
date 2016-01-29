Ext.define('Assessmentapp.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Assessmentapp.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Assessmentapp.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
