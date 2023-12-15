@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed (https://youtrack.jetbrains.com/issue/KTIJ-19369)
plugins {
    id("com.icure.kotlin-library-conventions")

    alias(coreLibs.plugins.ksp)
}

dependencies {

    implementation(coreLibs.bundles.swaggerLibs)
    implementation(coreLibs.bundles.krouchLibs)
    implementation(coreLibs.bundles.kotlinxCoroutinesLibs)

    implementation(coreLibs.kotlinxCollectionsImmutableJvm)

    implementation(coreLibs.springBootWebflux)
    implementation(coreLibs.springBootSecurity)

    implementation(coreLibs.mapstruct)
    implementation(coreLibs.kmapKsp)

    implementation(coreLibs.javaxServlet)

    implementation(kmehrLibs.ajaltClikt)

    ksp(group = "io.icure", name = "kmap", version = coreLibs.versions.kmap.orNull)
}
