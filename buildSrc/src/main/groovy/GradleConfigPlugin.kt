import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class GradleConfigPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.apply("${target.rootDir}/buildSrc/commons/gradle")
    }
}