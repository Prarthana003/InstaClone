package com.insta.insta.models;



import org.springframework.data.mongodb.core.mapping.Document;


@Document("Likes")
public class Likes {
   
    public Integer likeId;
    public Integer postId;
    public String likeFromId;
	public Integer getLikeId() {
		return likeId;
	}
	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getLikeFromId() {
		return likeFromId;
	}
	public void setLikeFromId(String likeFromId) {
		this.likeFromId = likeFromId;
	}
	@Override
	public String toString() {
		return "Likes [like_id=" + likeId + ", post_id=" + postId + ", like_from_id=" + likeFromId + "]";
	}
	public Likes(Integer like_id, Integer post_id, String like_from_id) {
		super();
		this.likeId = like_id;
		this.postId = post_id;
		this.likeFromId = like_from_id;
	}
	public Likes() {
		super();
	}
    
}
