Ext.define('Assessmentapp.assessmentapp.web.com.view.organizationboundedcontext.location.RegionMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "RegionMainController",
     "restURL": "/Region",
     "defaults": {
          "split": true
     },
     "requires": ["Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.RegionModel", "Assessmentapp.assessmentapp.web.com.controller.organizationboundedcontext.location.RegionMainController", "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.CountryModel", "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.StateModel", "Assessmentapp.assessmentapp.shared.com.viewmodel.organizationboundedcontext.location.RegionViewModel"],
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
               "displayName": "Region",
               "name": "RegionTreeContainer",
               "itemId": "RegionTreeContainer",
               "restURL": "/Region",
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
                    "itemId": "RegionTree",
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
                    "items": [{
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country",
                         "fieldId": "1FD5AED2-DD89-4B67-9599-CE2A61C29461",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.CountryModel"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State",
                         "fieldId": "A4608B97-8AFD-435B-8DAD-F4948B9BAFE1",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.StateModel"
                         }
                    }, {
                         "name": "regionName",
                         "itemId": "regionName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Region Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Name",
                         "fieldId": "6E38BECD-292E-431F-AA93-D29490236AE2",
                         "minLength": "0",
                         "maxLength": "256"
                    }, {
                         "name": "regionCode1",
                         "itemId": "regionCode1",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Region Code 1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Code 1",
                         "fieldId": "18D86E18-A470-41DD-9A64-67548446D8A7",
                         "minValue": "0",
                         "maxValue": "3"
                    }, {
                         "name": "regionCodeChar2",
                         "itemId": "regionCodeChar2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Region Code 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Code 2",
                         "fieldId": "9609A812-82DE-4516-AC6C-32D5182FF29C",
                         "minLength": "0",
                         "maxLength": "32"
                    }]
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
                    "viewModel": "RegionViewModel",
                    "xtype": "form",
                    "displayName": "Region",
                    "title": "Region",
                    "name": "Region",
                    "itemId": "Region",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "regionId",
                         "itemId": "regionId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Region Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Id<font color='red'> *<\/font>",
                         "fieldId": "29208615-802A-414A-92E5-C3460AAA6F3F",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "regionId",
                         "bind": "{regionId}"
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "1FD5AED2-DD89-4B67-9599-CE2A61C29461",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.CountryModel"
                         },
                         "bindable": "countryId",
                         "bind": "{countryId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onCountryIdChange"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "A4608B97-8AFD-435B-8DAD-F4948B9BAFE1",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.StateModel"
                         },
                         "bindable": "stateId",
                         "bind": "{stateId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionName",
                         "itemId": "regionName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Region Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "6E38BECD-292E-431F-AA93-D29490236AE2",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "regionName",
                         "bind": "{regionName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionCode1",
                         "itemId": "regionCode1",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Region Code 1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Code 1<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "18D86E18-A470-41DD-9A64-67548446D8A7",
                         "minValue": "0",
                         "maxValue": "3",
                         "bindable": "regionCode1",
                         "bind": "{regionCode1}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionCodeChar2",
                         "itemId": "regionCodeChar2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Region Code 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Code 2<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "9609A812-82DE-4516-AC6C-32D5182FF29C",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "regionCodeChar2",
                         "bind": "{regionCodeChar2}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionDescription",
                         "itemId": "regionDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Region Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Description",
                         "fieldId": "CF54F725-CBDC-46DC-B19A-D6497FD4C1D8",
                         "bindable": "regionDescription",
                         "bind": "{regionDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionFlag",
                         "itemId": "regionFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "94E0B389-D740-4592-BB79-915EBA090221",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "regionFlag",
                         "bind": "{regionFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionLatitude",
                         "itemId": "regionLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Region Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Latitude",
                         "fieldId": "109E3B34-5D12-4D92-8548-D8655D09231E",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "regionLatitude",
                         "bind": "{regionLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionLongitude",
                         "itemId": "regionLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Region Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Longitude",
                         "fieldId": "7B25E6DE-A36E-4526-861F-ADD54ACE1ABB",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "regionLongitude",
                         "bind": "{regionLongitude}",
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
                         "fieldId": "ACF9E6EA-7E93-4E37-AE0C-1F03B80D879C",
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
                         "customId": 708,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 708,
                              "customId": 867
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 708,
                              "customId": 868,
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
                              "parentId": 708,
                              "customId": 869,
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
                    "displayName": "Region",
                    "title": "Details Grid",
                    "name": "RegionGrid",
                    "itemId": "RegionGrid",
                    "restURL": "/Region",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Region Id",
                         "dataIndex": "regionId",
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
                         "header": "Country",
                         "dataIndex": "countryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "State",
                         "dataIndex": "stateId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Region Name",
                         "dataIndex": "regionName",
                         "flex": 1
                    }, {
                         "header": "Region Code 1",
                         "dataIndex": "regionCode1",
                         "flex": 1
                    }, {
                         "header": "Region Code 2",
                         "dataIndex": "regionCodeChar2",
                         "flex": 1
                    }, {
                         "header": "Region Description",
                         "dataIndex": "regionDescription",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "regionFlag",
                         "flex": 1
                    }, {
                         "header": "Region Latitude",
                         "dataIndex": "regionLatitude",
                         "flex": 1
                    }, {
                         "header": "Region Longitude",
                         "dataIndex": "regionLongitude",
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
               "viewModel": "RegionViewModel",
               "xtype": "form",
               "displayName": "Region",
               "title": "Region",
               "name": "Region",
               "itemId": "Region",
               "bodyPadding": 10,
               "items": [{
                    "name": "regionId",
                    "itemId": "regionId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Region Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Id<font color='red'> *<\/font>",
                    "fieldId": "29208615-802A-414A-92E5-C3460AAA6F3F",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "regionId",
                    "bind": "{regionId}"
               }, {
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "1FD5AED2-DD89-4B67-9599-CE2A61C29461",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.CountryModel"
                    },
                    "bindable": "countryId",
                    "bind": "{countryId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onCountryIdChange"
                    }
               }, {
                    "name": "stateId",
                    "itemId": "stateId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "State",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "A4608B97-8AFD-435B-8DAD-F4948B9BAFE1",
                    "restURL": "State",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.StateModel"
                    },
                    "bindable": "stateId",
                    "bind": "{stateId}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionName",
                    "itemId": "regionName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Region Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "6E38BECD-292E-431F-AA93-D29490236AE2",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "regionName",
                    "bind": "{regionName}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionCode1",
                    "itemId": "regionCode1",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Region Code 1",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Code 1<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "18D86E18-A470-41DD-9A64-67548446D8A7",
                    "minValue": "0",
                    "maxValue": "3",
                    "bindable": "regionCode1",
                    "bind": "{regionCode1}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionCodeChar2",
                    "itemId": "regionCodeChar2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Region Code 2",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Code 2<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "9609A812-82DE-4516-AC6C-32D5182FF29C",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "regionCodeChar2",
                    "bind": "{regionCodeChar2}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionDescription",
                    "itemId": "regionDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Region Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Description",
                    "fieldId": "CF54F725-CBDC-46DC-B19A-D6497FD4C1D8",
                    "bindable": "regionDescription",
                    "bind": "{regionDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionFlag",
                    "itemId": "regionFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "94E0B389-D740-4592-BB79-915EBA090221",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "regionFlag",
                    "bind": "{regionFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionLatitude",
                    "itemId": "regionLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Region Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Latitude",
                    "fieldId": "109E3B34-5D12-4D92-8548-D8655D09231E",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "regionLatitude",
                    "bind": "{regionLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionLongitude",
                    "itemId": "regionLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Region Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Longitude",
                    "fieldId": "7B25E6DE-A36E-4526-861F-ADD54ACE1ABB",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "regionLongitude",
                    "bind": "{regionLongitude}",
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
                    "fieldId": "ACF9E6EA-7E93-4E37-AE0C-1F03B80D879C",
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
                    "customId": 708,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 708,
                         "customId": 867
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 708,
                         "customId": 868,
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
                         "parentId": 708,
                         "customId": 869,
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