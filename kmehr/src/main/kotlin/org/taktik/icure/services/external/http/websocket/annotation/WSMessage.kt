package org.taktik.icure.services.external.http.websocket.annotation

import org.springframework.web.reactive.socket.WebSocketMessage
import kotlin.reflect.KClass

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class WSMessage(val messageClass: KClass<*> = WebSocketMessage::class)
