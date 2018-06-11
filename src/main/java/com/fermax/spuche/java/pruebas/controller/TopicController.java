package com.fermax.spuche.java.pruebas.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fermax.spuche.java.pruebas.model.*;
import com.fermax.spuche.java.pruebas.services.TopicService;

@RestController
public class TopicController
{
	
	@Autowired
	private TopicService topicService;

	@RequestMapping(value = "/hola", method = RequestMethod.GET)
	public String sayHi()
	{
		return "Hello world";
	}
	
	
	@RequestMapping(value = "/topics", method = RequestMethod.GET)
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics();
	}
	
	@RequestMapping(value = "/topics/{id}", method = RequestMethod.GET)
	public Topic getTopic(@PathVariable String id)
	{
		return topicService.getTopic(id);
	}
	
	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public void postTopic(@RequestBody Topic topic)
	{
		topicService.addTopic(topic);
	}
	
	@RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id)
	{
		topicService.updateTopic(id,topic);
	}
	
	@RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id)
	{
		topicService.deleteTopic(id);
	}
	
}
