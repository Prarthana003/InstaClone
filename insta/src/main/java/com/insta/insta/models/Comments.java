package com.example.instagram_clone.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("Comments")
public class Comments {
    
    public Integer commentId;
    public Integer postId;
    public String commentFromId;
    public String commentData;
	/*public Integer getCommentId() {
		return comment_id;
	}
	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}
	public Integer getPost_id() {
		return post_id;
	}
	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}
	public Integer getComment_from_id() {
		return comment_from_id;
	}
	public void setComment_from_id(Integer comment_from_id) {
		this.comment_from_id = comment_from_id;
	}
	@Override
	public String toString() {
		return "Comments [comment_id=" + comment_id + ", post_id=" + post_id + ", comment_from_id=" + comment_from_id
				+ "]";
	}
	public Comments(Integer comment_id, Integer post_id, Integer comment_from_id) {
		super();
		this.comment_id = comment_id;
		this.post_id = post_id;
		this.comment_from_id = comment_from_id;
	}
	public Comments() {
		super();
	}*/
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getCommentFromId() {
		return commentFromId;
	}
	public void setCommentFromId(String commentFromId) {
		this.commentFromId = commentFromId;
	}
	public String getCommentData() {
		return commentData;
	}
	public void setCommentData(String commentData) {
		this.commentData = commentData;
	}
	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", postId=" + postId + ", commentFromId=" + commentFromId
				+ ", commentData=" + commentData + "]";
	}
	public Comments(Integer commentId, Integer postId, String commentFromId, String commentData) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.commentFromId = commentFromId;
		this.commentData = commentData;
	}
	public Comments() {
		super();
	}
    
	
}
