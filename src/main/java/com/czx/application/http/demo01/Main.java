package com.czx.application.http.demo01;

import java.io.UnsupportedEncodingException;

public class Main {

	public static void main(String[] args) throws Exception {
		//∑¢ÀÕ GET «Î«Û
		String token = "WrhAV9voGR37CN2Cq-6IzI-_cdOy0y2QuszLCySodT-mn_yqqc0ikFmeC1v_613gbdHxrJ-LGbATx7-G1FXihS7l5To52HxM8tScmmC5p1X5lhfES7HYI-qSyeogFwmoAVSjABAJEB";
        String s=HttpRequest.sendGet("https://api.weixin.qq.com/cgi-bin/menu/get", "access_token="+token);
        System.out.println(s);
        System.out.println(0.01d+0.06d);
	}
}
