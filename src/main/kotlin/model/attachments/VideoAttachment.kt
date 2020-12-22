package model.attachments

import model.Video

class VideoAttachment(
    val value: Video,
    override val type: String="video"
) : Attachment {


}
