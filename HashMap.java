
public class HashMap {
	private Object[] values;
	private int valuesPresent;
	
	public HashMap(int size) {
		values = new Object[size];
	}
	
	//If there is a collision, do not set. Simply return false.
	/**
	 * Add the object to the HashMap at the given key mapping. 
	 * If there is already an object at that location, abort the action and return false.
	 * @param key – Arbitrary String by which to retrieve the object from the map.
	 * @param value – The object to be stored to the HashMap and retrieved by the key.
	 * @return true if the object was able to be stored in the HashMap.
	 */
	public boolean set(String key, Object value){
		int index = generateIndex(key);
		if (values[index]!=null)
			return false;
		values[index] = value;
		valuesPresent++;
		return true;
	}
	
	/**
	 * Get the object stored in the HashMap at the given key mapping.
	 * @param key – Arbitrary String by which to retrieve the object from the map.
	 * @return The object mapped to that key, or null.
	 */
	public Object get(String key){
		return values[generateIndex(key)];
	}
	
	/**
	 * Delete the value mapped for the given key. Returns null if the key has no value.
	 * @param key – Arbitrary String by which to retrieve the object from the map.
	 * @return  The object deleted, or null if no object was mapped to the given key.
	 */
	public Object delete(String key){
		int index = generateIndex(key);
		Object removedObject = values[index];
		if (removedObject != null){
			values[index] = null;
			valuesPresent--;
		}
		return removedObject;
	}
	/**
	 * @return Float representing the proportion of the HashMap that has been occupied by values.
	 */
	public float load(){
		return (float)valuesPresent / values.length;
	}
	
	private int generateIndex(String key){
		int hash = key.hashCode();
		//must be positive.
		return (hash>>>1) % values.length;
	}
}
