package model.attachments

import model.Note

class NoteAttachment (
    val value: Note,
    override val type: String="note"
    ) : Attachment {

}


//    : Attachment {
//    override val type: String="note"
//    val note: Note = Note()
//
//
//}