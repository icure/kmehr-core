package org.taktik.icure.services.external.http.websocket.annotation

import org.taktik.icure.services.external.http.websocket.operation.WebSocketOperationFactory
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
annotation class WSOperationFactory(val value: KClass<out WebSocketOperationFactory>)
