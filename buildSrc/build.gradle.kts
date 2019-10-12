plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
}

kotlinDslPluginOptions.apply {
    experimentalWarning.set(true)
}
