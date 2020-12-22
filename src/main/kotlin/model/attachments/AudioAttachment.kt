package model.attachments

import model.Audio

class AudioAttachment(
    val value: Audio,
    override val type: String="audio"
): Attachment {
}