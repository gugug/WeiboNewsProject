package cn.ssm.po;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.ssm.service.MyFileUtil;
import cn.ssm.service.PathConfig;

/**
 * 获取聚类后的事件列表
 * @author gu
 *
 */
public class EventsNewsMoEntity {
	
	/**
	 * 从getEventsPath路径中获取事件的相关报道id 和 事件的标题
	 * @return eventsMap{id:events}
	 */
	public Map<String,Events> getEvents(){
		Map<String,Events> eventsMap = new HashMap<String,Events>();
		PathConfig pathConfig = new PathConfig();
		System.out.println("事件文件路径： "+pathConfig.getEventsPath());

//		System.out.println(EventsList.class.getResource("").getFile()); //获取该类的运行位置
		String[] fileArrays = MyFileUtil.getFileName(pathConfig.getEventsPath());
		System.out.println("事件总数： "+fileArrays.length);
		for (int i = 0; i < fileArrays.length; i++){
			String content = MyFileUtil.readFile(pathConfig.getEventsPath()+"/"+fileArrays[i]);
			String[] splitContent = content.split("`");
			splitContent[2] = splitContent[2].replace("\n", "");
			String[] newsId = splitContent[2].split(",");
			List<String> titlelist = Arrays.asList(newsId);
			Events events = new Events();
			events.setId(splitContent[0]);
			events.setTitle(splitContent[1]);
			events.setNews(titlelist);
			
			eventsMap.put(splitContent[0], events);
		}
		
		return eventsMap;
	}
	
	
	/**
	 * 从getNewsPath路径找到新闻的，分割包装成News对象
	 * @param newsId 新闻id
	 * @return news{id.title.news} 
	 */
	public News getNews(String newsId){
//		System.out.println("newsId"+newsId);
		PathConfig pathConfig = new PathConfig();
		String newsContent = MyFileUtil.readFile(pathConfig.getNewsPath() +"/" + newsId);
		String[] splitContent = newsContent.split("`");
		String id = splitContent[0];
		String newsTitle = getTitle(newsId);
		String newsString = splitContent[2];
		
//			System.out.println(id);
//			System.out.println(newsTitle);
//			System.out.println(newsString);
		
		News news = new News();
		news.setId(id);
		news.setTitle(newsTitle);
		news.setNews(newsString);
		
		return news;
	}
	
	/**
	 * 从传入的id获取到时间的实体和情感值
	 * @param eid 事件的id
	 * @return entityList [EntityMo]
	 */
	public List<EntityMo> getEntityEmo(String eid){
		List<EntityMo> entityList = new ArrayList<EntityMo>();

		PathConfig pathConfig = new PathConfig();
		String newsContent = MyFileUtil.readFile(pathConfig.getEntityEmoPath() +"/" + eid);
		String[] splitContent = newsContent.split("\n");
		for(String sc : splitContent){
			EntityMo entityMo = new EntityMo();
			String[] oneEntity = sc.split(" ");
			entityMo.setEntity(oneEntity[0]);
			entityMo.setPastiveMo(oneEntity[1]);
			entityMo.setNegativeMo(oneEntity[2]);
//			System.out.println(oneEntity[0]);
//			System.out.println(oneEntity[1]);
//			System.out.println(oneEntity[2]);

			entityList.add(entityMo);
		}
		return entityList;
	}
	
	public String getTitle(String id){
		PathConfig pathConfig = new PathConfig();
		String newsContent = MyFileUtil.readFile(pathConfig.getLabelPath() +"/" + id);
		String[] splitContent = newsContent.split("\n");
		String title = splitContent[0];
//		System.out.println(title);
		return title;
		
	}
	
	public String getComment(String nid){
		PathConfig pathConfig = new PathConfig();
		String commentsContent = MyFileUtil.readFile(pathConfig.getCommentsPath() +"/" + nid);
//		System.out.println(commentsContent);
		return commentsContent;
		
	}
	
	public static void main(String[] args) {
		EventsNewsMoEntity evevtsList = new EventsNewsMoEntity();
		evevtsList.getComment("10000.txt");
		
	}
	
}
