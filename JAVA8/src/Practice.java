import java.util.HashMap;
import java.util.Map;

public class Practice {
	/*
	 * 1.adding element 
	 * 2.iterating the element 
	 * 3.searching 
	 * 4.sorting 
	 * 5.deleting
	 */
	public static void main(String[] args) {
		/*
		 * List<Integer> list = new ArrayList<Integer>(); list.add(14); list.add(43);
		 * list.add(4); list.add(40);
		 * list.stream().forEach((element)->System.out.println(element));
		 * System.out.println(list);
		 * 
		 * List li = list.stream().filter(item->(item!=4)).collect(Collectors.toList());
		 * System.out.println(li); System.out.println(list.removeAll(li));
		 * System.out.println(list);
		 */
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("india", 5);
		map.put("france", 3);
		map.put("japan", 11);
		map.put("italy", 8);
		/*
		 * Iterator<String> iterator = map.keySet().iterator(); while
		 * (iterator.hasNext()) { String country = iterator.next();
		 * if(map.get(country)<=3) { System.out.printf("removing %s gdp ",country);
		 * iterator.remove(); } }
		 */
		
		/*
		 * Map<String, Integer> m =
		 * map.entrySet().stream().filter(entry->entry.getValue()<=3)
		 * .collect(Collectors.toMap(en->en.getKey(), en->en.getValue()));
		 * 
		 * System.out.println(m);
		 */
		map.entrySet().removeIf(en->en.getKey().equals("india"));
		
		System.out.println(map);

	}

}
