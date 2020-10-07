package com.forrester.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PackageUtil {

    public static final Logger logger = LoggerFactory.getLogger(PackageUtil.class);

    private PackageUtil() throws IllegalAccessException {
        throw new IllegalAccessException("For static use only");
    }

    public static final List<Class<?>> scanClasses(String packageName, List<Class> includeClasses, List<Class> excludeClasses) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        final ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);

        includeClasses.stream().forEach(c -> scanner.addIncludeFilter(new AnnotationTypeFilter(c)));
        excludeClasses.stream().forEach(c -> scanner.addExcludeFilter(new AnnotationTypeFilter(c)));

        return scanner.findCandidateComponents(packageName).stream().map(rb -> {
            try {
                return cl.loadClass(rb.getBeanClassName());
            } catch (ClassNotFoundException e) {
                logger.error("Unable to load class {}.", rb.getBeanClassName());
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
