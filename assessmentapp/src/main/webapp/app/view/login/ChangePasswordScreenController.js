Ext.define('Assessmentapp.view.login.ChangePasswordScreenController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.changePasswordScreenController',

	onChangePasswordClick : function(btn, opts) {
		
		var form = btn.up().up();
		if (form.isValid()) {
			var formData = form.getValues();
			delete formData.reTypeNewPassword;

			var entMask = new Ext.LoadMask({
				msg : 'Updating...',
				target : this.getView()
			}).show();

			Ext.Ajax.request({
				timeout : 180000,
				url : "secure/PasswordGenerator/changePassword",
				method : 'PUT',
				waitMsg : 'Updating...',
				entMask : entMask,
				jsonData : formData,
				me : this,
				success : function(response, sender) {
					
					var responseText = Ext.JSON.decode(response.responseText);
					if (responseText.response.success) {
						Ext.Msg.alert("Info", responseText.response.message);
						sender.me.onResetClick();
						
						var pathName= this.location.pathname;
						var initialPath=pathName.slice(0,pathName.lastIndexOf("/"));
						Ext.util.Cookies.clear('changePwd',initialPath);
						
						this.location.reload();
					} else {
						Ext.Msg.alert("Info", responseText.response.message);
					}
					sender.entMask.hide();
				},
				failure : function(response, sender) {
					
					Ext.Msg.alert("ERROR", "Cannot connect to server");
					sender.entMask.hide();
				}
			});
		}
	},

	onResetClick : function(btn, opts) {
		
		this.getView().down('#changePwdForm').reset();
		//this.getView().getForm().reset();
	}
});