package com.insta.insta.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "postList")
public class PostList {

	@Id
	private String id;

	@Field("postId")
	private  String postId;

	private List<String> postList = new ArrayList<>();

	// Getter and setter methods

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public  String getPostId(){
		return postId;
	}
	public  void setPostId(String postId){
		this.postId = postId;
	}

	public List<String> getPostList() {
		return postList;
	}

	public void setPostList(List<String> postList) {
		this.postList = postList;

	}

	public void dispay(){
		for(String id: this.postList){
			System.out.println(id);
		}
	}

	public void addPost(String postId) {
		this.postList.add(postId);
	}
}
