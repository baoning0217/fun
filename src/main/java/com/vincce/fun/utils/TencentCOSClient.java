package com.vincce.fun.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;

/**
  Created By BaoNing On 2019年1月17日
*/
public class TencentCOSClient {
	
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
	
	

}
