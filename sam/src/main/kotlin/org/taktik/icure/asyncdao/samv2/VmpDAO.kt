/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

package org.taktik.icure.asyncdao.samv2

import kotlinx.coroutines.flow.Flow
import org.taktik.couchdb.ViewQueryResultEvent
import org.taktik.icure.asyncdao.InternalDAO
import org.taktik.icure.db.PaginationOffset
import org.taktik.icure.entities.samv2.Vmp

interface VmpDAO : InternalDAO<Vmp> {
	fun findVmpsByLabel(language: String?, label: String?, pagination: PaginationOffset<List<String>>): Flow<ViewQueryResultEvent>
	fun findVmpsByVmpCode(vmpCode: String, paginationOffset: PaginationOffset<String>): Flow<ViewQueryResultEvent>
	fun findVmpsByGroupCode(vmpgCode: String, paginationOffset: PaginationOffset<String>): Flow<ViewQueryResultEvent>
	fun findVmpsByGroupId(vmpgId: String, paginationOffset: PaginationOffset<String>): Flow<ViewQueryResultEvent>

	fun listVmpIdsByGroupCode(vmpgCode: String): Flow<String>
	fun listVmpIdsByGroupId(vmpgId: String): Flow<String>
	fun listVmpIdsByLabel(language: String?, label: String?): Flow<String>

	fun listVmpsByVmpCodes(vmpCodes: List<String>): Flow<Vmp>
	fun listVmpsByGroupIds(vmpgIds: List<String>): Flow<Vmp>
}
