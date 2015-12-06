package com.vikas.LRUCache;

import java.util.HashMap;

public class LRUCache {
	int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head=null;
    Node end=null;
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
 
    public CacheReturn get(int key) {
    	CacheReturn ret = new CacheReturn(key,-1,false); //Base condition for key not in hash or File
        if(map.containsKey(key)){		//Key is present in hash map
            Node node = map.get(key);
            remove(node);
            setHead(node);
            ret.setValue(node.value);
            ret.setFromHash(true);
        }
        else {		//Check if key is present in file
        	String str=FileUtils.readFromFile(key);
        	if(str !=null) { //Key Is there in File
        		ret.setValue(Integer.parseInt(str)); //Set the value of Return
        		set(key,Integer.parseInt(str));
        	}
        	
        }
 
        return ret;
    }
 
    public void remove(Node n){
        if(n.previous!=null){
            n.previous.next = n.next;
        }else{
            head = n.next;
        }
 
        if(n.next!=null){
            n.next.previous = n.previous;
        }else{
            end = n.previous;
        }
 
    }
 
    public void setHead(Node n){
        n.next = head;
        n.previous = null;
 
        if(head!=null)
            head.previous = n;
 
        head = n;
 
        if(end ==null)
            end = head;
    }
 
    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(map.size()>=capacity){
            	FileUtils.writeToFile(end); //Write the content to the file
                map.remove(end.key);
                remove(end);
                
                setHead(created);
 
            }else{
                setHead(created);
            }    
 
            map.put(key, created);
        }
    }

}
