package io.vortex.cli.generators

import java.io.File

object VortexFileGenerator {

    fun generateFiles(files: List<String>) {
        files.forEach {
            println("Vortex Info : Start Generate File : $it")
            File(it).mkdir()
            println("Vortex Info : Generator Finished : $it")
        }
    }

}
