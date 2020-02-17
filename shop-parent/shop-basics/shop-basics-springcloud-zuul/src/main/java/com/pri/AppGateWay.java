package com.pri;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * className: AppGateWay <BR>
 * description: 微服务网关入口 <BR>
 * remark: <BR>
 * author: ChenQi <BR>
 * createDate: 2020-02-17 13:34 <BR>
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableSwagger2Doc
public class AppGateWay {

	public static void main(String[] args) {
        SpringApplication.run(AppGateWay.class, args);
	}

	// 添加文档来源
	@Component
	@Primary
	class DocumentationConfig implements SwaggerResourcesProvider {
		@Override
		public List<SwaggerResource> get() {
			List resources = new ArrayList<>();
			// app-itmayiedu-order
			/**
			 * description: name:"app-pri-member"，是eureka中注册的服务别名(id);
			 * /app-pri-member/v2/api-docs，是文档名称
			 * 网关使用服务别名，获取远程服务的SwaggerApi
			 * author: ChenQi <BR>
			 * createDate: 2020-02-17 13:35  <BR>
			 */
			resources.add(swaggerResource("app-pri-member", "/app-pri-member/v2/api-docs", "2.0"));
			resources.add(swaggerResource("app-pri-weixin", "/app-pri-weixin/v2/api-docs", "2.0"));
			return resources;
		}

		private SwaggerResource swaggerResource(String name, String location, String version) {
			SwaggerResource swaggerResource = new SwaggerResource();
			swaggerResource.setName(name);
			swaggerResource.setLocation(location);
			swaggerResource.setSwaggerVersion(version);
			return swaggerResource;
		}

	}

}
