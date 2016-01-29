Ext.define('Assessmentapp.assessmentapp.web.com.view.assessmentcontext.survey.AssessmentsMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "AssessmentsMainController",
     "restURL": "/Assessments",
     "defaults": {
          "split": true
     },
     "requires": ["Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.AssessmentsModel", "Assessmentapp.assessmentapp.web.com.controller.assessmentcontext.survey.AssessmentsMainController", "Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.AssessmentQuestionModel", "Assessmentapp.assessmentapp.shared.com.viewmodel.assessmentcontext.survey.AssessmentsViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Assessments",
               "name": "AssessmentsTreeContainer",
               "itemId": "AssessmentsTreeContainer",
               "restURL": "/Assessments",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "AssessmentsTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "AssessmentsViewModel",
                    "xtype": "form",
                    "displayName": "Assessments",
                    "title": "Assessments",
                    "name": "Assessments",
                    "itemId": "Assessments",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "assessmentId",
                         "itemId": "assessmentId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Assessment ID",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Assessment ID<font color='red'> *<\/font>",
                         "fieldId": "883F1E35-A4D4-42C0-893F-D67AFE70C0E2",
                         "hidden": true,
                         "value": "",
                         "bindable": "assessmentId",
                         "bind": "{assessmentId}"
                    }, {
                         "name": "assessmentName",
                         "itemId": "assessmentName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Assessment",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Assessment<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "35C3D990-22D7-413A-A87E-B8B922246F15",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "assessmentName",
                         "bind": "{assessmentName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "duration",
                         "itemId": "duration",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Duration(In Minutes.)",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Duration(In Minutes.)<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "12481854-6424-483E-A280-EA34367AB522",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "duration",
                         "bind": "{duration}",
                         "columnWidth": 0.5
                    }, {
                         "name": "firstQuestionId",
                         "itemId": "firstQuestionId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Assessment First Question",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Assessment First Question<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B02CA0E8-9CFF-42B0-82CC-CEABCB92DF4E",
                         "restURL": "AssessmentQuestion",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.AssessmentQuestionModel"
                         },
                         "bindable": "firstQuestionId",
                         "bind": "{firstQuestionId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "5B64CFAF-7887-4062-8A82-090451F59B37",
                         "bindable": "versionId",
                         "bind": "{versionId}",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 956,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 956,
                              "customId": 841
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 956,
                              "customId": 842,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 956,
                              "customId": 843,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Assessments",
                    "title": "Details Grid",
                    "name": "AssessmentsGrid",
                    "itemId": "AssessmentsGrid",
                    "restURL": "/Assessments",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Assessment ID",
                         "dataIndex": "assessmentId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Assessment",
                         "dataIndex": "assessmentName",
                         "flex": 1
                    }, {
                         "header": "Duration(In Minutes.)",
                         "dataIndex": "duration",
                         "flex": 1
                    }, {
                         "header": "Assessment First Question",
                         "dataIndex": "firstQuestionId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "AssessmentsViewModel",
               "xtype": "form",
               "displayName": "Assessments",
               "title": "Assessments",
               "name": "Assessments",
               "itemId": "Assessments",
               "bodyPadding": 10,
               "items": [{
                    "name": "assessmentId",
                    "itemId": "assessmentId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Assessment ID",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Assessment ID<font color='red'> *<\/font>",
                    "fieldId": "883F1E35-A4D4-42C0-893F-D67AFE70C0E2",
                    "hidden": true,
                    "value": "",
                    "bindable": "assessmentId",
                    "bind": "{assessmentId}"
               }, {
                    "name": "assessmentName",
                    "itemId": "assessmentName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Assessment",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Assessment<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "35C3D990-22D7-413A-A87E-B8B922246F15",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "assessmentName",
                    "bind": "{assessmentName}",
                    "columnWidth": 0.5
               }, {
                    "name": "duration",
                    "itemId": "duration",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Duration(In Minutes.)",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Duration(In Minutes.)<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "12481854-6424-483E-A280-EA34367AB522",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "duration",
                    "bind": "{duration}",
                    "columnWidth": 0.5
               }, {
                    "name": "firstQuestionId",
                    "itemId": "firstQuestionId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Assessment First Question",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Assessment First Question<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B02CA0E8-9CFF-42B0-82CC-CEABCB92DF4E",
                    "restURL": "AssessmentQuestion",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.AssessmentQuestionModel"
                    },
                    "bindable": "firstQuestionId",
                    "bind": "{firstQuestionId}",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "5B64CFAF-7887-4062-8A82-090451F59B37",
                    "bindable": "versionId",
                    "bind": "{versionId}",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 956,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 956,
                         "customId": 841
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 956,
                         "customId": 842,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 956,
                         "customId": 843,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});