package com.vikas.LRUCache;

public class CacheReturn {
	public CacheReturn(int key, int value, boolean fromHash) {
		super();
		this.key = key;
		this.value = value;
		this.fromHash = fromHash;
	}
	private int key;
	private int value;
	private boolean fromHash;
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public boolean isFromHash() {
		return fromHash;
	}
	public void setFromHash(boolean fromHash) {
		this.fromHash = fromHash;
	}

}
