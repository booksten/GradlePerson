package com.blende.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTimeZone;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages= {"com.blende.controller", "com.blende.support.impl"})
public class ControllerConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        DateTimeZone.setDefault(DateTimeZone.UTC);
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(16777215);//5242880
        return resolver;
    }

    @Bean
    public Jackson2ObjectMapperFactoryBean jsonMapper() {
        Jackson2ObjectMapperFactoryBean objectMapper = new Jackson2ObjectMapperFactoryBean();
        objectMapper.setSimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return objectMapper;
    }

    @Bean
    public ObjectMapper objectMapper(){
        return jsonMapper().getObject();
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2Converter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper());
        return converter;
    }

    @Bean
    public ByteArrayHttpMessageConverter byteArrayConverter(){
        ByteArrayHttpMessageConverter byteArrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
        List<MediaType> mediaTypes=new ArrayList<>();
        mediaTypes.add(MediaType.IMAGE_PNG);
        mediaTypes.add(MediaType.IMAGE_JPEG);
        byteArrayHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        return byteArrayHttpMessageConverter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(byteArrayConverter());
        converters.add(mappingJackson2Converter());
    }

}
