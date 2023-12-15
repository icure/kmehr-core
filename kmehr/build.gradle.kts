@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed (https://youtrack.jetbrains.com/issue/KTIJ-19369)
plugins {
    id("com.icure.kotlin-library-conventions")
    alias(coreLibs.plugins.ksp)
}

dependencies {
    implementation(coreLibs.bundles.krouchLibs)

    implementation(coreLibs.bundles.swaggerLibs)

    implementation(coreLibs.kotlinxCoroutinesCore)
    implementation(coreLibs.kotlinxCoroutinesReactive)
    implementation(coreLibs.kotlinxCoroutinesReactor)

    implementation(coreLibs.springBootWebflux)
    implementation(coreLibs.springBootSecurity)

    implementation(kmehrLibs.commonsCodec)

    implementation(coreLibs.jaxbApi)
    implementation(coreLibs.jaxbRuntime)

    implementation(coreLibs.commonsIO)

    implementation(kmehrLibs.mustacheJava)

    implementation(coreLibs.kotlinxCollectionsImmutableJvm)

    implementation(coreLibs.taktikCommons)

    implementation(coreLibs.guava)

    implementation(coreLibs.mapstruct)
    implementation(coreLibs.kmapKsp)

    implementation(coreLibs.javaxServlet)

    ksp(group = "io.icure", name = "kmap", version = coreLibs.versions.kmap.orNull)
}
