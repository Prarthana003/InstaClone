package com.insta.insta.models;



import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.sql.Timestamp;


@Document("Posts")
@TypeAlias("Posts")
public class Posts {
	
	@Id
    public String postId;
    public String userID;
	/*public Object _id;
    public Object get_id() {
		return _id;
	}
	public void set_id(Object _id) {
		this._id = _id;
	}*/
	public String contentType;
	public Binary image;
	public Binary video;
//    public Timestamp timeStamp;
    //@DBRef
    public List<Integer> likes;
    
    //@DBRef
    public List<Integer> comments;
	public Posts(String  postId, String userID, String contentType, Binary image,Binary video, Timestamp timeStamp,
			List<Integer> likes, List<Integer> comments) {
		super();
		this.postId = postId;
		this.userID = userID;
		this.contentType = contentType;
		this.image = image;
		this.video=video;
//		this.timeStamp = timeStamp;
		this.likes = likes;
		this.comments = comments;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

	
    
   
    public Posts() {
		super();
	}
	@Override
	public String toString() {
		return "Posts [post_id=" + postId + ", content_type=" + contentType
				+ ", likes=" + likes + ", comments=" + comments + "]";
	}
	
	public String  getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
//	public Timestamp getTimeStamp() {
//		return timeStamp;
//	}
//	public void setTimeStamp(Timestamp timeStamp) {
//		this.timeStamp = timeStamp;
//	}
	public List<Integer> getLikes() {
		return likes;
	}
	public void setLikes(List<Integer> likes) {
		this.likes = likes;
	}
	public List<Integer> getComments() {
		return comments;
	}
	public void setComments(List<Integer> comments) {
		this.comments = comments;
	}
	public Binary getImage() {
        return image;
    }

	public void setImage(Binary image) {
	    this.image = image;
	}
	
	
	public Binary getVideo() {
        return video;
    }

	public void setVideo(Binary video) {
	    this.video = video;
	}
}
