package model

data class Note (
    val id: Int,
    val ownerIid: Int,

    val title: String,
    val text: String,
    val date: Long,
    val comments: Int,
    val readComments: Int,
    val viewUrl: String,
    override val type: String = "note",
    override val attach: Attachment? = null

) : Attachment
{

}
