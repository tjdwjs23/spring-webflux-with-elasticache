package demo.webflux.ports.output

import demo.webflux.domain.board.Board

data class BoardResponse(
    var id: Long? = null,
    val title: String? = null,
    val content: String? = null,
    var writeId: String? = null,
    var createdDate: String? = null,
    var updatedDate: String? = null,
) {
    fun toBoard(): Board {
        return Board(id, title, content, writeId, createdDate, updatedDate)
    }
}
