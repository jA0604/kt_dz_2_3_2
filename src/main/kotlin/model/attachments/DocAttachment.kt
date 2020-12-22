package model.attachments

import model.Doc

class DocAttachment(
    val value: Doc,
    override val type: String="doc"
) : Attachment {


}