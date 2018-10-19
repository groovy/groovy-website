package util

import com.yahoo.platform.yui.compressor.JavaScriptCompressor
import org.apache.tools.ant.filters.BaseFilterReader

class JsFilter extends BaseFilterReader {
    Writer writer
    Thread worker

    JsFilter(Reader reader) {
        super(new PipedReader())
        writer = new PipedWriter(this.@in)
        def compressor = new JavaScriptCompressor(reader, null)
        reader.close()
        worker = Thread.start {
            compressor.compress(writer, -1, true, false, false, false)
            writer.close()
        }
    }

    void close() {
        worker.join()
        super.close()
    }

}
