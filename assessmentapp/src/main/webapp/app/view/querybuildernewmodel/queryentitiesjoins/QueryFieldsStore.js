Ext.define('Assessmentapp.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Assessmentapp.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Assessmentapp.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
