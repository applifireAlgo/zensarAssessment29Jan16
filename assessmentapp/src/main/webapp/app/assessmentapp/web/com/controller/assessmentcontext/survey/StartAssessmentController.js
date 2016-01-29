Ext.define('Assessmentapp.assessmentapp.web.com.controller.assessmentcontext.survey.StartAssessmentController', {
     extend: 'Assessmentapp.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.StartAssessmentController',
     onsubmitStartAssessmentclick: function(me, e, eOpts) {
          var jsonData = this.getData(me.up('form'));
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/StartAssessmentServiceWS/startAssessment',
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         Ext.Msg.alert('Server Response', responseText.response.message);
                         scope.sender.reset();
                         var formComponent = new Ext.create('Assessmentapp.assessmentapp.web.com.view.assessmentcontext.survey.AssessmentQuestionarie');
                         formComponent.title = 'AssessmentQuestionarie';
                         formComponent.closable = true;
                         var tabs = Ext.getCmp('appMainTabPanel');
                         tabs.remove(scope.sender);
                         tabs.add(formComponent);
                         tabs.setActiveTab(formComponent);
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