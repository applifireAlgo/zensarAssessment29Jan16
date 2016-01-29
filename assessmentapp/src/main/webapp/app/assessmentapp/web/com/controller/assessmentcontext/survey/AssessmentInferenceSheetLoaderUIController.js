Ext.define('Assessmentapp.assessmentapp.web.com.controller.assessmentcontext.survey.AssessmentInferenceSheetLoaderUIController', {
     extend: 'Assessmentapp.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.AssessmentInferenceSheetLoaderUIController',
     onbuttonclick: function(me, e, eOpts) {
          var jsonData = {};
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/AssessmentInferenceSheetLoaderWS/loadAssessmentInferenceFromSheet',
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         Ext.Msg.alert('Server Response', responseText.response.message);
                    } else {
                         Ext.Msg.alert('Server Response', responseText.response.message);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseText.response.message);
               }
          }, scope);
     }
});