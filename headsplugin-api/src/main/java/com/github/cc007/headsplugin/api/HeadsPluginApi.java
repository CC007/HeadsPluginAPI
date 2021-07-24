package com.github.cc007.headsplugin.api;

import com.github.cc007.headsplugin.api.business.services.heads.CategorySearcher;
import com.github.cc007.headsplugin.api.business.services.heads.CategoryUpdater;
import com.github.cc007.headsplugin.api.business.services.heads.HeadCreator;
import com.github.cc007.headsplugin.api.business.services.heads.HeadPlacer;
import com.github.cc007.headsplugin.api.business.services.heads.HeadSearcher;
import com.github.cc007.headsplugin.api.business.services.heads.HeadToItemstackMapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.BeanFactory;

import java.lang.reflect.InvocationTargetException;

@RequiredArgsConstructor
@Log4j2
public class HeadsPluginApi {
    private static HeadsPluginApi INSTANCE = null;

    @Getter
    private final BeanFactory beanFactory;

    public static HeadsPluginApi getInstance(BeanFactory beanFactory) {
        if (INSTANCE == null) {
            INSTANCE = new HeadsPluginApi(beanFactory);
        }
        return INSTANCE;
    }

    public static void addSpringClassLoader(ClassLoader classLoader) {
        try {
            Class.forName("com.github.cc007.headsplugin.HeadsPlugin")
                    .getMethod("addSpringClassLoader", ClassLoader.class).invoke(null, classLoader);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("HeadsPlugin class not found! Make sure that the HeadsPluginAPI plugin is in the plugins folder.", e);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Something is wrong with HeadsPluginAPI! Please contact the developer and provide the following stacktrace.", e);
        }
    }

    public static HeadsPluginApi getInstance() {
        if (INSTANCE == null) {
            try {
                BeanFactory beanFactory = null;
                beanFactory = (BeanFactory) Class.forName("com.github.cc007.headsplugin.HeadsPlugin")
                        .getMethod("getSpringContext").invoke(null);
                INSTANCE = new HeadsPluginApi(beanFactory);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("HeadsPlugin class not found! Make sure that the HeadsPluginAPI plugin is in the plugins folder.", e);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Something is wrong with HeadsPluginAPI! Please contact the developer and provide the following stacktrace.", e);
            }
        }
        return INSTANCE;
    }


    public HeadToItemstackMapper getHeadToItemstackMapper() {
        return beanFactory.getBean(HeadToItemstackMapper.class);
    }

    public HeadCreator getHeadCreator() {
        return beanFactory.getBean(HeadCreator.class);
    }

    public HeadPlacer getHeadPlacer() {
        return beanFactory.getBean(HeadPlacer.class);
    }

    public HeadSearcher getHeadSearcher() {
        return beanFactory.getBean(HeadSearcher.class);
    }

    public CategoryUpdater getCategoryUpdater() {
        return beanFactory.getBean(CategoryUpdater.class);
    }

    public CategorySearcher getCategorySearcher() {
        return beanFactory.getBean(CategorySearcher.class);
    }
}
