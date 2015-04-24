package generator

import groovy.transform.CompileStatic
import org.asciidoctor.Asciidoctor

@CompileStatic
class AsciidoctorFactory {
    @Lazy static Asciidoctor instance = Asciidoctor.Factory.create()
}
