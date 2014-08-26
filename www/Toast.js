var toast = {
    showMsg: function(msg,successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'TestToast', // mapped to our native Java class called "Calendar"
            'showToast', // with this action name
            [{                  // and this array of custom arguments to create our entry
                "Msg": msg                
            }]
        ); 
     }
}
module.exports = toast;