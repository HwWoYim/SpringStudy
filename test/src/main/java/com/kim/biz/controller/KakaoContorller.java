package com.kim.biz.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class KakaoContorller {
	@RequestMapping(value="/kakao.do")
	@ResponseBody
	public String kakaopay() {
		try {
			URL kakaoadd = new URL("http://kapi.kakao.com/v1/payment/ready");
			HttpURLConnection kakaoconn = (HttpURLConnection) kakaoadd.openConnection();
			kakaoconn.setRequestMethod("POST");
			kakaoconn.setRequestProperty("Authorization", "KakaoAK $19542304ddbd9a9b104881b23b82cf58");
			kakaoconn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			kakaoconn.setDoOutput(true); // 서버한테 뭔가 전해줄 것이 있는지 없는지에 따라 넣어주면 됨. 전해줄게 있기 때문에 true
			String kakaoParam = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name=초코파이&quantity=1&total_amount=2200&vat_amount=200&tax_free_amount=0&approval_url=https://localhost:8088&fail_url=https://localhost/fail&cancel_url=https://localhost/cancel";
			OutputStream kakaoOut = kakaoconn.getOutputStream();
			DataOutputStream kakaoData = new DataOutputStream(kakaoOut);
			kakaoData.writeBytes(kakaoParam);
			kakaoData.close();
			
			int kakaoResult = kakaoconn.getResponseCode();
			
			InputStream kakaoIn;
			if(kakaoResult == 200) {
				kakaoIn = kakaoconn.getInputStream();
			} else {
				kakaoIn = kakaoconn.getErrorStream();
			}
			InputStreamReader kakaoReader = new InputStreamReader(kakaoIn);
			BufferedReader kakaoBuffered = new BufferedReader(kakaoReader);
			return kakaoBuffered.readLine();
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login.jsp";
	}
}
