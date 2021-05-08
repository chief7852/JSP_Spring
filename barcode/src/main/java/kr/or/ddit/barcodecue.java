package kr.or.ddit;

import java.awt.Color;
import java.io.File;

import org.json.JSONObject;
import org.json.JSONException;


import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

public class barcodecue {

	public static void main(String[] args) {

		

		try {
			String str = "{\"name\":\"John\",\"age\":\"30\"}";
			JSONObject jsonObject = new JSONObject(str);
			System.out.println("OBJECT : " + jsonObject.toString());
			Barcode barcode = BarcodeFactory.createCode128(str);
			barcode.setBackground(Color.pink);
			File file = new File("d:/barcode2.png");

			BarcodeImageHandler.savePNG(barcode, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
