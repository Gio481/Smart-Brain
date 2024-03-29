import org.gradle.api.Plugin
import org.gradle.api.Project

class GradlePluginConfig implements Plugin<Project>{

    @Override
    void apply(Project target) {
        target.apply([from: "$target.rootDir/buildSrc/commons.gradle"])
    }
}