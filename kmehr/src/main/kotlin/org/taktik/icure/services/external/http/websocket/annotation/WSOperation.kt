package org.taktik.icure.services.external.http.websocket.annotation

import org.taktik.icure.services.external.http.websocket.operation.Operation
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
annotation class WSOperation(val adapterClass: KClass<out Operation>)
