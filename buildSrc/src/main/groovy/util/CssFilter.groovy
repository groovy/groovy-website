package util

import com.yahoo.platform.yui.compressor.CssCompressor
import org.apache.tools.ant.filters.BaseFilterReader

class CssFilter extends BaseFilterReader {
    Writer writer
    Thread worker

    CssFilter(Reader reader) {
        super(new PipedReader())
        writer = new PipedWriter(this.@in)
        def compressor = new CssCompressor(reader)
        reader.close()
        worker = Thread.start {
            compressor.compress(writer, -1)
            writer.close()
        }
    }

    void close() {
        worker.join()
        super.close()
    }

}
