package org.taktik.icure.services.external.http.websocket.annotation

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class WSParam(val value: String)
