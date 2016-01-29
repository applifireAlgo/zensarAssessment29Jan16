Ext.define('Assessmentapp.assessmentapp.web.com.view.assessmentcontext.survey.AssessmentStatusMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "AssessmentStatusMainController",
     "restURL": "/AssessmentStatus",
     "defaults": {
          "split": true
     },
     "requires": ["Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.AssessmentStatusModel", "Assessmentapp.assessmentapp.web.com.controller.assessmentcontext.survey.AssessmentStatusMainController", "Assessmentapp.assessmentapp.shared.com.viewmodel.assessmentcontext.survey.AssessmentStatusViewModel"],
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
               "displayName": "AssessmentStatus",
               "name": "AssessmentStatusTreeContainer",
               "itemId": "AssessmentStatusTreeContainer",
               "restURL": "/AssessmentStatus",
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
                    "itemId": "AssessmentStatusTree",
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
                    "viewModel": "AssessmentStatusViewModel",
                    "xtype": "form",
                    "displayName": "AssessmentStatus",
                    "title": "AssessmentStatus",
                    "name": "AssessmentStatus",
                    "itemId": "AssessmentStatus",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "assessmentStatusId",
                         "itemId": "assessmentStatusId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Assessment Status ID",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Assessment Status ID<font color='red'> *<\/font>",
                         "fieldId": "F027324C-091B-45DA-8324-5FEA8CD8B4E1",
                         "hidden": true,
                         "value": "",
                         "bindable": "assessmentStatusId",
                         "bind": "{assessmentStatusId}"
                    }, {
                         "name": "statusCode",
                         "itemId": "statusCode",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Status Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Status Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "9BCDDA9C-CCD7-4637-AC1C-3C42E80E8C8D",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "statusCode",
                         "bind": "{statusCode}",
                         "columnWidth": 0.5
                    }, {
                         "name": "statusText",
                         "itemId": "statusText",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Status",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Status<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "0CA2A26C-FAEF-416F-B698-32A62C1D4BE4",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "statusText",
                         "bind": "{statusText}",
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
                         "fieldId": "20E0FE1A-7925-40C5-A418-7EE5EBD9BB46",
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
                         "customId": 400,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 400,
                              "customId": 826
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 400,
                              "customId": 827,
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
                              "parentId": 400,
                              "customId": 828,
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
                    "displayName": "AssessmentStatus",
                    "title": "Details Grid",
                    "name": "AssessmentStatusGrid",
                    "itemId": "AssessmentStatusGrid",
                    "restURL": "/AssessmentStatus",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Assessment Status ID",
                         "dataIndex": "assessmentStatusId",
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
                         "header": "Status Code",
                         "dataIndex": "statusCode",
                         "flex": 1
                    }, {
                         "header": "Status",
                         "dataIndex": "statusText",
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
               "viewModel": "AssessmentStatusViewModel",
               "xtype": "form",
               "displayName": "AssessmentStatus",
               "title": "AssessmentStatus",
               "name": "AssessmentStatus",
               "itemId": "AssessmentStatus",
               "bodyPadding": 10,
               "items": [{
                    "name": "assessmentStatusId",
                    "itemId": "assessmentStatusId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Assessment Status ID",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Assessment Status ID<font color='red'> *<\/font>",
                    "fieldId": "F027324C-091B-45DA-8324-5FEA8CD8B4E1",
                    "hidden": true,
                    "value": "",
                    "bindable": "assessmentStatusId",
                    "bind": "{assessmentStatusId}"
               }, {
                    "name": "statusCode",
                    "itemId": "statusCode",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Status Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Status Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "9BCDDA9C-CCD7-4637-AC1C-3C42E80E8C8D",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "statusCode",
                    "bind": "{statusCode}",
                    "columnWidth": 0.5
               }, {
                    "name": "statusText",
                    "itemId": "statusText",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Status",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Status<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "0CA2A26C-FAEF-416F-B698-32A62C1D4BE4",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "statusText",
                    "bind": "{statusText}",
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
                    "fieldId": "20E0FE1A-7925-40C5-A418-7EE5EBD9BB46",
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
                    "customId": 400,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 400,
                         "customId": 826
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 400,
                         "customId": 827,
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
                         "parentId": 400,
                         "customId": 828,
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