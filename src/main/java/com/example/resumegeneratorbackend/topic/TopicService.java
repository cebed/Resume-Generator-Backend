package com.techprimers.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class TopicService {
	


private List<Topic>  topics = new ArrayList<>
	 (Arrays.asList(
			new Topic ("hej","på","dig"),
			new Topic ("hej2","på","dig"),
			new Topic ("hej3","på","dig")		
			));
	
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}

	public void uppdateTopic(String id, Topic topic) {
		for(int i = 0 ; i< topics.size(); i ++){
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}

			
		}
		
	}
	public void deleteTopic(String id) {
		//topics.remove(t -> t.getId().equals(id));
	}
	
	
}
