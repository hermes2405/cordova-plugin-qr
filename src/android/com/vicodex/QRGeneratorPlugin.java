/**
 */
package com.vicodex;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.graphics.Bitmap;
import android.util.Log;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.Hashtable;


import com.command.sdk.PrintPicture;

public class QRGeneratorPlugin extends CordovaPlugin {
  private static final String TAG = "QRGeneratorPlugin";
  //QRcode
  private static final int QR_WIDTH = 350;
  private static final int QR_HEIGHT = 350;



  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing QRGeneratorPlugin");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if (action.equals("getQRCode")){
      String strToCode = args.getString(0);
      if (strToCode != null && strToCode.length() > 0){
        //obteniendo el valor en byte[] del codigo qr dada la cadena
        byte[] data = generateQRBytes(strToCode);
        //enviando como respuesta al emisor.
        PluginResult result = new PluginResult(PluginResult.Status.OK, data);
        result.setKeepCallback(true);
        callbackContext.sendPluginResult(result);
      }
    }

    /*if(action.equals("echo")) {
      String phrase = args.getString(0);
      // Echo back the first argument
      Log.d(TAG, phrase);
    } else if(action.equals("getDate")) {
      // An example of returning data back to the web layer
      final PluginResult result = new PluginResult(PluginResult.Status.OK, (new Date()).toString());
      callbackContext.sendPluginResult(result);
    }*/

    return true;
  }


  private byte[] generateQRBytes(String text) {
    try {
      // 需要引入zxing包    -- Necesidad de introducir el paquete zxing
      QRCodeWriter writer = new QRCodeWriter();
      //Log.i(TAG, "生成的文本：" + text);
      if (text == null || "".equals(text) || text.length() < 1) {
        return null;
      }

      // 把输入的文本转为二维码     -- El texto de entrada en código bidimensional
      BitMatrix martix = writer.encode(text, BarcodeFormat.QR_CODE,
              QR_WIDTH, QR_HEIGHT);

      System.out.println("w:" + martix.getWidth() + "h:"
              + martix.getHeight());

      Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
      hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
      BitMatrix bitMatrix = new QRCodeWriter().encode(text,
              BarcodeFormat.QR_CODE, QR_WIDTH, QR_HEIGHT, hints);
      int[] pixels = new int[QR_WIDTH * QR_HEIGHT];
      for (int y = 0; y < QR_HEIGHT; y++) {
        for (int x = 0; x < QR_WIDTH; x++) {
          if (bitMatrix.get(x, y)) {
            pixels[y * QR_WIDTH + x] = 0xff000000;
          } else {
            pixels[y * QR_WIDTH + x] = 0xffffffff;
          }

        }
      }

      Bitmap bitmap = Bitmap.createBitmap(QR_WIDTH, QR_HEIGHT,
              Bitmap.Config.ARGB_8888);

      bitmap.setPixels(pixels, 0, QR_WIDTH, 0, 0, QR_WIDTH, QR_HEIGHT);

      byte[] data = PrintPicture.POS_PrintBMP(bitmap, 384, 0);
      return data;
    } catch (WriterException e) {
      e.printStackTrace();
      return null;
    }
  }
}

