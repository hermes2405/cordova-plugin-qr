
var exec = require('cordova/exec');

var PLUGIN_NAME = 'QRGeneratorPlugin';

var QRGeneratorPlugin = {
  getQRCode : function (strtocode,cb){
  	exec(cb, null, PLUGIN_NAME, 'getQRCode', [strtocode]);
  }
};

module.exports = QRGeneratorPlugin;
