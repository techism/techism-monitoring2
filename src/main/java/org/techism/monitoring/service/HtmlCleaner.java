package org.techism.monitoring.service;

import org.apache.commons.lang3.NotImplementedException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.springframework.stereotype.Component;

@Component
public class HtmlCleaner {
	
	public String cleanHtml (Document doc, String checkUrl){
		removeHtmlComments(doc);
		remove_hidden_fields(doc);
		remove_images(doc);
		//remove_sessionids_and_csrftoken(doc);
		remove_iframes(doc);
		Element bodyElement = doc.getElementsByTag("body").first();
		String body = pageSpecificCleanups(bodyElement, checkUrl);
		return body;
	}
	
	private void removeHtmlComments(Node node) {
        for (int i = 0; i < node.childNodes().size();) {
            Node child = node.childNode(i);
            if (child.nodeName().equals("#comment"))
                child.remove();
            else {
                removeHtmlComments(child);
                i++;
            }
        }
    }    
	
    public void remove_hidden_fields (Document document){
    	document.select("a[type=hidden]").remove();
    }

    public void remove_images (Document node){
    	node.select("img").remove();
    }
    
    
    public void remove_sessionids_and_csrftoken(Node node){
    	throw new NotImplementedException("");
    }
    
    public void remove_iframes (Document document){
    	document.select("iframe").remove();
    }
	
	private String pageSpecificCleanups(Element bodyElement, String checkurl) {
		if (checkurl.contains("opensourcetreffe")) {

		} else if (checkurl.contains("munichdot")) {

		}
		return bodyElement.html();
	}

}
