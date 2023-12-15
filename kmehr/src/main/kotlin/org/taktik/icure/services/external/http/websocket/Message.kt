package org.taktik.icure.services.external.http.websocket

import java.io.Serializable

data class Message<K : List<Serializable?>?>(
    val command: String,
    val type: String,
    val uuid: String,
    val body: K
)
