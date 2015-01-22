package generator

import groovy.text.markup.BaseTemplate
import groovy.text.markup.MarkupTemplateEngine
import groovy.text.markup.TemplateConfiguration
import groovy.transform.CompileStatic

@CompileStatic
abstract class PageTemplate extends BaseTemplate {
    public static final String BASEDIR = "basePath";

    private final Map model

    PageTemplate(
            final MarkupTemplateEngine templateEngine,
            final Map model, final Map<String, String> modelTypes, final TemplateConfiguration configuration) {
        super(templateEngine, model, modelTypes, configuration)
        this.model = model
    }

    String relative(String path) {
        String base = (String) model.get(BASEDIR)
        if (base && !path.startsWith('http') && !path.startsWith('/')) {
            "${'../'*(1+base.count('/'))}$path"
        } else {
            path
        }
    }
}
