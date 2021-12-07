package com.ssafy.hanbang.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.hanbang.interceptor.JwtInterceptor;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(WebConfig.class, args);
	}

	@Autowired
	private JwtInterceptor jwtInterceptor;

//	 intercepter 처리 addInterceptors 접근할 수 있는 것을 ("/**").excludePath(어디만빼고)
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(jwtInterceptor).addPathPatterns("/hanbang/**") // 기본 적용 경로
//				.excludePathPatterns(Arrays.asList("/hanbang/user/**")); // 적용 제외 경로
//	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
//		System.out.println("CORS Setting");
//		default 설정.
//		Allow all origins.
//		Allow "simple" methods GET, HEAD and POST.
//		Allow all headers.
//		Set max age to 1800 seconds (30 minutes).
		registry.addMapping("/**").allowedOrigins("*")
//			.allowedOrigins("http://localhost:8080", "http://localhost:8081")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS").maxAge(6000);
	}

//	Swagger UI 실행시 404처리
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui.html**")
				.addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
