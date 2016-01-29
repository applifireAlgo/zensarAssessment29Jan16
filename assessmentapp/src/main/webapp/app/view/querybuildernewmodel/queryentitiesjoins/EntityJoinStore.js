Ext.define('Assessmentapp.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Assessmentapp.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Assessmentapp.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
