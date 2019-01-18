package com.vincce.fun.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

/**
  Created By BaoNing On 2019年1月17日
*/
@RestController
@RequestMapping("/upload/tencent")
public class TencentUpController {
	
	@PostMapping("/files")
	public Object uploadFile(@RequestParam("file") String fileUrl) throws Exception {
		
		String secretId = "AKIDvm0382kPgHbkmdDONBnHakqdGgr9qT5a";
		String secretKey = "T7vcCj7Qbikcgz74rTsATxfCYjiyP6e0";
		
		// 1.初始化用户身份信息（secretId, secretKey）
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		
		// 2.设置bucket区域
		ClientConfig clientConfig = new ClientConfig( new Region("ap-chengdu"));
		
		// 3.生成 cos 客户端
		COSClient cosClient = new COSClient(cred, clientConfig);
		
		// 4.bucket命名
		String bucketName = "captain-1257226620";
		
		File localfile = new File(fileUrl);
		
		FileInputStream inupt = new FileInputStream(localfile);
		
		//存入的文件名 重复会覆盖
		String key =  "picture/" + System.currentTimeMillis() + "." + fileUrl.substring(fileUrl.lastIndexOf(".") + 1);
		
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentType("image/png");
		
		
		PutObjectResult putObjectResult = cosClient.putObject(bucketName, key, inupt, metadata);
		
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		
		String requestId = putObjectResult.getRequestId();
		map.put("requestId", requestId);
		
		String eTag = putObjectResult.getETag();
		map.put("eTag", eTag);
		
		String sseAlgorithm = putObjectResult.getSSEAlgorithm();
		map.put("sseAlgorithm", sseAlgorithm);
				
		list.add(map);
		cosClient.shutdown();
		
		//获取上传后的地址
		Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
		URL url = cosClient.generatePresignedUrl(bucketName,key,expiration);
		String pathUrl = String.valueOf(url);
		
		int indexOf = pathUrl.indexOf("?");
		String picurl = pathUrl.substring(0,indexOf);

		return picurl;
	}

}
