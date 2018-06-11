package com.fermax.spuche.java.pruebas.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fermax.spuche.java.pruebas.model.Topic;

@Service
public class TopicService
{

	
	private List<Topic> topicsList= new ArrayList<Topic> (Arrays.asList(
				new Topic("SW","Software","Todo lo relacionado con la creación de software"),
				new Topic("HW","Hardware","Todo lo relacionado con el desarrollo y principios del hardware"),
				new Topic("SO","Sistemas operativos","Alrededor de la creación, principios básicos e historia de los sistemas operativos")
				));
	
	
	
	public List<Topic> getAllTopics()
	{
		return topicsList;
	}
	
	public Topic getTopic(String id)
	{
		return topicsList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic)
	{
		topicsList.add(topic);
	}
	
	public void updateTopic(String id, Topic topic)
	{
		for(int i = 0; i<topicsList.size();i++)
		{
			Topic t = topicsList.get(i);
			if(t.getId().equals(id))
			{
				topicsList.set(i, topic);
				return;
			}
		}
	}
	
	public void deleteTopic(String id)
	{
		for(int i=0;i<topicsList.size();i++)
		{
			Topic t = topicsList.get(i);
			if(t.getId().equals(id))
			{
				topicsList.remove(i);
				return;
			}
		}
	}

}
