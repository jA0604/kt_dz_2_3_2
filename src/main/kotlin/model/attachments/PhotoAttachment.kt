package model.attachments

import model.Photo

class PhotoAttachment(
    val value: Photo,
    override val type: String="photo"
) : Attachment {
}

