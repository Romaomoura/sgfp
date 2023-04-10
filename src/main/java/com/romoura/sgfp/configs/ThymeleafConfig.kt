package com.romoura.sgfp.configs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.ViewResolver
import org.thymeleaf.spring6.SpringTemplateEngine
import org.thymeleaf.spring6.view.ThymeleafViewResolver
import org.thymeleaf.templatemode.TemplateMode
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import org.thymeleaf.templateresolver.ITemplateResolver

@Configuration
class ThymeleafConfig{
    @Bean
    fun viewResolver(): ViewResolver {
        val resolver = ThymeleafViewResolver()
        resolver.templateEngine = templateEngine()
        resolver.characterEncoding = "UTF-8"
        return resolver
    }

    private fun templateEngine(): SpringTemplateEngine {
        val engine = SpringTemplateEngine()
        engine.enableSpringELCompiler = true
        engine.setTemplateResolver(templateResolver())
        return engine
    }

    private fun templateResolver(): ITemplateResolver {
        val resolver = ClassLoaderTemplateResolver()
        resolver.prefix = "/templates/"
        resolver.suffix = ".html"
        resolver.templateMode = TemplateMode.HTML
        resolver.characterEncoding = "UTF-8"
        resolver.isCacheable = false
        return resolver
    }

}
