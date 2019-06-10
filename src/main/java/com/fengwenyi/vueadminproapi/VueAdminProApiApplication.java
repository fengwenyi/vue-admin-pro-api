package com.fengwenyi.vueadminproapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class VueAdminProApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueAdminProApiApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1.允许任何域名使用
        corsConfiguration.addAllowedHeader("*"); // 2.允许任何头
        corsConfiguration.addAllowedMethod("*"); // 3.允许任何方法（post、get等）
        return corsConfiguration;
    }

    /*private CorsConfiguration buildConfig() {

        List<String> exposedHeaders = new ArrayList<String>();
        exposedHeaders.add("Access-Control-Allow-Origin");
        exposedHeaders.add("Access-Control-Allow-Credentials");

        List<String> allowedMethods = new ArrayList<String>();
        allowedMethods.add("GET");
        allowedMethods.add("POST");

        List<String> allowedHeaders = new ArrayList<String>();
        allowedHeaders.add("Content-Type");
        allowedHeaders.add("X-Requested-With");
        allowedHeaders.add("accept");
        allowedHeaders.add("Origin");
        allowedHeaders.add("Access-Control-Request-Method");
        allowedHeaders.add("Access-Control-Request-Headers");
        allowedHeaders.add("Accept");//这里设置要和前端js名字一样
        allowedHeaders.add("userToken");//这里设置要和前端js名字一样

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1.允许任何域名使用
        corsConfiguration.setAllowedHeaders(allowedHeaders);
        corsConfiguration.setAllowedMethods(allowedMethods);
        corsConfiguration.setExposedHeaders(exposedHeaders);
        corsConfiguration.setMaxAge(3600L);
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }*/
}
