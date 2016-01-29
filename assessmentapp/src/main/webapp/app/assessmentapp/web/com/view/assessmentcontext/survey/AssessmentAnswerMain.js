Ext.define('Assessmentapp.assessmentapp.web.com.view.assessmentcontext.survey.AssessmentAnswerMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "AssessmentAnswerMainController",
     "restURL": "/AssessmentAnswer",
     "defaults": {
          "split": true
     },
     "requires": ["Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.AssessmentAnswerModel", "Assessmentapp.assessmentapp.web.com.controller.assessmentcontext.survey.AssessmentAnswerMainController", "Assessmentapp.assessmentapp.shared.com.viewmodel.assessmentcontext.survey.AssessmentAnswerViewModel"],
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
               "displayName": "AssessmentAnswer",
               "name": "AssessmentAnswerTreeContainer",
               "itemId": "AssessmentAnswerTreeContainer",
               "restURL": "/AssessmentAnswer",
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
                    "itemId": "AssessmentAnswerTree",
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
                    "viewModel": "AssessmentAnswerViewModel",
                    "xtype": "form",
                    "displayName": "AssessmentAnswer",
                    "title": "AssessmentAnswer",
                    "name": "AssessmentAnswer",
                    "itemId": "AssessmentAnswer",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "answerId",
                         "itemId": "answerId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Answer ID",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Answer ID<font color='red'> *<\/font>",
                         "fieldId": "8ACBD648-6F3A-483C-84E2-4C87DBCFB012",
                         "hidden": true,
                         "value": "",
                         "bindable": "answerId",
                         "bind": "{answerId}"
                    }, {
                         "name": "answer",
                         "itemId": "answer",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Answer",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Answer<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "AE5852CB-E884-4FB1-8F2A-648988B0837D",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "answer",
                         "bind": "{answer}",
                         "columnWidth": 0.5
                    }, {
                         "name": "answerDesc",
                         "itemId": "answerDesc",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Answer Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Answer Description",
                         "fieldId": "3E92D1D7-7EDC-4067-BEC2-11E4F49748C0",
                         "bindable": "answerDesc",
                         "bind": "{answerDesc}",
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
                         "fieldId": "1DE2955A-297E-41F2-9191-5797ADC2D6F1",
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
                         "customId": 648,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 648,
                              "customId": 678
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 648,
                              "customId": 679,
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
                              "parentId": 648,
                              "customId": 680,
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
                    "displayName": "AssessmentAnswer",
                    "title": "Details Grid",
                    "name": "AssessmentAnswerGrid",
                    "itemId": "AssessmentAnswerGrid",
                    "restURL": "/AssessmentAnswer",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Answer ID",
                         "dataIndex": "answerId",
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
                         "header": "Answer",
                         "dataIndex": "answer",
                         "flex": 1
                    }, {
                         "header": "Answer Description",
                         "dataIndex": "answerDesc",
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
               "viewModel": "AssessmentAnswerViewModel",
               "xtype": "form",
               "displayName": "AssessmentAnswer",
               "title": "AssessmentAnswer",
               "name": "AssessmentAnswer",
               "itemId": "AssessmentAnswer",
               "bodyPadding": 10,
               "items": [{
                    "name": "answerId",
                    "itemId": "answerId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Answer ID",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Answer ID<font color='red'> *<\/font>",
                    "fieldId": "8ACBD648-6F3A-483C-84E2-4C87DBCFB012",
                    "hidden": true,
                    "value": "",
                    "bindable": "answerId",
                    "bind": "{answerId}"
               }, {
                    "name": "answer",
                    "itemId": "answer",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Answer",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Answer<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "AE5852CB-E884-4FB1-8F2A-648988B0837D",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "answer",
                    "bind": "{answer}",
                    "columnWidth": 0.5
               }, {
                    "name": "answerDesc",
                    "itemId": "answerDesc",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Answer Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Answer Description",
                    "fieldId": "3E92D1D7-7EDC-4067-BEC2-11E4F49748C0",
                    "bindable": "answerDesc",
                    "bind": "{answerDesc}",
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
                    "fieldId": "1DE2955A-297E-41F2-9191-5797ADC2D6F1",
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
                    "customId": 648,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 648,
                         "customId": 678
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 648,
                         "customId": 679,
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
                         "parentId": 648,
                         "customId": 680,
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