package com.vikas.LRUCache;

public class MainDriverClass {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(5);
		for (int i =0; i<11;i++) {
			cache.set(i, i+20);
		}
		for (int i =0; i<13;i++) {
			CacheReturn ret = cache.get(i);
			if(ret.getValue()!=-1) {
				if(ret.isFromHash()){
					System.out.println(ret.getKey()+" Key Found in Hash="+ret.getValue());
				}
				else {
					System.out.println(ret.getKey()+" Key Found in File="+ret.getValue());
				}
				
			}
			else
			{
				System.out.println("KeyNotFound");
			}
			
			
		}

	}
}
