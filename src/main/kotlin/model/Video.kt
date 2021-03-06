package model

import model.attachments.Attachment

data class Video (
    val id: Int,
    val ownerId: Int,

    val title: String,
    val description: String,
    val duration: Int,
    val image: Array<ImageCover>,
    val firstFrame: Array<ImageFirsFrame>,
    val date: Long,
    val addingDate: Long,
    val views: Int,
    val localViews: Int,
    val comments: Int,
    val player: String,
    val platform: String,
    val canEdit: Boolean,
    val canAdd: Boolean,
    val isPrivate: Boolean,
    val accessKey: String,
    val processing: Boolean,
    val isFavorite: Boolean,
    val canComment: Boolean,
    val isCanEdit: Boolean,
    val canLike: Boolean,
    val canRepost: Boolean,
    val canSubscribe: Boolean,
    val CanAddToFaves: Boolean,
    val canAttachLink: Boolean,
    val width: Int,
    val height: Int,
    val userId: Int,
    val converting: Boolean,
    val added: Boolean,
    val isSubscribed: Boolean,
    val repeat: Boolean = true,
    val typeVideo: TypeVideo,
    val balance: Int,
    val liveStatus: LiveStatus,
    val live: Boolean,
    val upcoming: Boolean,
    val spectators: Int,
    val likes: LikesVideo,
    val reposts: Repost,

)
{


}
