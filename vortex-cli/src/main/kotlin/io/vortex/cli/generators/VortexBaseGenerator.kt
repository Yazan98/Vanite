package io.vortex.cli.generators

import io.vortex.cli.VortexPrinter
import java.io.FileWriter
import java.nio.charset.Charset

abstract class VortexBaseGenerator {

    private val fileWriter: FileWriter by lazy {
        FileWriter(getFilePath() + getFileExt(), Charset.defaultCharset())
    }

    fun execute() {
        println("Vortex Info : Start Generate : ${getFilePath() + getFileExt()}")
        fileWriter.write(getFileComment(getFileType()))
        fileWriter.write(getFileContent())
        fileWriter.close()
        println("Vortex Info : File Generator Finished : ${getFilePath() + getFileExt()}")
    }

    private fun getFileComment(fileType: VortexFileType): String {
        return when (fileType) {
            VortexFileType.XML -> VortexPrinter.getXmlComment()
            VortexFileType.GRADLE -> VortexPrinter.getNormalComment()
            VortexFileType.KOTLIN -> VortexPrinter.getNormalComment()
        }
    }

    abstract fun getFileType(): VortexFileType
    abstract fun getFileContent(): String
    abstract fun getFileExt(): String
    abstract fun getFilePath(): String

}
