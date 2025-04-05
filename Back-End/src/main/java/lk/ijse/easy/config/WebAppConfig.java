package lk.ijse.easy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Marks this class as a configuration class for the Spring container
@EnableWebMvc // Enables Spring MVC features
@ComponentScan(basePackages = {"lk.ijse.easy.controller", "lk.ijse.easy.advisor"}) // Scans specified packages for annotated components
public class WebAppConfig implements WebMvcConfigurer {

    // ========== Multipart File Upload Configuration ==========
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(500000000); // Sets maximum upload size to ~500MB
        return multipartResolver;
    }

    // ========== Static Resource Handling ==========
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Maps requests starting with /uploads/** to the /uploads/ directory in the app
        registry.addResourceHandler("/uploads/**").addResourceLocations("/uploads/");
    }
}
