package com.pri;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.Config;
import org.springframework.beans.factory.annotation.Value;

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
@EnableApolloConfig
public class AppGateWay {

	// 手动获取获取远程服务的SwaggerApi,(懒汉式加载)
	@ApolloConfig
	private Config config;

	// 注解式获取获取远程服务的SwaggerApi，(饿汉式加载) ChenQi
	@Value("${pri.zuul.swagger.document}")
	private String swaggerDocument;

	public static void main(String[] args) {
        SpringApplication.run(AppGateWay.class, args);
	}

	// 添加文档来源
	@Component
	@Primary
	class DocumentationConfig implements SwaggerResourcesProvider {
/*		@Override
		public List<SwaggerResource> get() {
			List resources = new ArrayList<>();
			// app-itmayiedu-order
			*//**
			 * description: name:"app-pri-member"，是eureka中注册的服务别名(id);
			 * /app-pri-member/v2/api-docs，是文档名称
			 * 网关使用服务别名，获取远程服务的SwaggerApi
			 * author: ChenQi <BR>
			 * createDate: 2020-02-17 13:35  <BR>
			 *//*
			resources.add(swaggerResource("app-pri-member", "/app-pri-member/v2/api-docs", "2.0"));
			resources.add(swaggerResource("app-pri-weixin", "/app-pri-weixin/v2/api-docs", "2.0"));
			return resources;
		}*/

		// 访问swagger-ui页面的每次都会范围访问一下get方法
		// 定义value 注解获取和手动获取区别是什么？-->手动是懒汉式，注解式饿汉式
		@SuppressWarnings("rawtypes")
		@Override
		public List<SwaggerResource> get() {
			// app-itmayiedu-order
			// 网关使用服务别名获取远程服务的SwaggerApi
			return resources();
		}

		/**
		 * methodName: resources <BR>
		 * description:  网关使用服务别名获取远程服务的SwaggerApi <BR>
		 * remark: <BR>
		 * param:  <BR>
		 * return: java.util.List<springfox.documentation.swagger.web.SwaggerResource> <BR>
		 * author: ChenQi <BR>
		 * createDate: 2020-02-27 23:17 <BR>
		 */
		private List<SwaggerResource> resources() {

			List resources = new ArrayList<>();
			// app-itmayiedu-order
			// 网关使用服务别名获取远程服务的SwaggerApi
			String swaggerDocJson = swaggerDocument();

			/* 将SwaggerApi转成json数组 ChenQi*/
            JSONArray jsonArray = JSONArray.parseArray(swaggerDocJson);
			// JSONArray jsonArray = JSONArray.parseArray(swaggerDocument);
			for (Object object : jsonArray) {
				JSONObject jsonObject = (JSONObject) object;
				String name = jsonObject.getString("name");
				String location = jsonObject.getString("location");
				String version = jsonObject.getString("version");
				resources.add(swaggerResource(name, location, version));
			}
			return resources;
		}

        /**
         * methodName: swaggerDocument <BR>
         * description: 网关使用服务别名获取远程服务的SwaggerApi <BR>
         * remark: <BR>
         * param:  <BR>
         * return: java.lang.String <BR>
         * author: ChenQi <BR>
         * createDate: 2020-02-27 23:14 <BR>
         */
        private String swaggerDocument() {
            String property = config.getProperty("pri.zuul.swagger.document","");
            return property;
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
