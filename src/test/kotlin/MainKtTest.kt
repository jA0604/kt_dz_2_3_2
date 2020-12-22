import model.*
import model.attachments.Attachment
import model.attachments.NoteAttachment
import model.attachments.PhotoAttachment
import model.attachments.VideoAttachment
import org.junit.Assert.*
import org.junit.Test
import service.WallService

class MainKtTest {
    private val service = WallService()

    @Test
    fun addPost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        val expected = Post (
            id = 1,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        service.add(post)
        val result = service.add(post)
        assertEquals(expected.id, result.id)

    }

    @Test
    fun likePost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        val expected = 1

        var copy = service.add(post)
        copy = service.add(copy)

        val result = service.likeById(1)
        assertEquals(expected, result)

    }

    @Test
    fun removePost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        val expected = 2

        var copy = service.add(post)
        copy = service.add(copy)
        copy = service.add(copy)
        service.remove(1)

        val result = service.sizeWallPosts()
        assertEquals(expected, result)
    }

    @Test
    fun dislikePost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        val expected = 2

        var copy = service.add(post)
        copy = service.add(copy)
        service.dislikeById(1)

        val result = service.dislikeById(1)
        assertEquals(expected, result)

    }

    @Test
    fun updatePost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        val expected = Post (
            id = 1,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        service.add(post)
        val copy = post.copy(ownerId = 2, date = "18.12.2020" )
        service.add(copy)

        val isResult = service.update(expected)
        val result = service.get(expected.id)
        assertTrue(isResult && result.ownerId == copy.ownerId && result.date == copy.date)

    }


    @Test
    fun updatePostNotExistId() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        val expected = Post (
            id = 4,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        service.add(post)
        val copy = post.copy(ownerId = 2, date = "18.12.2020" )
        service.add(copy)

        assertFalse(service.update(expected))

    }

    @Test
    fun displayPostWithoutAttachment() {
        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = null
        )
        viewPost(post)

    }

    @Test
    fun checkPostAttachment() {
        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = null
        )

        val expected = "No attachment"

        val result = getPostAttachment(post)
        assertEquals(expected, result)
    }

    @Test
    fun checkPostEmptyAttachmentNoteText() {
        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = null
        )

        val expected = "none"

        val result = post.attachments?.get(0)?.type ?: "none"
//            getPostAttachmentNoteText(post)
        assertEquals(expected, result)
    }

    @Test
    fun checkPostAttachmentNoteText() {
        val note = Note(id = 0, ownerIid = 0, title = "Title 1", text = "Test text on Note 1",
                              date = 1609879870328798L, comments = 1, readComments = 0, viewUrl = "url_note")

        val photo = Photo(id = 0, ownerIid = 0, text = "Test text on Photo 1", date = 1609879870328798L,
                          albumIid = 12, userIid = 232, sizes = emptyArray(), width = 1920, height = 1080)

        val video = Video (id = 1, ownerId = 0, title = "Title Video 1", description = "video id 1",
                           duration = 12, image = emptyArray(), firstFrame = emptyArray(), date = 160872387L,
                           addingDate = 16078182349800L, views = 42, localViews = 24, comments = 3,
                           player = "", platform = "", canEdit = false, canAdd = false, isPrivate = false,
                           accessKey = "key", processing = false, isFavorite = false, canComment = false,
                           isCanEdit = false, canLike = false, canRepost = false, canSubscribe = false,
                           CanAddToFaves = false, canAttachLink = false, width = 1920, height = 1080, userId = 2,
                           converting = false, added = false, isSubscribed = false, repeat = true,
                           typeVideo = TypeVideo.VIDEO, balance = 3, liveStatus = LiveStatus.STARTED, live = false,
                           upcoming = false, spectators = 2, likes = LikesVideo(count = 3, userLikes = false),
                           reposts = Repost()
                           )

        var post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray() //arrayOf() //note, photo, video)
        )
        val expected = "Test text on Note 1"

        val attNote = NoteAttachment(value = note)
        post = post.copy(attachments = post.attachments?.plus(attNote))

        val attPhoto = PhotoAttachment(value = photo)
        post = post.copy(attachments = post.attachments?.plus(attPhoto))

        val attVideo = VideoAttachment(value = video)
        post = post.copy(attachments = post.attachments?.plus(attVideo))



        val noteAttachment = post.attachments?.get(0)
        if (noteAttachment is NoteAttachment) {
            val result = noteAttachment.value.text
            assertEquals(expected, result)
        }

    }

    @Test
    fun checkPostAttachmentPhotoText() {
        val note = Note(id = 0, ownerIid = 0, title = "Title 1", text = "Test text on Note 1",
            date = 1609879870328798L, comments = 1, readComments = 0, viewUrl = "url_note")

        val photo = Photo(id = 1, ownerIid = 0, text = "Test text on Photo 1", date = 1609879870328798L,
            albumIid = 12, userIid = 232, sizes = emptyArray(), width = 1920, height = 1080)

        val video = Video (id = 1, ownerId = 0, title = "Title Video 1", description = "video id 1",
            duration = 12, image = emptyArray(), firstFrame = emptyArray(), date = 160872387L,
            addingDate = 16078182349800L, views = 42, localViews = 24, comments = 3,
            player = "", platform = "", canEdit = false, canAdd = false, isPrivate = false,
            accessKey = "key", processing = false, isFavorite = false, canComment = false,
            isCanEdit = false, canLike = false, canRepost = false, canSubscribe = false,
            CanAddToFaves = false, canAttachLink = false, width = 1920, height = 1080, userId = 2,
            converting = false, added = false, isSubscribed = false, repeat = true,
            typeVideo = TypeVideo.VIDEO, balance = 3, liveStatus = LiveStatus.STARTED, live = false,
            upcoming = false, spectators = 2, likes = LikesVideo(count = 3, userLikes = false),
            reposts = Repost()
        )

        var post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray()
        )
        val expected = "Test text on Photo 1"

        val attNote = NoteAttachment(value = note)
        post = post.copy(attachments = post.attachments?.plus(attNote))

        val attPhoto = PhotoAttachment(value = photo)
        post = post.copy(attachments = post.attachments?.plus(attPhoto))

        val attVideo = VideoAttachment(value = video)
        post = post.copy(attachments = post.attachments?.plus(attVideo))

        val photoAttachment = post.attachments?.get(0)
        if (photoAttachment is PhotoAttachment) {
            val result = photoAttachment.value.text
            assertEquals(expected, result)
        }



    }


}