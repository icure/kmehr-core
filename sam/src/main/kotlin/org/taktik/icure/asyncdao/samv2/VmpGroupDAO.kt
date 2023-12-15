/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

package org.taktik.icure.asyncdao.samv2

import kotlinx.coroutines.flow.Flow
import org.taktik.couchdb.ViewQueryResultEvent
import org.taktik.icure.asyncdao.InternalDAO
import org.taktik.icure.db.PaginationOffset
import org.taktik.icure.entities.samv2.VmpGroup

interface VmpGroupDAO : InternalDAO<VmpGroup> {
	fun findVmpGroups(paginationOffset: PaginationOffset<String>): Flow<ViewQueryResultEvent>
	fun findVmpGroupsByLabel(language: String?, label: String?, paginationOffset: PaginationOffset<List<String>>): Flow<ViewQueryResultEvent>
	fun listVmpGroupIdsByLabel(language: String?, label: String?): Flow<String>
	fun findVmpGroupsByVmpGroupCode(vmpgCode: String, paginationOffset: PaginationOffset<String>): Flow<ViewQueryResultEvent>

	fun listVmpGroupsByVmpGroupCodes(vmpgCodes: List<String>): Flow<VmpGroup>
}
