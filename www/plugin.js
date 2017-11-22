
var exec = require('cordova/exec');

var PLUGIN_NAME = 'QRGenerator';

var QRGenerator = {
  getQRCode : function (strtocode,cb){
  	exec(cb, null, PLUGIN_NAME, 'getQRCode', [strtocode]);
  }
};

module.exports = QRGenerator;
