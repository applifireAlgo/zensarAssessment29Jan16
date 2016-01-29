Ext.define('Assessmentapp.view.databrowsercalendar.DBCalendar', {
	extend : 'Assessmentapp.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Assessmentapp.view.databrowsercalendar.DBCalendarController',
	             'Assessmentapp.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
